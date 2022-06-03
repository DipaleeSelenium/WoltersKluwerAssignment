package com.qa.wk.actions;

import static org.testng.Assert.assertEquals;

import java.util.NoSuchElementException;

import org.openqa.selenium.Keys;

import com.qa.wk.objects.TodosPageObject;
import com.qa.wk.utilities.TestUtilities;

public class TodosPageAction extends TodosPageObject {

	public void getPageTitle() {
		String actualTitle = driver.getTitle();
		String expectedTitle = TestUtilities.PAGE_TITLE;
		assertEquals(actualTitle, expectedTitle, "page title not matching");
		System.out.println("Title of the Webpage is:" + " " + actualTitle);
	}

	public void getHeadTitle() throws InterruptedException {
		String actualHeadTitle = txt_todoHeadTitle.getText();
		String expectedHeadTitle = TestUtilities.HEAD_TITLE;
		assertEquals(actualHeadTitle, expectedHeadTitle, "head title not matching");
		System.out.println("Heading of the page is:" + " " + actualHeadTitle);

	}

	public void getLinkCountTextAndClick() {
		System.out.println("Count of links on todos page:" + "  " + linkList.size());
		for (int i = 0; i < linkList.size(); i++) {
			String linkText = linkList.get(i).getText();
			System.out.println(linkText);
			linkList.get(i).click();
			driver.navigate().back();
		}
	}

	public void addDetails(String inputTodoText) {
		txt_todoInputField.sendKeys(inputTodoText);
		txt_todoInputField.sendKeys(Keys.ENTER);
	}

	public void addTodos(String inputText) {
		addDetails(inputText);
		String actualInputData = txt_todosInputData.getText();
		driver.navigate().refresh();
		String expectedInputData = txt_todosInputData.getText();
		assertEquals(actualInputData, expectedInputData, "todos data matching after refresh");
	}

	public void clearTodosUsingCheckbox(String inputText) {
		addDetails(inputText);
		chk_todosOptionData.click();
		btn_clear.click();
		txt_todoInputField.sendKeys(Keys.ENTER);
		boolean actualResult = TestUtilities.checkElementPresent(chk_todosOptionData);
		try {
			if (actualResult) {
				actualResult = true;
			} else {
				actualResult = false;
			}

		} catch (NoSuchElementException e) {

		}

		boolean expectedResult = false;
		assertEquals(actualResult, expectedResult);

	}

	public void clearTodosUsingCross(String inputText) {

		addDetails(inputText);
		TestUtilities.actionMouseMovement(chk_todosOptionData);
		btn_destroy.click();
		txt_todoInputField.sendKeys(Keys.ENTER);
		boolean actualResult = TestUtilities.checkElementPresent(chk_todosOptionData);
		try {
			if (actualResult) {
				actualResult = true;
			} else {
				actualResult = false;
			}

		} catch (NoSuchElementException e) {

		}

		boolean expectedResult = false;
		assertEquals(actualResult, expectedResult);
	}

}
