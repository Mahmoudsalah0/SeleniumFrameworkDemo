package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import data.ExcelReader;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegisterationWithDDTAndExcel extends TestBase {

	HomePage homeObject ; 
	UserRegistrationPage registerObject ; 
	LoginPage loginObject ; 


	@DataProvider(name="ExcelData")
	public Object [][]userRegisterData() throws IOException{

		ExcelReader Er = new ExcelReader();
		return Er.getExcelData();
	}


	@Test(priority=1,alwaysRun=true,dataProvider = "ExcelData")
	public void UserCanRegisterSuccssfully(String firstname,String lastname,String email ,String password)
	{
		homeObject = new HomePage(driver); 
		homeObject.openRegistrationPage();
		registerObject = new UserRegistrationPage(driver); 
		registerObject.userRegistration(firstname,lastname,email,password);
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
		registerObject.userLogout();
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver); 
		loginObject.UserLogin(email,password);
		Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
		registerObject.userLogout();

	}
}
