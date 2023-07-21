/*      
Test Steps:
1. Goto http://live.techpanda.org/
2. Click on ‘MOBILE’ menu
3. In the list of all mobile , read the cost of Sony Xperia mobile (which is $100)
4. Click on Sony Xperia mobile
5. Read the Sony Xperia mobile from detail page. Product value in list and details page should be equal ($100). 
*/


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
