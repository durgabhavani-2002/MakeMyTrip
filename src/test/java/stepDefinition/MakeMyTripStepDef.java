package stepDefinition;

import static org.junit.Assert.assertEquals;

import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import driverSetup.DriverSetup;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import pages.MakeMyTripPOM;

public class MakeMyTripStepDef {

	static WebDriver driver;
	DriverSetup setup;
	MakeMyTripPOM mp;

	// It makes to land on the MakeMyTrip login paga
	@Given("User is on the MakeMyTrip")
	public void user_is_on_the_make_my_trip() throws AWTException, IOException {
		setup = new DriverSetup();
		driver = setup.getDriver();
		mp = new MakeMyTripPOM(driver);
	}

	// The method clicks on the bus in home page
	@When("User clicks on the bus")
	public void user_clicks_on_the_bus() throws InterruptedException {
		mp.pop();
		mp.busClick();
	}

	// The method is for entering the from city
	@When("User enters the fromcity")
	public void user_enters_the_fromcity(DataTable dataTable) throws InterruptedException, FileNotFoundException {
		List<String> s = dataTable.asList();
		mp.selectFromcity(s.get(0));
	}

	// The method is for entering destination city
	@When("User enters the destination city")
	public void user_enters_the_destination_city(DataTable dataTable)
			throws InterruptedException, FileNotFoundException {
		List<String> s = dataTable.asList();
		mp.selectDesCity(s.get(0));
	}

	// The method is for selecting the date
	@When("User selects the date")
	public void user_selects_the_date(DataTable dataTable) throws InterruptedException, FileNotFoundException {
		List<String> s = dataTable.asList();
		mp.selectDate(s.get(0));
	}

	// The method is for clicking on the search button
	@When("User clicks on the search button")
	public void user_clicks_on_the_search_button() {
		mp.searchClick();
	}

	// The method is for checking the number of buses found
	@When("User redirected to bus list page")
	public void user_redirected_to_bus_list_page() {
		String act = mp.busFound();
		String exp = "30 buses found";
		assertEquals(act, exp);
	}

	// The method for selecting the prefered bus
	@When("User selects the preferd bus")
	public void user_selects_the_preferd_bus() throws InterruptedException {
		mp.busSelect();
		mp.seatSelect("Upper");
	}

	// The method is for selecting the pickup and drop location
	@When("User selcts the pickup and drop point locations")
	public void user_selcts_the_pickup_and_drop_point_locations() {
		mp.pickAndDrop();
	}

	// The method is for clicking on the continue button
	@When("User click on the continue button")
	public void user_click_on_the_continue_button() {
		mp.conClick();
	}

	// The method is for checking for whether user redirected to complete your
	// booking page or not
	@When("User redirected to the complete your booking page")
	public void user_redirected_to_the_complete_your_booking_page() throws InterruptedException {
		String act = mp.complete();
		String exp = "Complete your booking";
		assertEquals(act, exp);
	}

	// The method is for entering the passenger details
	@When("User fills the personal detils")
	public void user_fills_the_personal_detils(DataTable dataTable) throws InterruptedException, FileNotFoundException {
		List<String> s = dataTable.asList();
		mp.passDetails(s.get(0));
	}

	// The method is for clicking on the continue button
	@When("User clicks on the continue button")
	public void user_clicks_on_the_continue_button() {
		mp.continueClick();
	}

	// The method is for checking for whether user redirected to payment page or not
	@Then("User is redirected to Payment page")
	public void user_is_redirected_to_payment_page() {
		String act = mp.bookin();
		String exp = "Your Booking";
		assertEquals(act, exp);
	}

	// The method is for closing the window after completion of the execution of
	// scenario
	@After
	public void tearDown1() {
		driver.quit();
	}

	// This method is for taking the screenshots
	@AfterStep
	public static void tearDown(Scenario scenario) {
		final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshot, "image/png", scenario.getName());
	}

}
