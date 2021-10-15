package steps;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CheckOutPage;
import pages.HomePage;
import pages.OrderDetailsPage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.ShoppingCartPage;
import tests.TestBase;

public class E2ETests extends TestBase {
	SearchPage searchObject ;
	ProductDetailsPage detailsObject ;
	HomePage homeObject ;
	ShoppingCartPage cartObject ;
	CheckOutPage checkoutObject;
	String productName = "Apple MacBook Pro 13-inch";
	OrderDetailsPage orderObject;
	

	@Given("user is on Home Page")
	public void user_is_on_home_page() {
		Assert.assertTrue(driver.getCurrentUrl().contains("nopCommerce"));
	}
	@When("he search for {string}")
	public void he_search_for(String ProductName) {
		searchObject = new SearchPage(driver);
		searchObject.ProductSearchUseingAutoSuggest(ProductName);
		detailsObject = new ProductDetailsPage(driver);
		Assert.assertTrue(detailsObject.ProductName.getText().contains(ProductName));
	}
	@When("choose to buy two items")
	public void choose_to_buy_two_items() {
		cartObject = new ShoppingCartPage(driver);
		detailsObject.AddToCart();
		driver.navigate().to("https://demo.nopcommerce.com/cart");
	}
	@When("Moves to checkout cart and enter personal information on checkout page and place the order")
	public void moves_to_checkout_cart_and_enter_personal_information_on_checkout_page_and_place_the_order() throws InterruptedException {
		checkoutObject = new CheckOutPage(driver);
		cartObject.openCheckoutPageAsGuest();
		checkoutObject.CheckoutProduct("test", "user", "Egypt"
				, "testuser231@test.com", "test address", "123456", "32445566677", "Cairo", productName);
		Assert.assertTrue(checkoutObject.prodcutName.isDisplayed());
		Assert.assertTrue(checkoutObject.prodcutName.getText().contains(productName));
		checkoutObject.confirmOrder();
		Assert.assertTrue(checkoutObject.ThankYoulbl.isDisplayed());


	}
	@Then("He can view the order and download the invoice")
	public void he_can_view_the_order_and_download_the_invoice() throws InterruptedException {
		orderObject = new OrderDetailsPage(driver);
		checkoutObject.viewOrderDetails();
		Assert.assertTrue(driver.getCurrentUrl().contains("orderdetails"));
		orderObject.DownloadPDFInvoice();
		Thread.sleep(3000);
		orderObject.PrintOrderDetails();
	}
}
