package test_cases;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import initDriver.InitialDriver;

public class TC009_Discount_Coupon extends InitialDriver {
	
	@Test
	public void discount() {
		
		indexPage.clickMobileButton();
		mobilePage.clickAddToCartIphone();
		checkoutCartIPhone.enterDiscountCode();
		
		// verify discount
		
		WebElement price = driver.findElement(By.xpath("//table[@id='shopping-cart-totals-table']/tfoot/tr/td/strong/span[@class='price']"));
		assertEquals(price.getText(), "$475.00");
//		assertEquals(price.getText(), "$500.00");
		
			
	}
	
	
	
}
