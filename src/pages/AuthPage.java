package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthPage extends BasicPage {

	public AuthPage(WebDriver driver, WebDriverWait waits, JavascriptExecutor js) {
		super(driver, waits, js);
		
	}
	
	public WebElement getAccountMenu() {
		return this.driver.findElement(By.xpath("//*[@class='accounts-link accounts-popup']/ul/li[1]/a"));
		
	}
	
	public WebElement getMyaccountBtn( ) {
		return this.driver.findElement(By.xpath("//*[@id='header']/div[2]/div/div[2]/div[2]/ul/li/div/ul/li[1]/a"));
		
	}
	
	public WebElement getLogoutbtn() {
		return this.driver.findElement(By.xpath("//*[@id='header']/div[2]/div/div[2]/div[2]/ul/li/div/ul/li[2]/a"));
		
	}
	
	public void Logout() {
		this.getAccountMenu().click();
		this.getLogoutbtn().click();
	}
	
	
	

}
