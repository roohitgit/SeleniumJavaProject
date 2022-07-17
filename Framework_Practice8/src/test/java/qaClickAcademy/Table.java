package qaClickAcademy;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import resources.BaseClass;

@Test
public class Table extends BaseClass {
	public void table() throws Exception
	{
		OpenBrowser();
		driver.get(url);
		WebElement table = driver.findElement(By.xpath("//table[@id='product' and @name='courses']"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		
		for (int i=0; i<rows.size();i++)
		{
			String t = rows.get(i).getText();
			System.out.println(t);
		}
		driver.close();
		
	}

}
