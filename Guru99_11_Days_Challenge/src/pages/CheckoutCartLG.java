package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CheckoutCartLG {
	protected WebDriver driver;
	protected WebDriverWait wait;
	
	public CheckoutCartLG(WebDriver driver) {
		
		this.driver=driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(12));
	}
	
	public void clickUpdateCartLG() {
		try {
			driver.findElement(By.xpath("//td[@class='product-cart-actions']/button")).click();
			
		}
		catch(Exception e) {
			e.printStackTrace();
			Assert.fail("Can not click update cart LG");
		}
	}
	
	public void changeQuantityLG(String num) {
		
		try {
			driver.findElement(By.xpath("//td[@class='product-cart-actions']/input")).clear();
			driver.findElement(By.xpath("//td[@class='product-cart-actions']/input")).sendKeys(num);
			
		}
		catch(Exception e) {
			e.printStackTrace();
			Assert.fail("Can not change quantity of LG!");
		}
		
	}
	
	public void clickProceedButton() {
		
		try {
			
			driver.findElement(By.xpath("(//button[@title='Proceed to Checkout'])[2]")).click();
			
		}
		catch(Exception e) {
			e.printStackTrace();
			Assert.fail("Can not click proceed button!");
		}
		
		
	}
	
	
	
}
