package hariKrishna.pageobjectdesign;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import hariKrishna.AbstractComponents.AbstractComponent;

public class PaymentPage extends AbstractComponent{
	
	WebDriver driver;

	public PaymentPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//input)[3]")
	WebElement cvvNum;
	
	@FindBy(xpath="(//input)[4]")
	WebElement cardHolder;
	
	@FindBy(xpath="(//input)[5]")
	WebElement coupon;
	
	@FindBy(css="button.btn.btn-primary.mt-1")
	WebElement validate;
	
	@FindBy(css=".ng-animating")
	WebElement ghost;
	
	@FindBy(css="div.user__address input")
	WebElement country;
	
	@FindBy(css="span.ng-star-inserted")
	List<WebElement> countryList;
	
	@FindBy(css="span.ng-star-inserted")
	WebElement con;
	
	@FindBy(css=".actions a")
	WebElement pay;
	
	public void cardDetails(String cvv, String holderName) {
		cvvNum.sendKeys(cvv);
		cardHolder.sendKeys(holderName);
	}
	
	public void enterCoupon(String coup) {
		coupon.sendKeys(coup);
		validateCoupon();
		Assert.assertEquals(driver.findElement(By.cssSelector("p.mt-1.ng-star-inserted")).getText(),"* Coupon Applied");
		inVisibleExplicitWait(ghost);
		
	}
	
	private void validateCoupon() {
		validate.click();
	}
	
	public void shippingCountry(String countryName) {
		country.sendKeys(countryName);
		visibleExplicitWait(con);
		WebElement select = countryList.stream().filter(s->s.getText().equalsIgnoreCase(countryName)).findFirst().orElse(null);
		select.click();
	}
	
	public ConfirmationPage placeOrder() {
		pay.click();
		ConfirmationPage confPage = new ConfirmationPage(driver);
		return confPage;
	}

}
