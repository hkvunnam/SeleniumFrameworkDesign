package hariKrishna.tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import hariKrishna.TestComponents.BaseTest;
import hariKrishna.TestComponents.RetryListners;
import hariKrishna.pageobjectdesign.CartPage;
import hariKrishna.pageobjectdesign.ProductCatalog;

public class ErrorValidations extends BaseTest {

	@Test(groups= {"errorValidate"}, dataProvider="getData", retryAnalyzer= RetryListners.class)
	public void loginValidation(HashMap<String, String> input) throws IOException, InterruptedException {
		
		loginPage.login(input.get("email"), input.get("password"));
		Assert.assertEquals("Incorrect email or password.", loginPage.getErrorMessage());

	}
	@Test(enabled=false)
	public void submitOrder() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		ProductCatalog productCatalog = loginPage.login("hk@email.com", "A@s123456789");
		productCatalog.getProduct("ZARA COAT 3");
		productCatalog.getProduct("iphone 13 pro");
		CartPage cartPage = productCatalog.getToCart();
		boolean check1 = cartPage.checkCart("ZARA COAT 3");
		Assert.assertTrue(check1);
		boolean check2 = cartPage.checkCart("iphone 135 pro");
		Assert.assertFalse(check2);
		
	}
	
	@DataProvider
	public Object[][] getData() throws IOException {
//		HashMap<String, String> map = new HashMap<>();
//		map.put("email", "hk@email.com");
//		map.put("password", "A@s123456789");
//		HashMap<String, String> map1 = new HashMap<>();
//		map1.put("email", "hk@email.com");
//		map1.put("password", "A@s12345678");
		
		List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\hariKrishna\\data\\Data.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};
	}
	
	

}
