package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ComparePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class AddProrductToCompareTest extends TestBase{

	
	String FirstProductName ="Apple MacBook Pro 13-inch";
	String SecondProductName = "Asus N551JK-XO076H Laptop";
	
	ProductDetailsPage deatailsObject ;
	SearchPage searchObject ;
	ComparePage CompareObject ;
	
	@Test(priority=1)
	public void UserCanCompareProducts() throws InterruptedException {
		
		searchObject = new SearchPage(driver);
		CompareObject = new ComparePage(driver);
		deatailsObject = new ProductDetailsPage(driver);
		
		searchObject.ProductSearchUseingAutoSuggest(FirstProductName);
		Thread.sleep(3000);
	//	Assert.assertTrue(deatailsObject.ProductName.getText().contains(FirstProductName));
		deatailsObject.ClickCompareBtn();

		searchObject.ProductSearchUseingAutoSuggest(SecondProductName);
	//	Assert.assertTrue(deatailsObject.ProductName.getText().contains(SecondProductName));
		Thread.sleep(3000);
		deatailsObject.ClickCompareBtn();
		deatailsObject.OpenComparePage();
		
		Assert.assertTrue(CompareObject.FirstProductName.getText().equals("Apple MacBook Pro 13-inch"));
		Assert.assertTrue(CompareObject.SecondProductName.getText().equals("Asus N551JK-XO076H Laptop"));
	}
	
	@Test(priority=2)
	public void UserCanClearCompareList() {
		CompareObject.ClearCompareList();
		Assert.assertTrue(CompareObject.NoData.getText().contains("You have no items to compare."));
	}
}