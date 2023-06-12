package initDriver;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.CheckoutPage;
import pages.IndexPage;
import pages.LoginRegistryPage;
import pages.MobilePage;
import pages.MyAccountPage;
import pages.RegistryPage;
import pages.TVPage;
import ultis.FindProperties;

public class InitialDriver {
	
	protected WebDriver driver;
	protected IndexPage indexPage;
	protected MobilePage mobilePage;
	protected CheckoutPage checkoutPage;
	protected RegistryPage registryPage;
	protected MyAccountPage myAccountPage;
	protected TVPage tvPage;
	protected LoginRegistryPage loginRegistryPage;
	protected String email;
	
	@BeforeMethod
	public void StartBrowser() throws IOException {
		
		// start browser
//		new feature, don't need line below to invoke firefox/chrome driver, because SeleniumManager do that
//		WebDriverManager.firefoxdriver().setup(); don't need this line
//		driver = new FirefoxDriver();
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.get(FindProperties.locateProperty("base_URL"));
		
		indexPage = new IndexPage(driver);
		mobilePage = new MobilePage(driver);
		checkoutPage = new CheckoutPage(driver);
		registryPage = new RegistryPage(driver);
		myAccountPage = new MyAccountPage(driver);
		tvPage = new TVPage(driver);
		loginRegistryPage = new LoginRegistryPage(driver);
		
		
		
	}
	
	
	@AfterMethod
	public void CloseBrowser() throws InterruptedException {
		Thread.sleep(1000);
		driver.close();
	}
}
