package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;

public class LoginRegistryPage {
	protected WebDriver driver;
	protected WebDriverWait wait;
	
	public LoginRegistryPage(WebDriver driver) {
		
		this.driver=driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(12));
	}
	
	public void enterEmail(String email) {
		
		try {
			WebElement emailField = driver.findElement(By.id("email"));
			wait.until(ExpectedConditions.visibilityOf(emailField)).sendKeys(email);;
			
		}
		catch(Exception e) {
			e.printStackTrace();
			Assert.fail("Can not enter email!");
		}
		
	}
	
	public void enterPassword(String pass) {
		
		try {
			WebElement passwordField = driver.findElement(By.id("pass"));
			wait.until(ExpectedConditions.visibilityOf(passwordField)).sendKeys(pass);
			
		}
		catch(Exception e) {
			e.printStackTrace();
			Assert.fail("Can not enter password!");
		}
		
	}
	
	public void clickLoginButton() {
		
		try {
			WebElement loginButton = driver.findElement(By.id("send2"));
			wait.until(ExpectedConditions.visibilityOf(loginButton)).click();;
			
		}
		catch(Exception e) {
			e.printStackTrace();
			Assert.fail("Can not click login button!");
		}
		
	}	
	
	

	
}
