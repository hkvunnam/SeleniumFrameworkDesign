package hariKrishna.pageobjectdesign;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import hariKrishna.AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent {

	WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".cart h3")
	List<WebElement> itemsText;

	@FindBy(css = ".totalRow button")
	WebElement checkOut;

	public boolean checkCart(String productName) {
		boolean product = itemsText.stream().anyMatch(s -> s.getText().equalsIgnoreCase(productName));
		return product;
	}

	public PaymentPage checkOut() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,600)");
		Thread.sleep(1000);
		checkOut.click();
		PaymentPage paymentPage = new PaymentPage(driver);
		return paymentPage;
	}

}
