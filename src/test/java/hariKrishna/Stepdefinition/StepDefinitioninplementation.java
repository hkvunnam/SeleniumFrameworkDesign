package hariKrishna.Stepdefinition;

import java.io.IOException;

import org.testng.Assert;

import hariKrishna.TestComponents.BaseTest;
import hariKrishna.pageobjectdesign.CartPage;
import hariKrishna.pageobjectdesign.ConfirmationPage;
import hariKrishna.pageobjectdesign.LoginPage;
import hariKrishna.pageobjectdesign.PaymentPage;
import hariKrishna.pageobjectdesign.ProductCatalog;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitioninplementation extends BaseTest {
	public LoginPage loginpage;
	public ProductCatalog catalog;
	public CartPage cartPage;
	public ConfirmationPage confirm;

	@Given("I landed on Ecommerce Page")
	public void I_landed_on_Ecommerce_Page() throws IOException {
		loginpage = launchApplication();
	}

	@Given("^Logged in with UserName (.+) and password (.+)$")
	public void Logged_in_with_UserName_and_password(String userName, String pass) {
		catalog = loginpage.login(userName, pass);
	}

	@When("^I add the product (.+) from cart$")
	public void I_add_the_product_from_cart(String productName) {
		catalog.getProduct(productName);
	}

	@When("^Checkout (.+) and submit the order$")
	public void Checkout_productName_and_submit_the_order(String productName) throws InterruptedException {
		cartPage = catalog.getToCart();
		Boolean match = cartPage.checkCart(productName);
		Assert.assertTrue(match);
		PaymentPage payment = cartPage.checkOut();
		payment.shippingCountry("India");
		confirm = payment.placeOrder();
	}

	@Then("{string} message is displayed on Confirmation page")
	public void message_is_displayed_on_Confirmation_page(String string) {
		String isConfirmed = confirm.isConfirmed();
		Assert.assertTrue(isConfirmed.equalsIgnoreCase(string));
		driver.close();
	}

	@Then("{string} message is displayed")
	public void some_message_is_displayed(String string) {
		Assert.assertEquals(string, loginPage.getErrorMessage());
		driver.close();
	}

}
