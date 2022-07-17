package qaClickAcademy;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;

import pageObjects.QaClickAcademy;
import resources.BaseClass;

@Test
public class RadioButtons extends BaseClass {

	public void radiobuttons() throws Exception {
		OpenBrowser();

		driver.get(url);
		QaClickAcademy pp = new QaClickAcademy(driver);
		pp.radio1().click();
		Assert.assertTrue(pp.radio1().isSelected());
		extentTest.get().info("after radio 1 click", MediaEntityBuilder.createScreenCaptureFromPath(Capture(driver)).build());
		pp.radio2().click();
		Assert.assertFalse(pp.radio1().isSelected());
		pp.radio3().click();
		driver.close();

	}

}
