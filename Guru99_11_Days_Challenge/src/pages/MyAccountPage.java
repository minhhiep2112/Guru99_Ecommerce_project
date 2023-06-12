package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class MyAccountPage {

	protected WebDriver driver;
	protected WebDriverWait wait;
	
	public MyAccountPage(WebDriver driver) {
		
		this.driver=driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(12));
	}
	
	public void clickTVLink() {
		
		try {
			WebElement linkTV = driver.findElement(By.xpath("//nav[@id='nav']/ol/li[2]"));
			wait.until(ExpectedConditions.visibilityOf(linkTV)).click();
			
		}
		catch(Exception e) {
			e.printStackTrace();
			Assert.fail("TV link was not found!");
		}
		
	}
	
	public void clickShareWishlist() {
		
		try {
			WebElement wishlistButton = driver.findElement(By.xpath("//button[@title='Share Wishlist']"));
			wait.until(ExpectedConditions.visibilityOf(wishlistButton)).click();
			
		}
		catch(Exception e) {
			e.printStackTrace();
			Assert.fail("Share wishlist button was not found!");
		}
		
	}
	
	public void enterEmailToShare(String email) {
		
		try {
			
			WebElement emailField = driver.findElement(By.id("email_address"));
			wait.until(ExpectedConditions.visibilityOf(emailField)).sendKeys(email);
		}
		catch(Exception e) {
			e.printStackTrace();
			Assert.fail("Information field was not found!");
		}
		
	}
	
	public void enterMessage(String message) {
		
		try {
			WebElement messageField = driver.findElement(By.id("message"));
			wait.until(ExpectedConditions.visibilityOf(messageField)).sendKeys(message);
			
		}
		catch(Exception e) {
			e.printStackTrace();
			Assert.fail("Message field was not found!");
		}
		
	}
	
	public void clickMyWishlistLink() {
		
		try {
			WebElement myWishlistLink = driver.findElement(By.xpath("//div[@class='block-content']/ul/li/a[text()='My Wishlist']"));
			wait.until(ExpectedConditions.visibilityOf(myWishlistLink)).click();
			
		}
		catch(Exception e) {
			e.printStackTrace();
			Assert.fail("My wishlist can not be clicked!");
		}
	}
	
	public void clickAddToCartButton() {
		
		try {
			WebElement addToCart = driver.findElement(By.xpath("//span[text()='Add to Cart']"));
			wait.until(ExpectedConditions.visibilityOf(addToCart)).click();
			
		}
		catch(Exception e) {
			e.printStackTrace();
			Assert.fail("Add to cart button can not be clicked!");
		}
	}	
	
	
}
