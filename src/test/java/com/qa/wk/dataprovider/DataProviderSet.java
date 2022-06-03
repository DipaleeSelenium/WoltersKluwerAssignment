package com.qa.wk.dataprovider;

import org.testng.annotations.DataProvider;

import com.qa.wk.base.TestBase;
import com.qa.wk.utilities.TestUtilities;

public class DataProviderSet extends TestBase {

	String sheetName1 = "validTodosData";
	String sheetName2 = "editTodosData";

	@DataProvider
	public Object[][] getTestDataTodos() {
		Object[][] data = TestUtilities.getTestData(sheetName1);
		return data;
	}

	@DataProvider
	public Object[][] getEditTestDataTodos() {
		Object[][] data = TestUtilities.getTestData(sheetName2);
		return data;
	}

}
