package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends BasicPage {

	public ProfilePage(WebDriver driver, WebDriverWait waits, JavascriptExecutor js) {
		super(driver, waits, js);
		
	}
	
	public WebElement getFirstname() {
		return this.driver.findElement(By.name("user_first_name"));
		
	}
	
	public WebElement getLastName() {
		return this.driver.findElement(By.name("user_last_name"));
		
	}
	
	public WebElement getAddress() {
		return this.driver.findElement(By.name("user_address"));
		
	}
	
	public WebElement getPhone() {
		return this.driver.findElement(By.name("user_phone"));
		
	}
	
	public WebElement getZipcode() {
		return this.driver.findElement(By.name("user_zip"));
		
	}
	
	public Select getCountry() {
		WebElement country = this.driver.findElement(By.id("user_country_id"));
		Select select = new Select(country);	
		return select;
	}
	
	public Select getState() {
		WebElement state = this.driver.findElement(By.id("user_state_id"));
		Select sState = new Select(state);
		return sState;
		
	}
	
	public Select getCity() {
		WebElement city = this.driver.findElement(By.id("user_city"));
		Select sCity = new Select(city);
		return sCity;
		
	}
	
	public WebElement getSavebtn() {
		return this.driver.findElement(By.xpath("//*[@id='profileInfoFrm']/div[5]/div/fieldset/input"));
		
	}
	
	public WebElement getuploadBtn() {
		return this.driver.findElement(By.xpath("//*[@id='profileInfo']/div/div[1]/div/a[1]"));
		
	}
	
	public void clickuploadBtn() {
		this.js.executeScript("arguments[0].click();", this.getuploadBtn());
		
	}
	
	public WebElement uploadImage() {
		return this.driver.findElement(By.xpath("//*[@id='form-upload']/input"));
	}
	
	
	public void uploadImg(String imgPath) throws IOException {
	this.uploadImage().sendKeys(imgPath);

	}
 	
	public WebElement removeImg() {
		return this.driver.findElement(By.xpath("//*[@id='profileInfo']/div/div[1]/div/a[2]"));
		
	}
	
	public void deleteImg() {
		
		this.js.executeScript("arguments[0].click();" , this.removeImg());
		
	}
	
	public void editProfile(String firstName, String lastName, String Address, 
			String phone, String zipcode, String country, String state, String city) throws InterruptedException {
		
		this.getFirstname().click();
		this.getFirstname().sendKeys(Keys.CONTROL + "a");
		this.getFirstname().sendKeys(Keys.DELETE);
		this.getFirstname().sendKeys(firstName);
		Thread.sleep(2000);
		this.getLastName().click();
		this.getLastName().sendKeys(Keys.CONTROL + "a");
		this.getLastName().sendKeys(Keys.DELETE);
		this.getLastName().sendKeys(lastName);
		Thread.sleep(2000);
		this.getAddress().click();
		this.getAddress().sendKeys(Keys.CONTROL + "a");
		this.getAddress().sendKeys(Keys.DELETE);
		this.getAddress().sendKeys(Address);
		Thread.sleep(2000);
		this.getPhone().click();
		this.getPhone().sendKeys(Keys.CONTROL + "a");
		this.getPhone().sendKeys(Keys.DELETE);
		this.getPhone().sendKeys(phone);
		Thread.sleep(2000);
		this.getZipcode().click();
		this.getZipcode().sendKeys(Keys.CONTROL + "a");
		this.getZipcode().sendKeys(Keys.DELETE);
		this.getZipcode().sendKeys(zipcode);
		Thread.sleep(2000);
		
		this.getCountry().selectByVisibleText(country);
		Thread.sleep(3000);
		this.getState().selectByVisibleText(state);
		Thread.sleep(3000);
		this.getCity().selectByVisibleText(city);
		Thread.sleep(3000);
		this.js.executeScript("arguments[0].click();",this.getSavebtn());
			
	}
	

}
