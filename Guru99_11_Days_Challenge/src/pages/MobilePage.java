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
			select.selectByVisibleText("Position");
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
	
}
