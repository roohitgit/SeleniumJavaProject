package qaClickAcademy;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.QaClickAcademy;
import resources.BaseClass;
@Test
public class Checkbox extends BaseClass {
	public void checkbox() throws Exception
	{
		OpenBrowser();
		driver.get(url);
		QaClickAcademy pp = new QaClickAcademy(driver);
		Assert.assertFalse(pp.checkbox1().isSelected());
		Assert.assertFalse(pp.checkbox2().isSelected());
		Assert.assertFalse(pp.checkbox3().isSelected());
		pp.checkbox1().click();
		Assert.assertTrue(pp.checkbox1().isSelected());
		Thread.sleep(1500);
		
		pp.checkbox2().click();
		Assert.assertTrue(pp.checkbox2().isSelected());
		Thread.sleep(1500);
		pp.checkbox3().click();
		Assert.assertTrue(pp.checkbox3().isSelected());
		Thread.sleep(1500);
		driver.close();
		
		
	}

}
