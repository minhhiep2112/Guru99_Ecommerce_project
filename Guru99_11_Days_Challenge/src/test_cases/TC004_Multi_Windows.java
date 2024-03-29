/*      
Test Steps:
1. Goto http://live.techpanda.org/
2. Click on ‘MOBILE’ menu
3. In mobile products list , click on ‘Add To Compare’ for 2 mobiles (Sony Xperia & Iphone)
4. Click on ‘COMPARE’ button. A popup window opens
5. Verify the pop-up window and check that the products are reflected in it
   Heading "COMPARE PRODUCTS" with selected products in it.
6. Close the Popup Windows
*/

package test_cases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import initDriver.InitialDriver;

public class TC004_Multi_Windows extends InitialDriver {
	
	@Test
	public void comparePhones() throws InterruptedException {
	
		indexPage.clickMobileButton();
		mobilePage.clickAddToCompare_Xperia();
		mobilePage.clickAddToCompare_Iphone();
		
		String parentWindow = driver.getWindowHandle();
		
		mobilePage.clickCompareButton();
		
		// Iterate each elements of all window handles to find new window handle then switch to it
		// In this case has 2 windows only
		driver.getWindowHandles().stream()
								 .forEach(a ->{System.out.println(a);
								 			   if(a!=parentWindow) {driver.switchTo().window(a);
								 			   						driver.manage().window().maximize();}});
		// wait for pop-up window load
		Thread.sleep(2000);
		
		try {
			 driver.findElement(By.xpath("//a[@title='IPhone']"));
			
		}
		catch(Exception e) {
			e.printStackTrace();
			Assert.fail("There is no IPhone in Compare!");
		}
		
		try {
			driver.findElement(By.xpath("//a[@title='Sony Xperia']"));
		}
		catch(Exception e) {
			e.printStackTrace();
			Assert.fail("There is no Sony Xperia in Compare!");
		}
		
		
		
//		Thread.sleep(2000);
		driver.close();
		driver.switchTo().window(parentWindow);
		
	}
	
}
