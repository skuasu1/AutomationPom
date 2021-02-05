package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	/*
	 * this method need to create the page factories to store all the web elements
	 * of the login page
	 */

	// Page factory to identify the username,password,login button and then sign up
	// button/ OR

	@FindBy(name = "username")
	WebElement username;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//input[@value='Login']")
	WebElement LoginBtn;

	@FindBy(xpath = "//a[normalize-space()='Sign Up']")
	WebElement SignUpBtn;

	// constructor to load page factory
	public LoginPage() {
		// to have the current object
		// all the variables are initialized with driver
		PageFactory.initElements(driver, this);
	}

	// Action class related to the Login Page

	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public HomePage Login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		LoginBtn.click();

		return new HomePage();

	}

}
