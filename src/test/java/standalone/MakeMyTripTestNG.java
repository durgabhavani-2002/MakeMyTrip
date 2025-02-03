package standalone;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;



import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import driverSetup.DriverSetup;
import pages.MakeMyTripPOM;


public class MakeMyTripTestNG {

	WebDriver driver;
	MakeMyTripPOM mp;
	
	@BeforeMethod
	public void setUp() throws IOException, AWTException {
		DriverSetup setup = new DriverSetup();
		driver = setup.getDriver();
		mp = new MakeMyTripPOM(driver);		
	}
	
	@Test
	public void performBooking() throws InterruptedException, IOException {
		Thread.sleep(5000);
		mp.pop();
		mp.busClick();
		
//		mp.selectFromcity();
//		mp.selectDesCity();
//		mp.selectDate();
		mp.searchClick();
		mp.busSelect();
//		mp.seatSelect();
		mp.conClick();
//		mp.passDetails();
	}
	
//	@AfterMethod
//	public void tearDown() {
//		driver.quit();
//	}
	
}
