/*     Verify can create an account in e-Commerce site and can share wishlist to other poeple using email.  
Test Steps:
1. Go to http://live.techpanda.org/
2. Click on my account link
3. Click Create an Account link and fill New User information except Email ID
4. Click Register
5. Verify Registration is done. Expected account registration done.
6. Go to TV menu
7. Add product in your wish list - use product - LG LCD
8. Click SHARE WISHLIST 
9. In next page enter Email and a message and click SHARE WISHLIST
10.Check wishlist is shared. Expected wishlist shared successfully. 

*/

package test_cases;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import initDriver.InitialDriver;

public class TC005_Account_Creation extends InitialDriver {
	
	
	
	@Test()
	public void accountCreation(ITestContext e) {
		
		// registry new account
		// generate email to use in test cases
		// note that need to enter new email every time run test case
		
		String generatedString = RandomStringUtils.randomAlphanumeric(10);
		email = generatedString + "@gmail.com";
		System.out.println(email);
		
		e.setAttribute("email", email);
		
		
		indexPage.clickAccountButton();
		indexPage.clickMyAccount();
		registryPage.clickCreateAnAccount();
		registryPage.enterFirstName("tester012345");
		registryPage.enterMidName("ASD");
		registryPage.enterLastName("ZXC");
		registryPage.enterEmail(email);
		registryPage.enterPassword("qwert123");
		registryPage.enterConfirmationPassword("qwert123");
		registryPage.clickRegisterButton();
		
		
		try {
			driver.findElement(By.xpath("//li[@class='success-msg']"));
		}
		catch(NoSuchElementException ex) {
			Assert.fail("Successful registry message was not displayed!");
		}
		
		// choose an item to add to wishlist
		myAccountPage.clickTVLink();
		tvPage.clickAddToWishlistLG();
		myAccountPage.clickShareWishlist();
		
		// enter information then share
		myAccountPage.enterEmailToShare("tester0123456@gmail.com");
		myAccountPage.enterMessage("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
		myAccountPage.clickShareWishlist();
		
		try {
			driver.findElement(By.xpath("//li[@class='success-msg']"));
		}
		catch(NoSuchElementException ex) {
			Assert.fail("Wishlist share was not displayed!");
		}
	
	
		
		
	}
	
}
