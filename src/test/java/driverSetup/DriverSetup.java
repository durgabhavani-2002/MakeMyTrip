package driverSetup;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import configuration.ConfigFileSetup;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverSetup {

	WebDriver driver;

	public WebDriver getDriver() throws IOException {
		ConfigFileSetup cfs = new ConfigFileSetup();

		System.setProperty(cfs.getChromeDriverName(), cfs.getChromeDriverPath());
		driver = new ChromeDriver();

		driver.get(cfs.getMainURL());
		driver.manage().window().maximize();

		return driver;
	}

}
