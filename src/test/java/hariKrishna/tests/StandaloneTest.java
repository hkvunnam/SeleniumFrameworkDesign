package hariKrishna.tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import hariKrishna.pageobjectdesign.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StandaloneTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String product = "ZARA COAT 3";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("hk@email.com", "A@s123456789");
		driver.findElement(By.id("userEmail")).sendKeys("hk@email.com");
		driver.findElement(By.id("userPassword")).sendKeys("A@s123456789");
		driver.findElement(By.id("login")).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".mb-3"))));
		List<WebElement> items = driver.findElements(By.cssSelector(".mb-3"));
		WebElement item1 = items.stream().filter(s->s.findElement(By.tagName("b")).getText().equalsIgnoreCase(product)).findFirst().orElse(null);
		item1.findElement(By.cssSelector("button.w-10")).click();
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("toast-container"))));
		WebElement item2 = items.stream().filter(s->s.findElement(By.tagName("b")).getText().equalsIgnoreCase("iphone 13 pro")).findFirst().orElse(null);
		item2.findElement(By.cssSelector("button.w-10")).click();
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("toast-container"))));
		driver.findElement(By.cssSelector("button[routerlink='/dashboard/cart']")).click();
		List<WebElement> cart = driver.findElements(By.cssSelector(".cart h3"));
		Boolean match = cart.stream().anyMatch(s->s.getText().equalsIgnoreCase(product));
		Assert.assertTrue(match);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,600)");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(".totalRow button")).click();
		driver.findElement(By.xpath("(//input)[3]")).sendKeys("123");
		driver.findElement(By.xpath("(//input)[4]")).sendKeys("Hari");
		driver.findElement(By.xpath("(//input)[5]")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.btn.btn-primary.mt-1")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector("p.mt-1.ng-star-inserted")).getText(),"* Coupon Applied");
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		driver.findElement(By.cssSelector("div.user__address input")).sendKeys("Ind");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("span.ng-star-inserted"))));
		List<WebElement> country = driver.findElements(By.cssSelector("span.ng-star-inserted"));
		WebElement cou = country.stream().filter(s->s.getText().equalsIgnoreCase("India")).findFirst().orElse(null);
		cou.click();
		driver.findElement(By.cssSelector(".actions a")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector(".hero-primary")).getText(), "THANKYOU FOR THE ORDER.");
		List<WebElement> orders = driver.findElements(By.cssSelector("label.ng-star-inserted"));
		orders.stream().map(s->s.getText()).forEach(s->System.out.println(s));
		driver.close();
	}

}
