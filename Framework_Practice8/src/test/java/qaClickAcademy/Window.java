package qaClickAcademy;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.QaClickAcademy;
import resources.BaseClass;
@Test
public class Window extends BaseClass {
	public void window() throws Exception
	{
		OpenBrowser();
		driver.get(url);
		QaClickAcademy pp = new QaClickAcademy(driver);
		pp.window().click();
		Set<String> w = driver.getWindowHandles();
		Iterator<String> it = w.iterator();
		String parent =  it.next();
		String child =  it.next();
		driver.switchTo().window(child);
		String text1 = driver.findElement(By.xpath("//h3[text()='An Academy to learn Everything about Testing']")).getText();
		String text2 =  "AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING";
		Assert.assertEquals(text2, text1);
		driver.switchTo().window(parent);
		driver.close();
		
		
	}
	
	

}
