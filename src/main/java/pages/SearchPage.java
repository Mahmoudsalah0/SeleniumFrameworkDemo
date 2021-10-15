package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends PageBase{

	public SearchPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(id = "small-searchterms")
	WebElement searchTxtBox ;
	
	@FindBy(xpath = "//*[@id=\"small-search-box-form\"]/button")
	WebElement searchBtn ;
	
	@FindBy(id = "ui-id-1")
	java.util.List<WebElement> productList;
	
	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div/div/div[1]/a/img")
	WebElement clickOnMacProduct;
	
	
	public void ProductSearch(String ProductName) {
		setTextElementText(searchTxtBox, ProductName);
		clickButton(searchBtn);
		clickButton(clickOnMacProduct);
	}
	public void ProductSearchUseingAutoSuggest(String SearchTxt) {
		setTextElementText(searchTxtBox, SearchTxt);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		productList.get(0).click();
	}
}
