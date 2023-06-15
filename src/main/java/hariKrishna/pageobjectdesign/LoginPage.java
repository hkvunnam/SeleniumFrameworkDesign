package hariKrishna.pageobjectdesign;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hariKrishna.AbstractComponents.AbstractComponent;

public class LoginPage extends AbstractComponent{
	
	private WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
		
	}
	
	//WebElement userId = driver.findElement(By.id("userEmail"));
	//WebElement password = driver.findElement(By.id("userPassword"));
	
	@FindBy(id="userEmail")
	WebElement userId;
	
	@FindBy(id="userPassword")
	WebElement password;
	
	@FindBy(id="login")
	WebElement login;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement errorMessage;
	
	public ProductCatalog login(String id, String pass) {
		userId.sendKeys(id);
		password.sendKeys(pass);
		login.click();
		ProductCatalog productCatalog = new ProductCatalog(driver);
		return productCatalog;
	}
	
	public String getErrorMessage() {
		visibleExplicitWait(errorMessage);
		return errorMessage.getText();
	}
	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}
}
