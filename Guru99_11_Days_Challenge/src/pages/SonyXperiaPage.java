package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import ultis.FindProperties;

public class SonyXperiaPage {
	protected WebDriver driver;
	protected WebDriverWait wait;
	
	public SonyXperiaPage(WebDriver driver) {
		
		this.driver=driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(12));
	}
	
	
	
	
}
