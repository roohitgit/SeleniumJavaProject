package qaClickAcademy;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.QaClickAcademy;
import resources.BaseClass;

@Test
public class HideShow extends BaseClass {
	public void hideshow() throws Exception
	{
		OpenBrowser();
		driver.get(url);
		QaClickAcademy pp = new QaClickAcademy(driver);
		pp.showButton().click();
		Assert.assertTrue(pp.hideshowTextField().isEnabled());
		pp.hideshowTextField().sendKeys("RohitBadole");
		pp.hideButton().click();
		Thread.sleep(1000);
		//Assert.assertFalse(pp.hideshowTextField().isEnabled());
		pp.showButton().click();
		Thread.sleep(1000);
		pp.hideButton().click();
		Thread.sleep(1000);
		pp.showButton().click();
		Thread.sleep(1000);
		pp.hideButton().click();
		Thread.sleep(1000);
		driver.close();
		
		
		
		
	}
	
	

}
