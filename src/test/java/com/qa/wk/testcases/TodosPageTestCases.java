package com.qa.wk.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.wk.actions.TodosPageAction;
import com.qa.wk.base.TestBase;
import com.qa.wk.dataprovider.DataProviderSet;

public class TodosPageTestCases extends TestBase {

	TodosPageAction todos;

	@BeforeMethod(alwaysRun = true)
	public void setUp() {
		initialization();
		todos = new TodosPageAction();
	}

	// TestCase 1: Verify title of the page
	@Test(priority = 1)
	public void verifyTitleOfPage() {
		todos.getPageTitle();

	}

	// TestCase 2: Verify heading title of the page
	@Test(priority = 2)
	public void verifyHeadTitleOfPage() throws InterruptedException {
		todos.getHeadTitle();
	}

	// TestCase 3: Verify links and link text on the todos page
	@Test(priority = 3)
	public void verifyLinksOfpage() {
		todos.getLinkCountTextAndClick();
	}

	// TestCase 4: Verify add todos data
	@Test(priority = 4, dataProvider = "getTestDataTodos", dataProviderClass = DataProviderSet.class)
	public void verifyTodosData(String text) throws InterruptedException {

		todos.addTodos(text);

	}

	// TestCase 5: Verify clear todos data with checkbox functionality
	@Test(priority = 5, dataProvider = "getTestDataTodos", dataProviderClass = DataProviderSet.class)
	public void verifyClearTodoDataCheckbox(String text) throws InterruptedException {
		todos.clearTodosUsingCheckbox(text);
	}

	// TestCase 6: Verify clear todos data with cross functionality
	@Test(priority = 6, dataProvider = "getTestDataTodos", dataProviderClass = DataProviderSet.class)
	public void verifyClearTodosCross(String text) {
		todos.clearTodosUsingCross(text);
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
		driver.quit();

	}
}
