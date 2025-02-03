package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	static WebDriver driver;
	Actions act;
	Robot r;
	ExcelReader er;

	public BasePage(WebDriver driver) throws AWTException {
		BasePage.driver = driver;
		act = new Actions(driver);
		er = new ExcelReader();
		r = new Robot();
	}

	// The method is for webdriver wait
	public void waitMethod(int time, By ele) {

		WebDriverWait wb = new WebDriverWait(driver, Duration.ofSeconds(time));
		wb.until(ExpectedConditions.elementToBeClickable(ele));

	}

	// The method is for scrolling
	public void wheelScroll(int y, WebElement ele) {

		WheelInput.ScrollOrigin scrollOrigin = WheelInput.ScrollOrigin.fromElement(ele);
		act.scrollFromOrigin(scrollOrigin, 0, y).build().perform();

	}

}
