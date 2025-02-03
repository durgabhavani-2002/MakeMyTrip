package pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

public class ExcelReader {

	FileInputStream fis;
	XSSFWorkbook workbook;

	public XSSFSheet sheet1;

	// function to fetch the data from the excel file using apachi poi
	public void input1(String input) throws FileNotFoundException {
			try {
				File f = new File(
						"C:\\Users\\ABBHAVAN\\eclipse-workspace\\MakeMyTrip\\resources\\ExcelFiles\\" + input);
				fis = new FileInputStream(f);
				workbook = new XSSFWorkbook(fis);

				sheet1 = workbook.getSheetAt(0);
				return;

			} catch (Exception e) {
				// TODO
				e.printStackTrace();
			}
	}
	}
