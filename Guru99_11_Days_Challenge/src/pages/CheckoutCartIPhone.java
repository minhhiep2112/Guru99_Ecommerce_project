package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CheckoutCartIPhone {
	protected WebDriver driver;
	protected WebDriverWait wait;
	
	public CheckoutCartIPhone(WebDriver driver) {
		
		this.driver=driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(12));
	}
	
	public void enterDiscountCode() {
		
		String code = "guru50";
		try {
			
			driver.findElement(By.xpath("//input[@id='coupon_code']")).clear();
			driver.findElement(By.xpath("//input[@id='coupon_code']")).sendKeys(code);
			
		}
		catch(Exception e) {
			e.printStackTrace();
			Assert.fail("Could not enter discount code!");
			
		}
		
		
	}
	
	
	
	
}
