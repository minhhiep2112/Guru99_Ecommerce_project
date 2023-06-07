package initDriver;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.IndexPage;
import pages.MobilePage;
import ultis.FindProperties;

public class InitialDriver {
	
	protected WebDriver driver;
	protected IndexPage indexPage;
	protected MobilePage mobilePage;
	
	@BeforeMethod
	public void StartBrowser() throws IOException {
				
		// start browser
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.get(FindProperties.locateProperty("base_URL"));
		
		indexPage = new IndexPage(driver);
		mobilePage = new MobilePage(driver);
		
	}
	
	
	@AfterMethod
	public void CloseBrowser() throws InterruptedException {
		Thread.sleep(1000);
		driver.quit();
	}
}
