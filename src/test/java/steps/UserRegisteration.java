package steps;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.UserRegistrationPage;
import tests.TestBase;

public class UserRegisteration extends TestBase {
	HomePage homeObject;
	UserRegistrationPage registerObject;	

	@Given("The user in the home page")
	public void the_user_in_the_home_page() {
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();

	}
	@When("I click on register link")
	public void i_click_on_register_link() {
		Assert.assertTrue(driver.getCurrentUrl().contains("register"));

	}

	/*
	 * @When("I enterd the user data") public void i_enterd_the_user_data() {
	 * registerObject = new UserRegistrationPage(driver);
	 * registerObject.userRegistration("Mahmoud", "Salah", "Salah@gmail.com",
	 * "111111");
	}
	 */
	@When("I enterd {string},{string},{string},{string}")
	public void i_enterd(String firstname, String lastname, String email, String password) {
		registerObject = new UserRegistrationPage(driver);
		registerObject.userRegistration( firstname, lastname, email , password );
	}

	@Then("The Registeration page displayed successfully")
	public void the_registeration_page_displayed_successfully() {
		registerObject.userLogout();


	}
}
