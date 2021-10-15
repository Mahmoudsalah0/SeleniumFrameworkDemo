package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class ChangeCurrancyTest extends TestBase {

	HomePage homeObject ;
	ProductDetailsPage detailsObject ;
	String productName = "Apple MacBook Pro 13-inch";
	SearchPage searchObject ;
	ProductDetailsPage deatailsObject ;

	@Test(priority = 1)

	public void UserCanChangeCurrancy() {
		homeObject =new HomePage(driver);
		homeObject.changeCurrency();
	}

	@Test(priority = 2)
	public void userCanSearchWithAutoSuggest() {

		try {
			searchObject = new SearchPage(driver);
			searchObject.ProductSearchUseingAutoSuggest("MacB");
			deatailsObject = new ProductDetailsPage(driver);
			Assert.assertEquals(deatailsObject.ProductName.getText(), productName);
			Assert.assertTrue(detailsObject.PriceValue.getText().contains("€"),"Error Changeing Currancy");
			System.out.println(detailsObject.PriceValue.getText());
		} catch (Exception e) {
			System.out.println("Error Occoured : "+ e.getMessage());
		}
	}

}
