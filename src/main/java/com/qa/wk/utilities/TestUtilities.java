package com.qa.wk.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.qa.wk.base.TestBase;

public class TestUtilities extends TestBase {

	public static String PAGE_TITLE = "Angular2 • TodoMVC";
	public static String HEAD_TITLE = "todos";
	public static Duration IMPLICIT_WAIT = Duration.ofSeconds(20);
	public static Duration PAGELOAD_TIME = Duration.ofSeconds(30);

	public static String TESTSHEET_PATH = "C:/Users/Dipalee/eclipse-workspace/WoltersKluwerAutomation/src/main/java/com/qa/wk/testdata/TodosTestData.xlsx";

	public static Workbook book;
	public static org.apache.poi.ss.usermodel.Sheet sheet;

	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTSHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			book = WorkbookFactory.create(file);
		} catch (EncryptedDocumentException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);

		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
				data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
			}
		}
		return data;
	}

	public static WebElement getWebElement(WebElement locator) {
		return locator;
	}

	public static void actionMouseMovement(WebElement locator) {
		Actions action = new Actions(driver);
		action.moveToElement(getWebElement(locator)).build().perform();

	}

	public static boolean checkElementPresent(WebElement locator) {
		locator = getWebElement(locator);
		try {
			if (locator.isDisplayed()) {
				System.out.println("element is present");
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
