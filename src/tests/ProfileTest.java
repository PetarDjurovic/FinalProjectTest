package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.AuthPage;
import pages.LocationPopupPage;
import pages.LoginPage;
import pages.NotificationSystemPage;
import pages.ProfilePage;

public class ProfileTest extends BasicTest {

	
	@Test
	public void editProfileTest() throws InterruptedException {

		this.driver.get(baseURL + "guest-user/login-form");

		LocationPopupPage locPopup = new LocationPopupPage(driver, waits, js);
		locPopup.closePopup();

		LoginPage lp = new LoginPage(driver, waits, js);
		lp.Login(username, password);
		Thread.sleep(2000);
		NotificationSystemPage nsp = new NotificationSystemPage(driver, waits, js);

		SoftAssert sa = new SoftAssert();
		sa.assertTrue(nsp.notificationMsg().contains("Login Successfull"), "[ERROR] Login not successful!");
		this.driver.navigate().to(baseURL + "member/profile");

		ProfilePage pp = new ProfilePage(driver, waits, js);
		pp.editProfile("Michael", "Myers", "357 Elm Street", "381 555 9999", "21000", "United Kingdom", "Wales",
				"Barry");

		sa.assertTrue(nsp.notificationMsg().contains("Setup Successful"), "[ERROR] Setup not successful!");
		Thread.sleep(2000);

		AuthPage ap = new AuthPage(driver, waits, js);
		ap.Logout();
		sa.assertTrue(nsp.notificationMsg().contains("Logout Successfull!"), "[ERROR] Logout unsuccessfull!");
		Thread.sleep(2000);

		sa.assertAll();

	}

}
