package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class TVPage {
	
	protected WebDriver driver;
	protected WebDriverWait wait;
	
	public TVPage(WebDriver driver) {
		
		this.driver=driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(12));
	}
	
	public void clickTVLink() {
		
		WebElement linkTV = driver.findElement(By.xpath("//nav[@id='nav']/ol/li[2]"));
		
		try {
			
			wait.until(ExpectedConditions.visibilityOf(linkTV)).click();
			
		}
		catch(Exception e) {
			e.printStackTrace();
			Assert.fail("TV link was not found!");
		}
		
	}
	
	public void clickAddToWishlistLG() {
		
		WebElement addToWishlist = driver.findElement(By.xpath("//a[@title='LG LCD']/parent::h2/following-sibling::div[@class='actions']/ul/li[1]"));
		
		try {
			
			wait.until(ExpectedConditions.visibilityOf(addToWishlist)).click();
			
		}
		catch(Exception e) {
			e.printStackTrace();
			Assert.fail("Add to wishlist LG was not found!");
		}
		
	}
}
