/**
 * 
 */
package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.qa.util.TestUtil;

/**
 * @author Karthik it contains the browser load, property loading all will run
 *         aht the timeof the constructor calling whrn the method is called
 *
 */
public class TestBase {

	// these are the class level variables

	public static WebDriver driver;
	public static Properties propVar;

	// creating constructor
	public TestBase()  {
		/*
		 * this constructor is called all the time when this class is called so we need
		 * to load the property and then invoke the chrome
		 */

		// need to load the properties
		try {
			propVar = new Properties();
			FileInputStream inputstream = new FileInputStream(
					"D:\\Java Coding\\Eclipse\\Eclipse_workspae\\FreeCRMTest\\src\\main\\java\\"
							+ "com\\crm\\qa\\config\\config.properties");
			propVar.load(inputstream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialization() {
		// load the browser
		// get the chrome browser from the prop file and then load it into the Web
		// driver interface
		String BrowserName = propVar.getProperty("browser");

		if (BrowserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"D:\\Java Coding\\Chrome Driver\\chromePath\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIME_OUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_TIME_UNIT, TimeUnit.SECONDS);
		driver.get(propVar.getProperty("url"));
		driver.close();
	}
}
