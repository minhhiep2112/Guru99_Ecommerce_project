/*      
Test Steps:
1. Goto http://live.techpanda.org/
2. Click on ‘MOBILE’ menu
3. In the list of all mobile , click on ‘ADD TO CART’ for Sony Xperia mobile
4. Change ‘QTY’ value to 1000 and click ‘UPDATE’ button. Expected that an error is displayed 
   "The requested quantity for "Sony Xperia" is not available.
5. Verify the error message
6. Then click on ‘EMPTY CART’ link in the footer of list of all mobiles. A message "SHOPPING CART IS EMPTY" is shown.
7. Verify cart is empty
*/


package test_cases;

import java.io.IOException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import initDriver.InitialDriver;
import ultis.FindProperties;

public class TC003_Check_quantity extends InitialDriver{
	
	@Test
	public void checkQuantity() throws IOException {
		
		String message1="The request quantity for \"Sony Xperia\" is not available.";
		String message2="SHOPPING CART IS EMPTY";
		
		indexPage.clickMobileButton();
		mobilePage.clickAddToCartButtonXperia();
		checkoutPage.enterQuantityXperia("1000");
		checkoutPage.clickUpdateButton();
		
		SoftAssert softAssert = new SoftAssert();

		softAssert.assertEquals(driver.findElement(By.xpath(FindProperties.locateProperty("error_message_xpath"))).getText(), message1,
				"Error message is not right!");
		
		checkoutPage.clickEmptyButton();
		softAssert.assertEquals(driver.findElement(By.xpath("//div[@class='page-title']/h1")).getText(), message2,"Wrong message!");
		
		softAssert.assertAll();
		
	}
	
}
