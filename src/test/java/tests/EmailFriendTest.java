package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.EmailPage;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.UserRegistrationPage;

public class EmailFriendTest extends TestBase {

	EmailPage emailObject ;
	HomePage homeObject ; 
	UserRegistrationPage registerObject ; 
	SearchPage searchObject ;
	ProductDetailsPage deatailsObject ;
	String productName = "Apple MacBook Pro 13-inch";
	String Emailfriend = "asd@hgf.com";
	String msgFriend = "Look at this one it's fit for you";

	@Test(priority =1)
	public void UserCanRegisterSuccssfully() 
	{
		homeObject = new HomePage(driver); 
		homeObject.openRegistrationPage();
		registerObject = new UserRegistrationPage(driver); 
		registerObject.userRegistration("Mahmoud", "Salah", "test8734@gmail.com", "12345678");
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


	@Test(priority =3)
	public void RegisterdUserCanSendProductToFriend() {

		deatailsObject.openEmailFriendPage();
		emailObject = new EmailPage(driver);
		emailObject.SendEmailToFriend( Emailfriend, msgFriend);
		Assert.assertTrue(emailObject.SucessMsg.getText().contains("Your message has been sent"), "Wrong area");

	}


	@Test(priority =4 )
	public void RegisteredUserCanLogout() 
	{
		registerObject.userLogout();
	}


}
