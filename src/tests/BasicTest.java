package tests;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public abstract class BasicTest {
	
	protected WebDriver driver;
	protected WebDriverWait waits;
	protected JavascriptExecutor js;
	protected String baseURL = "http://demo.yo-meals.com/";
	protected String username = "customer@dummyid.com";
	protected String password = "12345678a";
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
		this.driver = new ChromeDriver();
		this.driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		this.driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		this.waits = new WebDriverWait(driver, 25);
		this.js = (JavascriptExecutor) driver;
		this.driver.manage().window().maximize();
		
	}
	
	@AfterMethod
	public void afterTest(ITestResult result) throws IOException {
		Date date = Calendar.getInstance().getTime();  
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");  
        String strDate = dateFormat.format(new Date());  
		
		if (result.getStatus() == ITestResult.FAILURE) {
			TakesScreenshot sc = (TakesScreenshot) driver;
			File screenshot = sc.getScreenshotAs(OutputType.FILE);
			File destination = new File("screenshots/" + strDate + ".png");
			FileHandler.copy(screenshot, destination);
			LocalDate dt = LocalDate.now();
		}
		
		this.driver.manage().deleteAllCookies();
		this.driver.navigate().refresh();
		
		}
	
	@AfterClass
	public void afterClass() {
		this.driver.quit();
	}

}
