package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class RegistryPage {
	
	protected WebDriver driver;
	protected WebDriverWait wait;
	
	public RegistryPage(WebDriver driver) {
		
		this.driver=driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(12));
	}
	
	public void clickCreateAnAccount() {
		
		try {
			WebElement createAccountButton = driver.findElement(By.xpath("//a[@title='Create an Account']"));
			wait.until(ExpectedConditions.visibilityOf(createAccountButton)).click();
			
		}
		catch(Exception e) {
			e.printStackTrace();
			Assert.fail("Create account button was not found!");
		}
		
	}
	
	public void enterFirstName(String name) {
		
		try {
			WebElement firstNameField = driver.findElement(By.id("firstname"));
			wait.until(ExpectedConditions.visibilityOf(firstNameField)).sendKeys(name);
			
		}
		catch(Exception e) {
			e.printStackTrace();
			Assert.fail("Can not enter first name!");
		}
		
	}
	
	public void enterMidName(String name) {
		
		try {
			WebElement midNameField = driver.findElement(By.id("middlename"));
			wait.until(ExpectedConditions.visibilityOf(midNameField)).sendKeys(name);
			
		}
		catch(Exception e) {
			e.printStackTrace();
			Assert.fail("Can not enter mid name!");
		}
		
	}
	
	
	public void enterLastName(String name) {
		
		try {
			WebElement lastNameField = driver.findElement(By.id("lastname"));
			wait.until(ExpectedConditions.visibilityOf(lastNameField)).sendKeys(name);
			
		}
		catch(Exception e) {
			e.printStackTrace();
			Assert.fail("Can not enter last name!");
		}
		
	}
	
	public void enterEmail(String email) {
		
		try {
			WebElement emailField = driver.findElement(By.id("email_address"));
			wait.until(ExpectedConditions.visibilityOf(emailField)).sendKeys(email);
			
		}
		catch(Exception e) {
			e.printStackTrace();
			Assert.fail("Can not enter email!");
		}
		
	}
	
	public void enterPassword(String pass) {
		
		try {
			WebElement password = driver.findElement(By.id("password"));
			wait.until(ExpectedConditions.visibilityOf(password)).sendKeys(pass);
			
		}
		catch(Exception e) {
			e.printStackTrace();
			Assert.fail("Can not enter password!");
		}
		
	}	
	
	public void enterConfirmationPassword(String pass) {
		
		try {
			WebElement confirmPassword = driver.findElement(By.id("confirmation"));
			wait.until(ExpectedConditions.visibilityOf(confirmPassword)).sendKeys(pass);
			
		}
		catch(Exception e) {
			e.printStackTrace();
			Assert.fail("Can not enter confirmation password!");
		}
		
	}
	
	public void clickRegisterButton() {
		
		try {
			WebElement registerButton = driver.findElement(By.xpath("//button[@title='Register']"));
			wait.until(ExpectedConditions.visibilityOf(registerButton)).click();;
			
		}
		catch(Exception e) {
			e.printStackTrace();
			Assert.fail("Can not click register button!");
		}
		
	}	
	
	
}
