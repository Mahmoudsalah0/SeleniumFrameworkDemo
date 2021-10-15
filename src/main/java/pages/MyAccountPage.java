package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBase {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(linkText = "Change password")
	WebElement changePasswordLink;

	@FindBy(id = "OldPassword")
	WebElement oldPasswordTxt;

	@FindBy(id = "NewPassword")
	WebElement NewPasswordTxt ;

	@FindBy(id = "ConfirmNewPassword")
	WebElement confirmPasswordTxt;

	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div[2]/div/div[2]/form/div[2]/button")
	WebElement ChangePasswordBtn;

	@FindBy(xpath = "//*[@id=\"bar-notification\"]/div/p")
	public WebElement resultb1;
	
	@FindBy(xpath = "//*[@id=\"bar-notification\"]/div/span")
	WebElement ExitSuccessChanged;	


	public void openChangePasswordPage() {
		clickButton(changePasswordLink);
	}
	public void ChangePassword(String oldPassword,String NewPassword) {
		setTextElementText(oldPasswordTxt,oldPassword);
		setTextElementText(NewPasswordTxt,NewPassword);
		setTextElementText(confirmPasswordTxt,NewPassword);
		clickButton(ChangePasswordBtn);
		clickButton(ExitSuccessChanged);

	}


}
