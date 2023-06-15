package hariKrishna.pageobjectdesign;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import hariKrishna.AbstractComponents.AbstractComponent;

public class OrderPage extends AbstractComponent {

	WebDriver driver;

	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "tbody tr td:nth-child(3)")
	List<WebElement> orders;

	public boolean productCheck(String product) {
		boolean match = orders.stream().anyMatch(s -> s.getText().equalsIgnoreCase(product));
		return match;
	}

}
