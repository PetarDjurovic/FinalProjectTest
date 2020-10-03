package tests;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.AuthPage;
import pages.LocationPopupPage;
import pages.LoginPage;
import pages.NotificationSystemPage;
import pages.ProfilePage;

public class ChangeProfileImageTest extends BasicTest {
	
	@Test
	public void changeImgTest() throws InterruptedException, IOException {
        this.driver.navigate().to(baseURL + "guest-user/login-form");
		
		LocationPopupPage lPP = new LocationPopupPage(driver, waits, js);
		lPP.closePopup();
		Thread.sleep(2000);
		
		LoginPage lp = new LoginPage(driver, waits, js);
		lp.Login(username, password);
		Thread.sleep(2000);
        NotificationSystemPage nsp = new NotificationSystemPage(driver, waits, js);
		
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(nsp.notificationMsg().contains("Login Successfull"), "[ERROR] Login not successful!");
		
		this.driver.navigate().to(baseURL + "member/profile");
		
		ProfilePage pp = new ProfilePage(driver, waits, js);
		pp.clickuploadBtn();
		Thread.sleep(2000);
		String imgPath = new File("images/profile.png").getCanonicalPath();
		pp.uploadImg(imgPath);
		
		sa.assertTrue(nsp.notificationMsg().contains("Profile Image Uploaded Successfully"), "[ERROR] Profile image not uploaded!");
		Thread.sleep(2000);
	
		nsp.notificationDissapear();
		
		pp.deleteImg();
		Thread.sleep(2000);
		sa.assertTrue(nsp.notificationMsg().contains("Profile Image Deleted Successfully"), "[ERROR] Profile image not removed!");
		
		nsp.notificationDissapear();
		
		AuthPage ap = new AuthPage(driver, waits, js);
		ap.Logout();
		sa.assertTrue(nsp.notificationMsg().contains("Logout Successfull!"), "[ERROR] Logout unsuccessful!");
		Thread.sleep(2000);	
		
		sa.assertAll();
		
	}
	
	
	

}
