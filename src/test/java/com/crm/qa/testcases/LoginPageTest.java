/**
 * 
 */
package com.crm.qa.testcases;

import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

/**
 * @author Karthik
 *
 */
public class LoginPageTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;

	public LoginPageTest() {
		// to call test base cnstructor
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		loginpage = new LoginPage();
	}

	@Test(priority = 1)
	public void LoginPageTitletest() {
		String title = loginpage.validateLoginPageTitle();
		Assert.assertEquals(title, "CRMPRO  - CRM software for customer relationship management, sales, and support.");
	}

	@Test(priority = 2)
	public void Logintest() {
		homepage = loginpage.Login(propVar.getProperty("username"), propVar.getProperty("password"));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
