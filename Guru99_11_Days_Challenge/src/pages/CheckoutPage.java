package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import ultis.FindProperties;

public class CheckoutPage {
	
	protected WebDriver driver;
	protected WebDriverWait wait;
	
	public CheckoutPage(WebDriver driver) {
		
		this.driver=driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(12));
	}
	
	public void enterQuantityXperia(String num) {
		
		try {
			wait.until(ExpectedConditions.visibilityOf(
					driver.findElement(By.xpath(FindProperties.locateProperty("xperia_quantity_xpath"))))).sendKeys(num);
		}
		catch(Exception e) {
			e.printStackTrace();
			Assert.fail("Xperia quantity text box not found!");
		}
	}
	
	public void clickUpdateButton() {
		try {
			wait.until(ExpectedConditions.visibilityOf(
					driver.findElement(By.xpath(FindProperties.locateProperty("update_button_xpath"))))).click();
		}
		catch(Exception e) {
			e.printStackTrace();
			Assert.fail("Update button not found!");
			
		}
		
	}
	
	public void clickEmptyButton() {
		try {
			wait.until(ExpectedConditions.visibilityOf(
					driver.findElement(By.xpath(FindProperties.locateProperty("empty_button_xpath"))))).click();
		}
		catch(Exception e) {
			e.printStackTrace();
			Assert.fail("Empty button not found!");
		}
	}
	
	public void clickProceedToCheckoutButton() {
		try {
			WebElement proceedToCheckout = driver.findElement(By.xpath("//button[@title='Proceed to Checkout']"));
			wait.until(ExpectedConditions.visibilityOf(proceedToCheckout)).click();
		}
		catch(Exception e) {
			e.printStackTrace();
			Assert.fail("Proceed To Checkout button was not able to click!");
		}
	}	
	
	public void enterAddress(String add) {
		try {
			WebElement address = driver.findElement(By.xpath("//input[@id='billing:street1']"));
			address.clear();
			wait.until(ExpectedConditions.visibilityOf(address)).sendKeys(add);
		}
		catch(Exception e) {
			e.printStackTrace();
			Assert.fail("Can not enter address!");
		}
	}	
	
	public void enterCity(String city) {
		try {
			WebElement cityField = driver.findElement(By.xpath("//input[@id='billing:city']"));
			cityField.clear();
			wait.until(ExpectedConditions.visibilityOf(cityField)).sendKeys(city);
		}
		catch(Exception e) {
			e.printStackTrace();
			Assert.fail("Can not enter City!");
		}
	}
	
	public void selectState(String s) {
		try {
			Select state = new Select(driver.findElement(By.xpath("//select[@id='billing:region_id']")));
			state.selectByVisibleText(s);
		}
		catch(Exception e) {
			e.printStackTrace();
			Assert.fail("Can not select state!");
		}
	}
	
	public void enterPostcode(String num) {
		try {
			driver.findElement(By.xpath("//input[@id='billing:postcode']")).clear();
			driver.findElement(By.xpath("//input[@id='billing:postcode']")).sendKeys(num);
			
		}
		catch(Exception e) {
			e.printStackTrace();
			Assert.fail("Can not enter Postcode!");
		}
	}
	
	public void selectCountry(String c) {
		try {
			Select country = new Select(driver.findElement(By.xpath("//select[@id='billing:country_id']")));
			country.selectByVisibleText(c);
		}
		catch(Exception e) {
			e.printStackTrace();
			Assert.fail("Can not select country!");
		}
	}
	
	public void enterTelephone(String num) {
		try {
			driver.findElement(By.xpath("//input[@id='billing:telephone']")).clear();
			driver.findElement(By.xpath("//input[@id='billing:telephone']")).sendKeys(num);
			
		}
		catch(Exception e) {
			e.printStackTrace();
			Assert.fail("Can not enter Telephone number!");
		}
	}
	
	public void clickContinueButton1() {
		try {
			driver.findElement(By.xpath("//button[@onclick='billing.save()']")).click();
			
		}
		catch(Exception e) {
			e.printStackTrace();
			Assert.fail("Continue 1 button can not be clicked!");
		}
	}
	
	public void clickContinueButton2() {
		try {
			driver.findElement(By.xpath("//button[@onclick='shippingMethod.save()']")).click();
			
		}
		catch(Exception e) {
			e.printStackTrace();
			Assert.fail("Continue 2 button can not be clicked!");
		}
	}
	
	public void clickContinueButton3() {
		try {
			driver.findElement(By.xpath("//button[@onclick='payment.save()']")).click();
			
		}
		catch(Exception e) {
			e.printStackTrace();
			Assert.fail("Continue 3 button can not be clicked!");
		}
	}
	
	public void clickCartLink() {
		try {
			driver.findElement(By.xpath("//span[text()='Cart']")).click();
			
		}
		catch(Exception e) {
			e.printStackTrace();
			Assert.fail("Cart Link can not be clicked!");
		}
	}
	
	public void clickEditItemsLink() {
		try {
			driver.findElement(By.xpath("//a[@title='Edit item']")).click();
			
		}
		catch(Exception e) {
			e.printStackTrace();
			Assert.fail("Edit Items Link can not be clicked!");
		}
	}	
	
	public void enterQuantityLG(String q) {
		try {
			driver.findElement(By.xpath("//input[@id='qty']")).clear();
			driver.findElement(By.xpath("//input[@id='qty']")).sendKeys(q);
			
		}
		catch(Exception e) {
			e.printStackTrace();
			Assert.fail("Can not enter quantity!");
		}
	}	
	
	public void clickUpdateCartLG() {
		try {
			driver.findElement(By.xpath("//button[@title='Update Cart']")).click();
			
		}
		catch(Exception e) {
			e.printStackTrace();
			Assert.fail("Can not click update cart LG");
		}
	}
	
	
	
	
	public void clickCheckMoneyOrderRadioButton() {
		try {
			driver.findElement(By.xpath("//input[@id='p_method_checkmo']")).click();
		}
		catch(Exception e) {
			e.printStackTrace();
			Assert.fail("Can not click Check Money Order Radio Button!");
		}
	}
	
	public void clickPlaceOrderButton() {
		try {
			driver.findElement(By.xpath("//button[@title='Place Order']")).click();
			
		}
		catch(Exception e) {
			e.printStackTrace();
			Assert.fail("Place Order button can not be clicked!");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}

