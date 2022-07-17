package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Properties;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class BaseClass 
{
	public WebDriver driver;
	public Properties prop;
	public String url;
	public ExtentTest test;
	public ExtentReports extent = ExtentReporterNG.getReportObject();
	public ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	
	
	
	public void OpenBrowser() throws Exception
	{
		Properties prop = new Properties();
		//FileInputStream fis = new FileInputStream("E:\\Rohit_Framework_Practice\\Workspace\\Framework_Practice\\src\\main\\java\\resources\\Config.properties");
		String currentDir = System.getProperty("user.dir");
		FileInputStream fis = new FileInputStream(currentDir+"\\src\\main\\java\\resources\\Config.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		this.url = prop.getProperty("qaclickurl");
		
		System.out.println(browserName);
		System.out.println(url);
	
		
		if (browserName.equals("chrome"))
		{
			
			//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rohit\\git\\repository\\Dental_Enroll\\driver\\chromedriver.exe");
			 driver = new ChromeDriver();
			
		}
		else if (browserName.equals("firefox"))
		{
			
			//System.setProperty("webdriver.gecko.driver", "C:\\Users\\Rohit\\git\\repository\\Dental_Enroll\\driver\\geckodriver.exe");
			 driver = new FirefoxDriver();
			
		}
		else if (browserName.equals("edge"))
		{
			driver = new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
		
		//driver.manage().timeouts().implicitlyWait(59, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		
	}
	
	@BeforeMethod
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
	}
	
	@AfterMethod
	
	public void onTestFailure(ITestResult result) {
		if(ITestResult.FAILURE==result.getStatus()){
			extentTest.get().fail(result.getThrowable());
			
		
		WebDriver driver = null;
		String testMethodName = result.getMethod().getMethodName();
		try {
			// driver =
			// (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			extentTest.get().addScreenCaptureFromPath(getScreenShotPath(testMethodName,driver), testMethodName);
			getScreenShotPath(testMethodName, driver);
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
		extent.flush();
		
	}
		
		
//		@AfterClass
//		public void flushReport() {
//	        extent.flush();
//	        driver.quit();
//	    }
	
	
	
	
	
	
	
	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException
	{
		TakesScreenshot scr = (TakesScreenshot) driver;
		File source = scr.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\Screenshots\\"+testCaseName+".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
		
	}
	
	public String Capture( WebDriver driver) throws IOException
	{
		
		LocalDate myObj = LocalDate.now();
		TakesScreenshot scr = (TakesScreenshot) driver;
		File source = scr.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\Screenshots\\"+myObj+".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
		
	}

	
	
	
	
}



