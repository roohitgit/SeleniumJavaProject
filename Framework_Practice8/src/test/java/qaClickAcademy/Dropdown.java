package qaClickAcademy;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import pageObjects.QaClickAcademy;
import resources.BaseClass;
@Test
public class Dropdown extends BaseClass {
	public void dropdown() throws Exception
	{
		OpenBrowser();
		driver.get(url);
		QaClickAcademy pp = new QaClickAcademy(driver);
		Select ss = new Select(pp.dropdown());
		ss.selectByIndex(3);
		Thread.sleep(1500);
		ss.selectByValue("option1");
		Thread.sleep(1500);
		ss.selectByVisibleText("Option2");
		Thread.sleep(1500);
		
		driver.close();
		
		
		
	}
	

}
