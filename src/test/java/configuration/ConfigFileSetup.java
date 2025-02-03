package configuration;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileSetup {
	
	Properties property;
	
	public ConfigFileSetup() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\ABBHAVAN\\eclipse-workspace\\MakeMyTrip\\src\\test\\java\\configuration\\driverRepository.properties"));
		property = new Properties();
		property.load(br);
		br.close();
	}
	
	public String getChromeDriverName() {
		return property.getProperty("driverCName");
	}
	
	public String getChromeDriverPath() {
		return property.getProperty("driverCPath");
	}
	
	public String getMainURL() {
		return property.getProperty("mainUrl");
	}
}
