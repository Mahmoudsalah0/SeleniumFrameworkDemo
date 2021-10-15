package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends PageBase {

	public ContactUsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id ="FullName" )
	private WebElement Name;

	@FindBy(id = "Email")
	private WebElement Email;

	@FindBy(id = "Enquiry")
	private WebElement enquiry;

	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[2]/button")
	private WebElement SubmittBtn;

	@FindBy(css = "div.result")
	public WebElement SuccessMsg;


	public void ContactUs(String YourName ,String YourEmail,String Enquiry) {

		setTextElementText(Name, YourName);
		setTextElementText(Email, YourEmail);
		setTextElementText(enquiry, Enquiry);
		clickButton(SubmittBtn);
	}
}
