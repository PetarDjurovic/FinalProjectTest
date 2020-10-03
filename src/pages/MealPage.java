package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MealPage extends BasicPage {

	public MealPage(WebDriver driver, WebDriverWait waits, JavascriptExecutor js) {
		super(driver, waits, js);
		
	}
	
	public WebElement getAddtoCartBtn() {
		return this.driver.findElement(By.xpath("//*[@id='body']/section[1]/div/div/div[2]/div/div[3]/div[2]/a"));
		
	}
	
	public WebElement getQuantity() {
		return this.driver.findElement(By.xpath("//*[@name='product_qty']"));
		
	}
	
	public void addMealtoCart(String quantityNum) {
		this.getQuantity().click();
		this.getQuantity().sendKeys(Keys.CONTROL + "a");
		this.getQuantity().sendKeys(Keys.DELETE);
		this.getQuantity().sendKeys(Keys.INSERT + " + " + quantityNum +" ");
		this.getQuantity().sendKeys(Keys.ENTER);
		
		this.getAddtoCartBtn().click();
		
	}
	
	public void addMealtoFavorites() {
		this.driver.findElement(By.xpath("//*[@title='Favorite']")).click();
	}


}
