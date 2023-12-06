package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import basePackage.BaseClass;

public class Utility {

	private static HSSFSheet ExcelWSheet;
	private static HSSFWorkbook ExcelWBook;
	private static HSSFCell Cell;

	public static final String path = System.getProperty("user.dir") + "\\src\\test\\resources\\";
	public static final String fileName = "BoxTestData.xls";
	public static final String SheetName = "LoginCreds";

	public static void captureScreenshot(String methodName) {
		String dateFormat = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss").format(new Date());

		File DestFile = new File(
				System.getProperty("user.dir") + "\\Screenshots\\" + methodName + "_" + dateFormat + ".png");

		File file = ((TakesScreenshot) BaseClass.getDriver()).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, DestFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void setExcelFile(String SheetName) throws Exception {
		try {
			FileInputStream ExcelFile = new FileInputStream(path + fileName);
			//ExcelWBook = new XSSFWorkbook(ExcelFile); HSSFWorkbook
			ExcelWBook= new HSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(SheetName);
		} catch (Exception e) {
			throw (e);
		}
	}

	public static String getCellData(int RowNum, int ColNum) throws Exception {
		try {
			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			String CellData = Cell.getStringCellValue();
			return CellData;
		} catch (Exception e) {
			return "";
		}
	}

	public static void cleanFiles() {
		File screenshotPath = new File(System.getProperty("user.dir") + "\\Screenshots");
		File reporterPath = new File(System.getProperty("user.dir") + "\\allure-results");
		if (screenshotPath.exists()) {
			try {
				FileUtils.deleteDirectory(screenshotPath);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (reporterPath.exists()) {
			try {
				FileUtils.deleteDirectory(reporterPath);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static Properties readPropertiesFile() {
		Properties prop = null;
		FileInputStream fis = null;

		try {
			fis = new FileInputStream("config.properties");
			prop = new Properties();
			prop.load(fis);
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return prop;
	}

}
