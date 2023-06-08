package test_cases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import initDriver.InitialDriver;
import ultis.FindProperties;

public class TC002_Compare_price extends InitialDriver {
	
	@Test
	public void comparePrice() throws IOException {
		
		indexPage.clickMobileButton();
		String priceOnMobilePage = driver.findElement(By.xpath(FindProperties.locateProperty("cost_of_sony_xperia_xpath"))).getText();
		System.out.println(priceOnMobilePage);
		
		mobilePage.clickSonyXperia();
		String priceOnSonyXperiaPage = driver.findElement(By.xpath(FindProperties.locateProperty("price_xpath"))).getText();
		System.out.println(priceOnSonyXperiaPage);
		
		assertEquals(priceOnSonyXperiaPage, priceOnMobilePage,"Price is not right!"); 
		
		String p = priceOnMobilePage.replace("$", "");
		int price = (int) Math.round(Double.parseDouble(p));
		
		System.out.println(price);
		
		assertEquals(price, 100,"Value is not right!");
	
		
	}
	
	
}
