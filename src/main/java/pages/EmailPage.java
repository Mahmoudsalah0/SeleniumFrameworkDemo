package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailPage extends PageBase {

	public EmailPage(WebDriver driver) {
		super(driver);
	}
	@FindBy (id = "FriendEmail")
	private WebElement Email;

	@FindBy (id = "PersonalMessage")
	private WebElement TheMessage;
	
	@FindBy (xpath  = "/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[2]/button")
	private WebElement sendEmailBtn;

	@FindBy(xpath  = "/html/body/div[6]/div[3]/div/div/div/div[2]/div[2]")
	public WebElement SucessMsg;

	public void SendEmailToFriend(String Emailfriend, String msgFriend) {

		setTextElementText(Email, Emailfriend);
		setTextElementText(TheMessage, msgFriend);
		clickButton(sendEmailBtn);
	}
}
