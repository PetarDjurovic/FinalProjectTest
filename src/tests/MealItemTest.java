package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.LocationPopupPage;
import pages.MealPage;
import pages.NotificationSystemPage;

public class MealItemTest extends BasicTest {
	
	@Test
       public void mealItemTest() throws InterruptedException {
		
		this.driver.get(baseURL + "meal/lobster-shrimp-chicken-quesadilla-combo");
		
		LocationPopupPage locPopup = new LocationPopupPage(driver, waits, js);
		locPopup.closePopup();
		
		MealPage mp = new MealPage(driver, waits, js);
		mp.addMealtoCart("3");
		Thread.sleep(2000);
		NotificationSystemPage nsp = new NotificationSystemPage(driver, waits, js);
		
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(nsp.notificationMsg().contains("The Following Errors Occurred:" + "\n" +
		"Please Select Location"), "[ERROR] No message displayed!");
				
		Thread.sleep(3000);
		nsp.notificationDissapear();
		
		LocationPopupPage lPP = new LocationPopupPage(driver, waits, js);
		lPP.openSelectLocation();
		lPP.setLocation("City Center - Albany");
		Thread.sleep(2000);
		mp.addMealtoCart("2");
		sa.assertTrue(nsp.notificationMsg().contains("Meal Added To Cart"), "[ERROR] Nothing added to cart!");
		
		sa.assertAll();

	}
	
}
