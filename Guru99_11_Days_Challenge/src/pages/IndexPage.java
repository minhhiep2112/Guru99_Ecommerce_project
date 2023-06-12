package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import ultis.FindProperties;

public class IndexPage {
	
	protected WebDriver driver;
	protected WebDriverWait wait;
	
	public IndexPage(WebDriver driver) {
		
		this.driver=driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(12));
	}
		
	public void clickMobileButton() {
		try {
			
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(
					FindProperties.locateProperty("mobile_button_xpath"))))).click();
			
		}
		catch(Exception e) {
			e.printStackTrace();
			Assert.fail("Mobile button was not found!");
		}
		
	}
	
	public void clickAccountButton() {
		try {
			
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(
					FindProperties.locateProperty("account_button_xpath"))))).click();
			
		}
		catch(Exception e) {
			e.printStackTrace();
			Assert.fail("Account button was not found!");
		}
		
	}
	
	public void clickMyAccount() {
		try {
			
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(
					FindProperties.locateProperty("my_account_xpath"))))).click();
			
		}
		catch(Exception e) {
			e.printStackTrace();
			Assert.fail("My account button was not found!");
		}
		
	}
	
	
}
