package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductReviewPage extends PageBase {

	public ProductReviewPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "AddProductReview_Title")
	WebElement ReviewTitle;
	
	@FindBy(id = "addproductrating_4")
	WebElement Rating;
	
	@FindBy(id = "AddProductReview_ReviewText")
	WebElement ReviewText;
	
	@FindBy(xpath = "//*[@id=\"review-form\"]/form/div[2]/button")
	WebElement SubmittBtn;
	
	@FindBy(xpath  = "/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]")
	public WebElement SuccessReview;
	

	public void AddProductReview(String title, String Text) {
		setTextElementText(ReviewTitle, title);
		setTextElementText(ReviewText, Text);
		clickButton(SubmittBtn);
	}
}


