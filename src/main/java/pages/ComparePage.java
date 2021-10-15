package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ComparePage extends PageBase{

	public ComparePage(WebDriver driver) {
		super(driver);
	}


	@FindBy(xpath="/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div/table/tbody/tr[3]/td[3]")
	public WebElement FirstProductName;

	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div/table/tbody/tr[3]/td[2]")
	public WebElement SecondProductName ;

	@FindBy(xpath="/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div/table/tbody")
	WebElement Table;

	@FindBy(xpath="/html/body/div[6]/div[3]/div/div[2]/div/div[2]/a")
	WebElement clearlist;

	@FindBy(xpath="/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div")
	public WebElement NoData;

	@FindBy(tagName = "tr")
	public List<WebElement> allRows;

	@FindBy(tagName = "td")
	public List<WebElement> allColoms;


	public void ClearCompareList() {
		clickButton(clearlist);
	}

	public void CompareProduct() {
		System.out.println(allRows.size());

		for(WebElement row: allRows) {
			System.out.println(row.getText()+"\t");
			for(WebElement colom : allColoms) {
				System.out.println(colom.getText()+"\t");
			}
		}
	}

}
