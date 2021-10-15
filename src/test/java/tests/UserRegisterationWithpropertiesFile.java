package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import data.LoadProperities;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegisterationWithpropertiesFile extends TestBase {

	HomePage homeObject ; 
	UserRegistrationPage registerObject ; 
	LoginPage loginObject ; 
    String fn = LoadProperities.userData.getProperty("firstname");
    String ln = LoadProperities.userData.getProperty("lastname");
    String em = LoadProperities.userData.getProperty("email");
    String pass = LoadProperities.userData.getProperty("password");
    
    


	@Test(priority=1,alwaysRun=true)
	public void UserCanRegisterSuccssfully() 
	{
		homeObject = new HomePage(driver); 
		homeObject.openRegistrationPage();
		registerObject = new UserRegistrationPage(driver); 
		registerObject.userRegistration(fn, ln, em, pass);
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
	}

	@Test(dependsOnMethods= {"UserCanRegisterSuccssfully"})
	public void RegisteredUserCanLogout() 
	{
		registerObject.userLogout();
	}

	@Test(dependsOnMethods= {"RegisteredUserCanLogout"})
	public void RegisteredUserCanLogin() 
	{
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver); 
		loginObject.UserLogin(em, pass);
		Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
	}
}