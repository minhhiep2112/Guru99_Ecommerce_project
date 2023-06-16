package test_cases;

import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import initDriver.InitialDriver;

public class TC008_Re_Order extends InitialDriver{
	
	@Test
	public void reorder() {
		
		// login and re-order
		indexPage.clickAccountButton();
		indexPage.clickMyAccount();
		loginRegistryPage.enterEmail("tester012345@gmail.com");
		loginRegistryPage.enterPassword("qwert123");
		loginRegistryPage.clickLoginButton();
		myAccountPage.clickMyOrdersLink();
		myAccountPage.clickReOrderLink();
		
		// get old price to verify change later
		String oldGrandTotal = driver.findElement(By.xpath("//table[@id='shopping-cart-totals-table']/tfoot/tr/td/strong/span")).getText();
		
		// change quantity
		
		checkoutCartLG.changeQuantityLG("10");
		checkoutCartLG.clickUpdateCartLG();
		
		// verify total price changed
		String newGrandTotal = driver.findElement(By.xpath("//table[@id='shopping-cart-totals-table']/tfoot/tr/td/strong/span")).getText();
		assertNotEquals(newGrandTotal, oldGrandTotal,"Grand Total Price is not right!");
		
		checkoutCartLG.clickProceedButton();
		checkoutPage.clickContinueButton1();
		checkoutPage.clickContinueButton2();
		checkoutPage.clickCheckMoneyOrderRadioButton();
		checkoutPage.clickContinueButton3();
		checkoutPage.clickPlaceOrderButton();
		
		try {
			assertTrue(driver.findElement(By.xpath("//h1[text()='Your order has been received.']")).isDisplayed());
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			Assert.fail("Order is not complete!");
			
		}
		
	}
	
}
