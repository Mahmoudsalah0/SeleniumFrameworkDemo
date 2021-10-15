package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailsPage;
import pages.ProductReviewPage;
import pages.SearchPage;
import pages.UserRegistrationPage;

public class AddProductReviewTest extends TestBase{

	ProductReviewPage reviewObject ;
	HomePage homeObject ; 
	UserRegistrationPage registerObject ; 
	SearchPage searchObject ;
	ProductDetailsPage deatailsObject ;
	String productName = "Apple MacBook Pro 13-inch";
	String registerEmail = "Test223@gmail.com";
	String title = "Review";
	String Text = "Good Product";
	@Test(priority =1)
	public void UserCanRegisterSuccssfully() 
	{
		homeObject = new HomePage(driver); 
		homeObject.openRegistrationPage();
		registerObject = new UserRegistrationPage(driver); 
		registerObject.userRegistration("Mahmoud", "Salah", registerEmail, "12345678");
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
	public void RegisterUserCanReviewProduct() {
		deatailsObject = new ProductDetailsPage(driver);
		reviewObject =new ProductReviewPage(driver);
		deatailsObject.ClickAddReview();
		reviewObject.AddProductReview(title, Text);
		Assert.assertTrue(reviewObject.SuccessReview.getText().contains("Product review is successfully added"),"Wrong setting Review");
	}
	
	
	@Test(priority =4 )
	public void RegisteredUserCanLogout() 
	{
		registerObject.userLogout();
	}


}
