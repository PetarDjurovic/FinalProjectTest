package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasicPage {

	public LoginPage(WebDriver driver, WebDriverWait waits, JavascriptExecutor js) {
		super(driver, waits, js);
		
	}
	
	public void loginButton() {
		WebElement loginBtn = this.driver.findElement(By.xpath("//*[@class='accounts-link accounts-popup']/ul/li[2]"));
		loginBtn.click();
		
	}
	public WebElement getUsername() {
		return this.driver.findElement(By.name("username"));
	}
	
	public WebElement getPassword() {
		return this.driver.findElement(By.name("password"));
	}
	
	public WebElement getRememberMe() {
		return this.driver.findElement(By.name("remember_me"));
		
	}
	public WebElement getLogin() {
		return this.driver.findElement(By.name("btn_submit"));
		
	}
	
	public void Login(String username, String password) throws InterruptedException {
		
		this.getUsername().click();
		this.getUsername().sendKeys(Keys.CONTROL + "a");
		this.getUsername().sendKeys(Keys.DELETE);	
		this.getUsername().sendKeys(username);
		Thread.sleep(2000);
		
		this.getPassword().click();
		this.getPassword().sendKeys(Keys.CONTROL + "a");
		this.getPassword().sendKeys(Keys.DELETE);
		this.getPassword().sendKeys(password);
		Thread.sleep(2000);
		this.getRememberMe().click();
		Thread.sleep(2000);
		this.getLogin().click();
		
	}
	

}
