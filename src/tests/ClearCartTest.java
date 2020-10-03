package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.CartSummaryPage;
import pages.LocationPopupPage;
import pages.MealPage;
import pages.NotificationSystemPage;

public class ClearCartTest extends BasicTest {
	
	@Test
	public void clearCartTest() throws InterruptedException, IOException {
		this.driver.navigate().to(baseURL + "meals");
		LocationPopupPage lPP = new LocationPopupPage(driver, waits, js);
		lPP.closePopup();
		
		lPP.openSelectLocation();
		lPP.setLocation("City Center - Albany");
		Thread.sleep(2000);
		
		File file = new File("data/data.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Meals");
		
		for (int i = 1; i < sheet.getLastRowNum(); i++) {
			XSSFRow row = sheet.getRow(i);
			String urlMeal = row.getCell(0).getStringCellValue();
			this.driver.navigate().to(urlMeal);
			
			MealPage mp = new MealPage(driver, waits, js);
			mp.addMealtoCart("2");
			Thread.sleep(2000);
			NotificationSystemPage nsp = new NotificationSystemPage(driver, waits, js);
			
			SoftAssert sa = new SoftAssert();
			sa.assertTrue(nsp.notificationMsg().contains("Meal Added To Cart"), "[ERROR] Nothing added to cart!");
			Thread.sleep(2000);
			
			CartSummaryPage csp = new CartSummaryPage(driver, waits, js);
			csp.clearAllfromCart();
			
			Assert.assertTrue(nsp.notificationMsg().contains("All meals removed from Cart successfully"),
					"[ERROR] Cart not empty!");
			
		}
	
	}

}
