package hariKrishna.tests;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import hariKrishna.TestComponents.BaseTest;
import hariKrishna.pageobjectdesign.CartPage;
import hariKrishna.pageobjectdesign.ConfirmationPage;
import hariKrishna.pageobjectdesign.OrderPage;
import hariKrishna.pageobjectdesign.PaymentPage;
import hariKrishna.pageobjectdesign.ProductCatalog;

public class StandaloneTest2 extends BaseTest{

	@Test
	public void submitOrder() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		ProductCatalog productCatalog = loginPage.login("hk@email.com", "A@s123456789");
		productCatalog.getProduct("ZARA COAT 3");
		productCatalog.getProduct("iphone 13 pro");
		CartPage cartPage = productCatalog.getToCart();
		boolean check1 = cartPage.checkCart("ZARA COAT 3");
		Assert.assertTrue(check1);
		boolean check2 = cartPage.checkCart("iphone 13 pro");
		Assert.assertTrue(check2);
		PaymentPage paymentPage = cartPage.checkOut();
		paymentPage.cardDetails("123", "Hari");
		paymentPage.enterCoupon("rahulshettyacademy");
		paymentPage.shippingCountry("India");
		ConfirmationPage confPage = paymentPage.placeOrder();;
		String isConfirmed = confPage.isConfirmed();
		Assert.assertEquals(isConfirmed, "THANKYOU FOR THE ORDER.");
		confPage.getOrderId();
	}
	
	@Test(dependsOnMethods ={"submitOrder"})
	public void validCartItems() {
		ProductCatalog productCatalog = loginPage.login("hk@email.com", "A@s123456789");
		OrderPage ordersPage = productCatalog.ordersPage();
		Assert.assertTrue(ordersPage.productCheck("ZARA COAT 3"));
	}

}
