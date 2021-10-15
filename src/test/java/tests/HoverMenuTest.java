package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;

public class HoverMenuTest extends TestBase{
	
	HomePage homeObject;
	
	@Test
	public void UserCanSubCategoryFromMainMenu() throws InterruptedException {
	
		homeObject = new HomePage(driver);
		homeObject.selectNotebooksMenu();
		System.out.println(driver.getCurrentUrl());
		Assert.assertTrue(driver.getCurrentUrl().contains("notebook"), "Wrong Area");
		
	}
}