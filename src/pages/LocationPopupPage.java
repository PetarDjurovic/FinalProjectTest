package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LocationPopupPage extends BasicPage {

	public LocationPopupPage(WebDriver driver, WebDriverWait waits, JavascriptExecutor js) {
		super(driver, waits, js);
		
	}
	
	public WebElement getSelectLocation() {
		return this.driver.findElement(By.xpath("//*[@class='location-selector']/a"));
		
	}
	
	public WebElement getClosebtn() {
		return this.driver.findElement(By.xpath("//*[@class='close-btn close-btn-white']"));
		
	}
	
	public WebElement getKeyword() {
		return this.driver.findElement(By.xpath("//*[@id='locality_keyword']"));
		
	}
	
	public WebElement getLocationItem(String locationName) {
		return this.driver.findElement(By.xpath("//li/a[contains(text(), '" + locationName + "')]/.."));
		
	}
	
	public WebElement getLocationInput() {
		return this.driver.findElement(By.xpath("//*[@id='location_id']"));
		
	}
	
	public WebElement getSubmit() {
		return this.driver.findElement(By.xpath("//*[@name='btn_submit']"));
		
	}
	
	public void openSelectLocation() {
		this.getSelectLocation().click();
		
	}
	
	public void setLocation(String locationName) {
		this.getKeyword().click();
		String locationValue = this.getLocationItem(locationName).getAttribute("data-value");
		
		this.js.executeScript("arguments[0].value=arguments[1]", this.getLocationInput(), locationValue);
	
		this.js.executeScript("arguments[0].click();", this.getSubmit());
		
	}
	
	public void closePopup() {
		this.getClosebtn().click();
	}
	
	

}
