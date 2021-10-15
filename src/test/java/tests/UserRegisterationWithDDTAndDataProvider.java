package tests;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;
public class UserRegisterationWithDDTAndDataProvider extends TestBase{



	HomePage homeObject ; 
	UserRegistrationPage registerObject ; 
	LoginPage loginObject ; 

	@DataProvider(name="testData")
	public static Object[][] userData(){
		return new Object[][] {
			{"Mahmoud","Salah","test1834@gmail.com","123456"},
			{"AHmed","Salah","test3392@gmail.com","123456"}
		};
	}

	@Test(priority=1,alwaysRun=true,dataProvider = "testData")
	public void UserCanRegisterSuccssfully(String fName,String lName,String Email,String password) 
	{
		homeObject = new HomePage(driver); 
		homeObject.openRegistrationPage();
		registerObject = new UserRegistrationPage(driver); 
		registerObject.userRegistration(fName,lName,Email,password);
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
		registerObject.userLogout();
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver); 
		loginObject.UserLogin(Email,password);
		Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
		registerObject.userLogout();
	}}