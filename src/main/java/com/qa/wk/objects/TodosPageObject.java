package com.qa.wk.objects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qa.wk.base.TestBase;

public class TodosPageObject extends TestBase {

	@FindBy(xpath = "//h1[contains(text(), 'todos')]")
	public WebElement txt_todoHeadTitle;

	@FindBy(xpath = "//header/input[1]")
	public WebElement txt_todoInputField;

	@FindBy(xpath = "//a")
	public List<WebElement> linkList;

	@FindBy(tagName = "label")
	public WebElement txt_todosInputData;

	@FindBy(xpath = "//body/todo-app[1]/section[1]/section[1]/ul[1]/li[1]/div[1]/input[1]")
	public WebElement chk_todosOptionData;

	@FindBy(xpath = "//button[contains(text(), 'Clear completed')]")
	public WebElement btn_clear;

	@FindBy(xpath = "//button[@class = 'destroy']")
	public WebElement btn_destroy;

}
