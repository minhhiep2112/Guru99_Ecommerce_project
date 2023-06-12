package test_cases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import initDriver.InitialDriver;

public class TC001_Sort_By extends InitialDriver{
	
	@Test()
	public void sortByName() {
		
		
		
		System.out.println(driver.findElement(By.xpath("//div[@class='page-title']/h2")).getText());
		
		assertTrue(driver.findElement(By.xpath("//div[@class='page-title']/h2")).getText().contains("THIS IS DEMO SITE"),"Wrong message!");
		indexPage.clickMobileButton();
		
		assertTrue(driver.getTitle().equals("Mobile"),"Wrong title!");
		mobilePage.sortByName();
		
		List<WebElement> nameList = driver.findElements(By.xpath("//h2[@class='product-name']")); 
		List<String> names = nameList.stream() 
		                             .map(x->x.getText())
		                             .toList();
		               //            .collect(Collectors.toList());
			
		System.out.println(names);
		
		List<String> areSorted = names.stream().sorted().toList();
		
		System.out.println(areSorted);
		
		
				
//		List<String> revareSorted = names.stream().sorted(Comparator.reverseOrder()).toList(); 
	//	System.out.println(revareSorted);  
		
		assertEquals(names, areSorted,"Sort by is not right!");
		
	}
	
}
