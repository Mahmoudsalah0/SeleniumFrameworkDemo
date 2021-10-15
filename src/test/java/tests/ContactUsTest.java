package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ContactUsPage;
import pages.HomePage;

public class ContactUsTest extends TestBase{

	HomePage home;
	ContactUsPage contactPage ;

	String YourName = "MahmoudSalah";
	String YourEmail = "Salahco@gmail.com";
	String Enquiry = "SomeThing is Wrong";

	@Test
	public void UserCanUseContactUs() {

		home = new HomePage(driver);
		contactPage = new ContactUsPage(driver);
		home.openContactUsPage();
		contactPage.ContactUs(YourName, YourEmail, Enquiry);
		Assert.assertTrue(contactPage.SuccessMsg.getText().contains("Your enquiry has been successfully sent to the store owner"));
	}
}