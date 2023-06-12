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
