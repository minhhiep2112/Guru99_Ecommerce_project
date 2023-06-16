package test_cases;

import static org.testng.Assert.assertEquals;

import java.awt.Robot;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import initDriver.InitialDriver;

public class TC006_Purchase_Products extends InitialDriver {
	
	// this test case depend on TC005_Account_Creation
	// so run by testng.xml
	
	@Test()
	public void purchaseProducts(ITestContext e) {
		
		// Login
		indexPage.clickAccountButton();
		indexPage.clickMyAccount();
		loginRegistryPage.enterEmail(e.getAttribute("email").toString());
		loginRegistryPage.enterPassword("qwert123");
		loginRegistryPage.clickLoginButton();
		
		myAccountPage.clickMyWishlistLink();
		myAccountPage.clickAddToCartButton();
		
		checkoutPage.clickProceedToCheckoutButton();
	
		// Filling address
		checkoutPage.enterAddress("ABC");
		checkoutPage.enterCity("New York");
		checkoutPage.selectState("New York");
		checkoutPage.enterPostcode("542896");
		checkoutPage.selectCountry("United States");
		checkoutPage.enterTelephone("12345678");
		checkoutPage.clickContinueButton1();
		
		// verify shipping rate
				
		try {
			assertEquals(driver.findElement(By.xpath("//label[@for='s_method_flatrate_flatrate']")).getText(), "Fixed $5.00");
		}
		catch(Exception ex) {
			ex.printStackTrace();
			Assert.fail("Shipping cost is not right!");
		}
		
		// change quantity to 2
		checkoutPage.clickCartLink();
		checkoutPage.clickEditItemsLink();
		checkoutPage.enterQuantityLG("2");
		checkoutPage.clickUpdateCartLG();
		checkoutPage.clickProceedToCheckoutButton();
		checkoutPage.clickContinueButton1();
		
		// verify shipping rate again
		try {
			assertEquals(driver.findElement(By.xpath("//label[@for='s_method_flatrate_flatrate']")).getText(), "Fixed $10.00");
		}
		catch(Exception ex) {
			ex.printStackTrace();
			Assert.fail("Shipping cost is not right!");
		}
		
		// continue to completing order
		checkoutPage.clickContinueButton2();
		checkoutPage.clickCheckMoneyOrderRadioButton();
		checkoutPage.clickContinueButton3();
		checkoutPage.clickPlaceOrderButton();
		
		// verify order has been placed
		try {
			assertEquals(driver.findElement(By.xpath("//div[@class='page-title']/following-sibling::h2")).getText(),
					"THANK YOU FOR YOUR PURCHASE!","Message successful order has problem!");
		}
		catch(Exception ex) {
			ex.printStackTrace();
			Assert.fail("Message successful order has problem!");
		}
		
		// order number may change each time run test case
		System.out.println("Order number is: " + driver.findElement(By.xpath("//div[@class='page-title']/following-sibling::p[1]/a")).getText());
		e.setAttribute("order number", driver.findElement(By.xpath("//div[@class='page-title']/following-sibling::p[1]/a")).getText());
		
		
		
		
		
		
		
		
	}
}