package qaClickAcademy;

import org.testng.annotations.Test;

import pageObjects.QaClickAcademy;
import resources.BaseClass;
@Test
public class TextField extends BaseClass {
	public void textfield() throws Exception
	{
		OpenBrowser();
		driver.navigate().to(url);
		QaClickAcademy pp = new QaClickAcademy(driver);
		pp.textfield().sendKeys("RohitBadole");
		driver.close();
		
	}
	
	
	

}
