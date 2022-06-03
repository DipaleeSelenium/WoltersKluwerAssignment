package com.qa.wk.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.qa.wk.utilities.TestUtilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Controller {

	public static Properties prop;
	public static WebDriver driver;

	public Controller() {

		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream(
					"C:/Users/Dipalee/eclipse-workspace/WoltersKluwerAutomation/src/main/java/com/qa/wk/config/Properties");
			try {
				prop.load(ip);
			} catch (IOException e) {

				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void initialization() {
		String browserName = prop.getProperty("Browser");

		if (browserName.equals("chrome")) {
			driver = WebDriverManager.chromedriver().create();
		} else if (browserName.equals("Firefox")) {
			driver = WebDriverManager.firefoxdriver().create();
		} else {
			System.out.println("no browser found");
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(TestUtilities.IMPLICIT_WAIT);
		driver.manage().timeouts().pageLoadTimeout(TestUtilities.PAGELOAD_TIME);
		driver.get(prop.getProperty("URL"));

	}

}
