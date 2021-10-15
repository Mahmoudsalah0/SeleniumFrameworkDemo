package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.UserRegistrationPage;
public class MyAccountTest extends TestBase{
	HomePage homeObject ; 
	UserRegistrationPage registerObject ; 
	MyAccountPage myAccountObject;
	String oldPAssword = "1234567";
	String NewPassword = "123456";
String firstName = "Mahmoud";
String lastName = "Salah" ;
String email = "test0323@gmail.com";
LoginPage loginObject ; 
		

	@Test(priority=1)
	public void UserCanRegisterSuccssfully() 
	{
		homeObject = new HomePage(driver); 
		homeObject.openRegistrationPage();
		registerObject = new UserRegistrationPage(driver); 
		registerObject.userRegistration(firstName, lastName, email,oldPAssword);
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
	}
	
	@Test(priority = 2)
	public void RegisterUserCanChangePassword(){
		myAccountObject = new MyAccountPage(driver);
		registerObject.openMyAccountPage();
		myAccountObject.openChangePasswordPage();
		myAccountObject.ChangePassword(oldPAssword, NewPassword);
		Assert.assertTrue(myAccountObject.resultb1.getText().contains("Password was changed"));
	}
	
	@Test(priority = 3)
	public void RegisteredUserCanLogout() 
	{
		registerObject.userLogout();
	}
	
	@Test(priority = 4)
	public void RegisteredUserCanLogin() 
	{
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver); 
		loginObject.UserLogin(email,NewPassword);
		Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
	}
}
