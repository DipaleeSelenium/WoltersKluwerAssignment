package com.qa.wk.base;

import org.openqa.selenium.support.PageFactory;

public class TestBase extends Controller {

	public TestBase() {
		PageFactory.initElements(driver, this);
	}

}
