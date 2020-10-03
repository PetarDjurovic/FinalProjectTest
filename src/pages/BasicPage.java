package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasicPage {
	protected WebDriver driver;
	protected WebDriverWait waits;
	protected JavascriptExecutor js;
	
	public BasicPage(WebDriver driver, WebDriverWait waits, JavascriptExecutor js) {
		this.driver = driver;
		this.waits = waits;
		this.js = (JavascriptExecutor) driver;
	}

}
