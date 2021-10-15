package tests;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.UserRegistrationPage;
import pages.WishlistPage;

public class AddProductToWishlistTest extends TestBase {

	WishlistPage wishlistObject ;
	HomePage homeObject ; 
	UserRegistrationPage registerObject ; 
	SearchPage searchObject ;
	ProductDetailsPage deatailsObject ;
	String productName = "Apple MacBook Pro 13-inch";

	@Test(priority =1)
	public void UserCanRegisterSuccssfully() 
	{
		homeObject = new HomePage(driver); 
		homeObject.openRegistrationPage();
		registerObject = new UserRegistrationPage(driver); 
		registerObject.userRegistration("Mahmoud", "Salah", "test7734@gmail.com", "12345678");
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
	}


	@Test(priority =2)
	public void userCanSearchWithAutoSuggest() {

		try {
			searchObject = new SearchPage(driver);
			searchObject.ProductSearchUseingAutoSuggest("MacB");
			deatailsObject = new ProductDetailsPage(driver);
			Assert.assertEquals(deatailsObject.ProductName.getText(), productName);
		} catch (Exception e) {
			System.out.println("Error Occoured : "+ e.getMessage());
		}
	}

	@Test(priority = 3)
	public void UserCanAddProductToWishlist() {
		wishlistObject =new WishlistPage(driver);
		deatailsObject = new ProductDetailsPage(driver);
		deatailsObject.AddToWishlist();
		deatailsObject.openWishlist();
		assertTrue(wishlistObject.WishlistHeader.isDisplayed());
		assertTrue(wishlistObject.productname.getText().contains(productName));
	}

	@Test(priority = 5)
public void UserCanRemoveProductFromWishlist() {
		wishlistObject =new WishlistPage(driver);
		wishlistObject.RemoveProductFromWishlist();
		Assert.assertTrue(wishlistObject.noData.getText().contains("The wishlist is empty!"));
	}

	@Test(priority =6 )
	public void RegisteredUserCanLogout() 
	{
		registerObject.userLogout();
	}
}
