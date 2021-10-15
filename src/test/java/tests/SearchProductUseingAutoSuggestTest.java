package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchProductUseingAutoSuggestTest extends TestBase {
	String productName = "Apple MacBook Pro 13-inch";
	SearchPage searchObject ;
	ProductDetailsPage deatailsObject ;

	@Test
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
}
