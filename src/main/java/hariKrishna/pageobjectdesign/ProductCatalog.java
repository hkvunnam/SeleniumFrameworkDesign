package hariKrishna.pageobjectdesign;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hariKrishna.AbstractComponents.AbstractComponent;

public class ProductCatalog extends AbstractComponent {
	WebDriver driver;

	public ProductCatalog(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".mb-3")
	WebElement lists;

	@FindBy(css = ".mb-3")
	List<WebElement> items;

	@FindBy(css = ".ng-animating")
	WebElement ghost;
	
	@FindBy(id="toast-container")
	WebElement cartToast;
	

	private List<WebElement> getProducts() {
		visibleExplicitWait(lists);
		return items;
	}

	public void getProduct(String productName) {
		WebElement product = getProducts().stream().filter(s -> s.findElement(By.tagName("b")).getText().equalsIgnoreCase(productName)).findFirst()
				.orElse(null);
		product.findElement(By.cssSelector("button.w-10")).click();
		visibleExplicitWait(cartToast);
		inVisibleExplicitWait(ghost);
	}
	

}
