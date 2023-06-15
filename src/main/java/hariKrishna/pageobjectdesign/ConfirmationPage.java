package hariKrishna.pageobjectdesign;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import hariKrishna.AbstractComponents.AbstractComponent;

public class ConfirmationPage extends AbstractComponent{
	
	WebDriver driver;

	public ConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".hero-primary")
	WebElement confirmText;
	
	@FindBy(css="label.ng-star-inserted")
	List<WebElement> orderId;

	public String isConfirmed() {
		String isConfirmed = confirmText.getText();
		return isConfirmed;
	}
	
	public void getOrderId() {
		orderId.stream().map(s->s.getText()).forEach(s->System.out.println(s));
	}
	
	
	
}
