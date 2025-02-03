package pages;

import java.awt.AWTException;
import java.awt.event.InputEvent;
import java.io.FileNotFoundException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class MakeMyTripPOM extends BasePage {

	public MakeMyTripPOM(WebDriver driver) throws AWTException {
		super(driver);
	}

	// This method is for removing the login page
	public void pop() throws InterruptedException {
		Thread.sleep(5000);
		r.mouseMove(150, 250);
		r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	}

	// This method is to click on buses in home page
	By busButton = By.xpath("//span[text()='Buses'][1]");

	public void busClick() throws InterruptedException {
		driver.findElement(busButton).click();
	}

	By fromcity = By.xpath("//label[@for='fromCity']");
	By from = By.cssSelector("input[title='From']");

	// This method is for selecting from city
	public void selectFromcity(String city) throws InterruptedException, FileNotFoundException {
		waitMethod(20, fromcity);
		driver.findElement(fromcity).click();

		waitMethod(20, from);
		WebElement ci = driver.findElement(from);
		er.input1(city);
		ci.sendKeys(er.sheet1.getRow(1).getCell(0).getStringCellValue());

		Thread.sleep(2000);
		act.keyDown(Keys.ARROW_DOWN).keyUp(Keys.ARROW_DOWN).build().perform();
		act.keyDown(Keys.ENTER).keyUp(Keys.ENTER).build().perform();

	}

	By tocity = By.xpath("//label[@for='toCity']");
	By to = By.cssSelector("input[title='To']");

	// This method is for the selecting the destination city
	public void selectDesCity(String city) throws InterruptedException, FileNotFoundException {

		waitMethod(20, to);

		WebElement ci = driver.findElement(to);
		er.input1(city);
		ci.sendKeys(er.sheet1.getRow(1).getCell(1).getStringCellValue());

		Thread.sleep(2000);
		act.keyDown(Keys.ARROW_DOWN).keyUp(Keys.ARROW_DOWN).build().perform();
		act.keyDown(Keys.ENTER).keyUp(Keys.ENTER).build().perform();

	}

	By date = By.xpath("//div[@class='DayPicker-Caption']/div");

	// This method is for selecting the date
	public void selectDate(String day) throws InterruptedException, FileNotFoundException {
		driver.findElement(date).click();
		Thread.sleep(5000);
		er.input1(day);
		String days = er.sheet1.getRow(1).getCell(6).getStringCellValue();
		driver.findElement(By.xpath("//div[@aria-label='" + days + "']")).click();

	}

	By search = By.cssSelector("button[id='search_button']");

	// This method is for clicking on the search button
	public void searchClick() {
		driver.findElement(search).click();
	}

	By bus = By.xpath("//p[text()='Ramana Tours And Travels']");
	By busesFound = By.xpath("//p[text()='30 buses found']");

	// This method is used for the selecting the preferred bu
	public void busSelect() {
		WebElement b = driver.findElement(busesFound);
		wheelScroll(300, b);
		driver.findElement(bus).click();
	}

	// This method is for getting the number of buses found
	public String busFound() {
		WebElement bus = driver.findElement(busesFound);
		String s = bus.getText();
		return s;
	}

	By seatLower = By.xpath(
			"(//div[@class='berth-name' and contains(text(), 'LOWER')]/following::li[contains(@class, 'busSeatItem')]//span[contains(text(), '₹1578')])[3]");
	By seatUpper = By.xpath(
			"//div[@class='berth-name' and contains(text(), 'UPPER')]/following::li[contains(@class, 'busSeatItem')]//span[contains(text(), '₹1278')]");

	// This method is for the selecting the lower or upper seat
	public void seatSelect(String s) throws InterruptedException {
		Thread.sleep(3000);
		if (s == "LOWER") {
			driver.findElement(seatLower).click();
		} else {
			driver.findElement(seatUpper).click();
		}

	}

	By pickup = By.xpath("//span[@class='latoBold busStopName' and text()='Padi']");
	By drop = By.xpath("//span[@class='latoBold busStopName' and text()='LB Nagar']");

	// This method is for selecting the pickup and drop location
	public void pickAndDrop() {
		driver.findElement(pickup).click();
		driver.findElement(drop).click();
	}

	By con = By.xpath("//span[text()='Continue']");

	// This method is for clicking on the continue button
	public void conClick() {
		WebElement s = driver.findElement(pickup);
		wheelScroll(200, s);
		driver.findElement(con).click();
	}

	By com = By.xpath("//h1[contains(text(), 'Complete your booking')]");

	// This method is for getting the text of complete your booking
	public String complete() throws InterruptedException {
		Thread.sleep(2000);
		WebElement bus = driver.findElement(com);
		String s = bus.getText();
		return s;
	}

	By name = By.cssSelector("input[id='fname']");
	By age = By.id("age");
	By gender = By.xpath("//div[text()='Female']");
	By email = By.id("contactEmail");
	By phone = By.id("mobileNumber");
	By confirm = By.xpath("//p[text()='Confirm and save billing details to your profile']");

	// This method is for details of passenger
	public void passDetails(String s) throws InterruptedException, FileNotFoundException {
		r.mouseMove(50, 250);
		Thread.sleep(5000);

		WebElement x = driver.findElement(com);
		wheelScroll(300, x);
		WebElement c = driver.findElement(com);
		wheelScroll(500, c);

		WebElement na = driver.findElement(name);
		er.input1(s);
		na.sendKeys(er.sheet1.getRow(1).getCell(2).getStringCellValue());

		WebElement a = driver.findElement(age);
		er.input1(s);
		a.sendKeys("" + (int) er.sheet1.getRow(1).getCell(3).getNumericCellValue());

		driver.findElement(gender).click();

		WebElement ema = driver.findElement(email);
		er.input1(s);
		ema.sendKeys(er.sheet1.getRow(1).getCell(4).getStringCellValue());

		WebElement mobile = driver.findElement(phone);
		er.input1(s);
		mobile.sendKeys("" + (long) er.sheet1.getRow(1).getCell(5).getNumericCellValue());

		wheelScroll(500, ema);
		driver.findElement(confirm).click();

	}

	By continu = By.xpath("//span[text()='Continue']");

	// This method is for clicking on the continue button
	public void continueClick() {
		driver.findElement(continu).click();
	}

	By booking = By.xpath("//span[text()='Your Booking']");

	// This method is for checking the confirmation of seat details
	public String bookin() {
		waitMethod(20, bus);
		WebElement bus = driver.findElement(booking);
		String s = bus.getText();
		return s;
	}
}
