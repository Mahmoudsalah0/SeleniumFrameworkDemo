package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends PageBase
{

	public ShoppingCartPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//*[@id=\"shopping-cart-form\"]/div[1]/table/tbody/tr/td[7]/button")
	WebElement RemoveBtn;

	@FindBy(id = "itemquantity11225")
	public WebElement QuntityTxt;

	@FindBy(xpath="//*[@id=\"shopping-cart-form\"]/div[1]/table/tbody/tr/td[6]/span")
	public WebElement Total;

	@FindBy(xpath="/html/body/div[6]/div[3]/div/div/div/div[2]/div/div")
	public WebElement EmptyCart;

	@FindBy(css = "a.product-name")
	public WebElement RightProduct;

	@FindBy(id = "checkout")
	WebElement checkoutBtn;

	@FindBy(id = "termsofservice")
	WebElement termsofservice;
	
	@FindBy(xpath="/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[1]/div[3]/button[1]")
	WebElement guestCheckoutBtn ; 


	public void RemoveProduct() {
		clickButton(RemoveBtn);
	}
	public void UpdateProductQuantityinCart(String Quantity) {
		clearText(QuntityTxt);
		setTextElementText(QuntityTxt, Quantity);
	}
	public void ClickCheckout() {
		clickButton(termsofservice);
		clickButton(checkoutBtn);
	}
	public void openCheckoutPageAsGuest() 
	{
		clickButton(termsofservice);
		clickButton(checkoutBtn);
		clickButton(guestCheckoutBtn);
	}
}