package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends PageBase {

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div[1]/ul/li[4]/strong")
	public WebElement ProductName;

	@FindBy(xpath  = "//*[@id=\"product-details-form\"]/div[2]/div[1]/div[2]/div[10]/div[3]/button")
	public WebElement SendEmailBtn;

	@FindBy(id = "price-value-4")
	public WebElement PriceValue;

	@FindBy(xpath = "//*[@id=\"product-details-form\"]/div[2]/div[1]/div[2]/div[3]/div[2]/a[2]")
	public WebElement AddReview;

	@FindBy(id="add-to-wishlist-button-4")
	WebElement WishlistBtn;

	@FindBy(xpath = "//*[@id=\"bar-notification\"]/div/p/a")
	WebElement Wishlistpage;

	@FindBy(css  ="div.compare-products")
	public WebElement CompareBtn;

	@FindBy(xpath ="//*[@id=\"bar-notification\"]/div/p/a")
	WebElement productComparisionPage;
	
	@FindBy(id = "add-to-cart-button-4")
	WebElement Addtocart;
	
	@FindBy(xpath = "//*[@id=\"bar-notification\"]/div/p/a")
	WebElement AddtocartBtn;
	
	
	
	public void ClickCompareBtn() {
		clickButton(CompareBtn);
	}
	public void OpenComparePage() {
		clickButton(productComparisionPage);
	}

	public void openEmailFriendPage() {
		clickButton(SendEmailBtn);
	}
	public void ClickAddReview() {
		clickButton(AddReview);
	}
	public void AddToWishlist() {
		clickButton(WishlistBtn);
	}
	public void openWishlist() {
		clickButton(Wishlistpage);
	}
	public void AddToCart() {
		clickButton(Addtocart);
		clickButton(AddtocartBtn);
		}
	}
