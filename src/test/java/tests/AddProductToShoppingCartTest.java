package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.ShoppingCartPage;

public class AddProductToShoppingCartTest extends TestBase {
	
	
	String Quantity = "2";
	ShoppingCartPage cartObject;
	SearchPage searchObject ;
	ProductDetailsPage deatailsObject ;
	String productName = "Apple MacBook Pro 13-inch";
	
	
	@Test(priority = 1)
	public void userCanSearchWithAutoSuggest() {

			searchObject = new SearchPage(driver);
			searchObject.ProductSearchUseingAutoSuggest("MacB");
			deatailsObject = new ProductDetailsPage(driver);
			Assert.assertEquals(deatailsObject.ProductName.getText(), productName);
	}
	
	@Test(priority = 2)
	public void UserCanAddProductToCart() {
		deatailsObject = new ProductDetailsPage(driver);
		deatailsObject.AddToCart();
		cartObject = new ShoppingCartPage(driver);
		Assert.assertTrue(cartObject.Total.getText().contains("$3,600.00"));
	}
	
	@Test(priority = 3)
	public void UserCanRemoveProductFromCart() {
		cartObject = new ShoppingCartPage(driver);
		cartObject.RemoveProduct();
		//Assert.assertTrue(false);e
	}


}
