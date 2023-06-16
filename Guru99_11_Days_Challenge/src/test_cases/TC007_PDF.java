package test_cases;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import initDriver.InitialDriver;

public class TC007_PDF extends InitialDriver{
	
	@Test
	public void printAsPDF() {
		
		// login and go to viewing orders
		indexPage.clickAccountButton();
		indexPage.clickMyAccount();
		loginRegistryPage.enterEmail("tester12345@gmail.com");
		loginRegistryPage.enterPassword("qwert123");
		myAccountPage.clickMyOrdersLink();
		myAccountPage.clickViewOrderLink();
		
		// verify order
		try {
			assertTrue(driver.findElement(By.xpath("//div[@class='page-title title-buttons']")).isDisplayed(),"Oders is not displayed!");
			assertTrue(driver.findElement(By.xpath("//div[@class='page-title title-buttons']")).getText().contains("Pending"),"Order status is not right!");
		}
		catch(Exception e) {
			e.printStackTrace();
			Assert.fail("Orders is not displayed!");
		}
		
		myAccountPage.clickPrintOrderLink();
		
		
	}
	
	
	
}
