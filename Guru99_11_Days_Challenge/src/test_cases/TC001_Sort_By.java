package test_cases;

import static org.testng.Assert.assertTrue;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import initDriver.InitialDriver;

public class TC001_Sort_By extends InitialDriver{
	
	@Test
	public void sortByName() {
	//	System.out.println(driver.findElement(By.xpath("//div[@class='page-title']/h2")).getText());
		assertTrue(driver.findElement(By.xpath("//div[@class='page-title']/h2")).getText().contains("THIS IS DEMO SITE"),"Wrong message!");
		indexPage.clickMobileButton();
		
		assertTrue(driver.getTitle().equals("Mobile"),"Wrong title!");
		mobilePage.sortByName();
		
		List<WebElement> nameList = driver.findElements(By.xpath("//h2[@class='product-name']")); 
		List<String> names = nameList.stream() 
		                             .map(n -> n.getText()) 
		                             .collect(Collectors.toList());         
		List<String> sortedNames = names;           
		Collections.sort(sortedNames);                                                 
		boolean areSorted =  names.equals(sortedNames);
		
		assertTrue(areSorted,"Sort by has problem!");
		
	}
	
}
