package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import ultis.FindProperties;

public class MobilePage {
	
	protected WebDriver driver;
	protected WebDriverWait wait;
	
	public MobilePage(WebDriver driver) {
		
		this.driver=driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(12));
	}
	
	public void sortByName() {
		
		try {
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(FindProperties.locateProperty("sort_by_xpath")))));
			Select select= new Select(driver.findElement(By.xpath(FindProperties.locateProperty("sort_by_xpath"))));
			select.selectByVisibleText("Name");
		}
		catch(Exception e) {
			
			e.printStackTrace();
			Assert.fail("Sort by name was not found!");
		}
	}
	
	public void clickSonyXperia() {
		
		try {
			
			wait.until(ExpectedConditions.visibilityOf(
					driver.findElement(By.xpath(FindProperties.locateProperty("sony_xperia_xpath"))))).click();
			
		}
		catch(Exception e) {
			
			e.printStackTrace();
			Assert.fail("Button/link not found!");
		}
	}
	
	public void clickAddToCartButtonXperia() {
		try {
			wait.until(ExpectedConditions.visibilityOf(
					driver.findElement(By.xpath(FindProperties.locateProperty("add_to_cart_button_xperia_xpath"))))).click();
		}
		catch(Exception e) {
			e.printStackTrace();
			Assert.fail("Add to cart button not found!");
		}
	}
	
	public void clickAddToCompare_Xperia() {
		try {
			wait.until(ExpectedConditions.visibilityOf(
					driver.findElement(By.xpath(FindProperties.locateProperty("add_to_compare_Xperia_xpath"))))).click();
		}
		catch(Exception e) {
			e.printStackTrace();
			Assert.fail("Button Add to Compare Sony Xperia not found!");
		}
		
	}
	
	public void clickAddToCompare_Iphone() {
		try {
			wait.until(ExpectedConditions.visibilityOf(
					driver.findElement(By.xpath(FindProperties.locateProperty("add_to_compare_IPhone_xpath"))))).click();
		}
		catch(Exception e) {
			e.printStackTrace();
			Assert.fail("Button Add to Compare Iphone not found!");
		}
		
	}
	
	public void clickCompareButton() {
		try {
			wait.until(ExpectedConditions.visibilityOf(
					driver.findElement(By.xpath(FindProperties.locateProperty("compare_button_xpath"))))).click();
		}
		catch(Exception e) {
			e.printStackTrace();
			Assert.fail("Compare button not found!");
		}
	}
	
	// add to cart IPhone
	public void clickAddToCartIphone() {
		try {
				
				driver.findElement(By.xpath("//a[text()='IPhone']/parent::h2/following-sibling::div[@class='actions']/button")).click();
				
			}
		catch(Exception e) {
				e.printStackTrace();
				Assert.fail("Add to cart cound not be clicked!");
			}
			
		}
	
}
