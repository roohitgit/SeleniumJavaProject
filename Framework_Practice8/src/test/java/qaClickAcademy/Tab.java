package qaClickAcademy;

import java.util.Iterator;
import java.util.Set;

import org.testng.annotations.Test;

import pageObjects.QaClickAcademy;
import resources.BaseClass;
@Test
public class Tab extends BaseClass {
	public void tab() throws Exception
	{
		OpenBrowser();
		driver.get(url);
		QaClickAcademy pp = new QaClickAcademy(driver);
		pp.tab().click();
		Set<String> s = driver.getWindowHandles();
		Iterator<String>it = s.iterator();
		String parent =  it.next();
		String child =  it.next();
		driver.switchTo().window(child);
		Thread.sleep(2000);
		driver.close();
		driver.switchTo().window(parent);
		driver.close();
		
		
		
	}
	

}
