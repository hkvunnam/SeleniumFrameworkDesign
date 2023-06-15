package hariKrishna.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import hariKrishna.pageobjectdesign.CartPage;
import hariKrishna.pageobjectdesign.OrderPage;

public class AbstractComponent {
	WebDriver driver;

	@FindBy(css = "button[routerlink='/dashboard/cart']")
	WebElement cart;
	
	@FindBy(css=".btn-custom .fa-handshake-o")
	WebElement ordersHistory;

	public AbstractComponent(WebDriver driver) {
		this.driver = driver;
	}

	public void visibleExplicitWait(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void inVisibleExplicitWait(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(element));
	}

	public CartPage getToCart() {
		cart.click();
		CartPage cartPage = new CartPage(driver);
		return cartPage;
	}
	
	public OrderPage ordersPage() {
		ordersHistory.click();
		OrderPage orderPage = new OrderPage(driver);
		return orderPage;
	}
	
	public void close() {
		driver.close();
	}
}
