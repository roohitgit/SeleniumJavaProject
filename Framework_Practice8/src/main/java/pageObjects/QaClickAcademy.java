package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class QaClickAcademy {
	
	WebDriver driver;
	
	private By radio1 = By.xpath("//*[@value='radio1']");
	private By radio2 = By.xpath("//*[@value='radio2']");
	private By radio3 = By.xpath("//*[@value='radio3']");
	private By textfield = By.xpath("//*[@id=\'autocomplete\']");
	private By dropdown = By.id("dropdown-class-example");
	private By checkbox1 = By.id("checkBoxOption1");
	private By checkbox2 = By.id("checkBoxOption2");
	private By checkbox3 = By.id("checkBoxOption3");
	private By window = By.id("openwindow");
	private By tab = By.id("opentab");
	private By hide = By.xpath("//*[@onclick='hideElement()']");
	private By show = By.xpath("//*[@onclick='showElement()']");
	private By hideShowTextField = By.xpath("//input[@id='displayed-text']");
	
	
	
	
	
	public QaClickAcademy(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement radio1()
	{
		return driver.findElement(radio1);
	}
	
	public WebElement radio2()
	{
		return driver.findElement(radio2);
	}
	
	public WebElement radio3()
	{
		return driver.findElement(radio3);
	}
	
	public WebElement textfield()
	{
		return driver.findElement(textfield);
	}
	
	public WebElement dropdown()
	{
		return driver.findElement(dropdown);
	}
	
	public WebElement checkbox1()
	{
		return driver.findElement(checkbox1);
	}
	
	public WebElement checkbox2()
	{
		return driver.findElement(checkbox2);
	}
	
	public WebElement checkbox3()
	{
		return driver.findElement(checkbox3);
	}
	
	public WebElement window()
	{
		return driver.findElement(window);
	}
	
	public WebElement tab()
	{
		return driver.findElement(tab);
	}
	
	public WebElement hideButton()
	{
		return driver.findElement(hide);
	}
	
	public WebElement showButton()
	{
		return driver.findElement(show);
	}
	
	public WebElement hideshowTextField()
	{
		return driver.findElement(hideShowTextField);
	}
	
	
}
