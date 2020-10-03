package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LocationPopupPage;
import pages.LoginPage;
import pages.MealPage;
import pages.NotificationSystemPage;

public class AddMealtoFavoriteTest extends BasicTest {
	
	@Test
	public void addMealtoFavoriteTest() throws InterruptedException {
		this.driver.navigate().to(baseURL + "meal/lobster-shrimp-chicken-quesadilla-combo");
		
		LocationPopupPage locPopup = new LocationPopupPage(driver, waits, js);
		locPopup.closePopup();
		
		MealPage mp = new MealPage(driver, waits, js);
		mp.addMealtoFavorites();
		
		NotificationSystemPage nsp = new NotificationSystemPage(driver, waits, js);
		Assert.assertTrue(nsp.notificationMsg().contains("Please login first!"), "[ERROR] User already logged in!");
		Thread.sleep(2000);
		
		this.driver.navigate().to(baseURL + "/guest-user/login-form");
		LoginPage lp = new LoginPage(driver, waits, js);
		lp.Login(username, password);
		Thread.sleep(2000);
		
		this.driver.navigate().to(baseURL + "meal/lobster-shrimp-chicken-quesadilla-combo");
		mp.addMealtoFavorites();
		Assert.assertTrue(nsp.notificationMsg().contains("Product has been added to your favorites."),
				"[ERROR] Product not added to favorites");
		

	}
	
	
}
