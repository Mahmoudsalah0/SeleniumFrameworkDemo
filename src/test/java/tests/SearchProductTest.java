package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchProductTest extends TestBase{
	
	String ProductName = "Apple MacBook Pro 13-inch" ;
	SearchPage searchObject ;
	ProductDetailsPage detailsObject ;
	
	@Test
	public void UserCanSearchForProducts(){
		
		detailsObject = new ProductDetailsPage(driver);
		searchObject = new SearchPage(driver);
		searchObject.ProductSearch(ProductName);
		Assert.assertTrue(detailsObject.ProductName.getText().equalsIgnoreCase(ProductName));
		//Assert.assertEquals(detailsObject.ProductName.getText(), ProductName);
	}

}
