package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NotificationSystemPage extends BasicPage {

	public NotificationSystemPage(WebDriver driver, WebDriverWait waits, JavascriptExecutor js) {
		super(driver, waits, js);
		
	}
	
	public WebElement getsetupMsg() {
		return this.driver.findElement(By.xpath(
		"//*[contains(@class, 'alert--success') or contains(@class, 'alert--danger')][contains(@style,'display: block')]"));
	
	}
	
	public String notificationMsg() {
		String notificationMessage = this.getsetupMsg().getText();
		return notificationMessage;
	}
	
	public boolean notificationDissapear() {
		WebElement msgDissapear = this.driver.findElement(By.xpath("//*[contains(@class, 'system_message')]"));
		
		boolean notification = this.waits.until(ExpectedConditions.attributeToBe(msgDissapear, "style", "display: none;"));
		return notification;		
		
	}
	

}
