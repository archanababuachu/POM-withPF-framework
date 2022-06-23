package com.obs.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.obs.actions.SendKeysActionHelper;
import com.obs.actions.ValidationActionHelper;
import com.obs.actions.WebActionHelper;

public class LoginPage {
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		//initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}

	WebDriver driver;
	WebActionHelper wahObj = new WebActionHelper();
	ValidationActionHelper vahObj = new ValidationActionHelper();
	SendKeysActionHelper skahObj = new SendKeysActionHelper();
	
	@FindBy(xpath = "//input[@id='user-name' and @name='user-name']")
	WebElement uname;
	@FindBy(xpath = "//input[@id='password' and @name='password']")
	WebElement pwd;
	@FindBy(xpath = "//input[@id='login-button' and @name='login-button']")
	WebElement login;
	@FindBy(xpath = "//h3[contains(.,'Epic sadface: Username and password do not match any user in this service')]")
	WebElement invalidErrorMsg;
	@FindBy(xpath = "//h3[text()='Epic sadface: Username is required']")
	WebElement emptyErrorMsg;
	@FindBy(xpath = "//button[@id='react-burger-menu-btn']")
	WebElement hamBurgerBtn;
	
	public void typeUserName(String email) throws Exception {
		
		uname.clear();
		skahObj.sendKeys(driver, uname, email);
		//skahObj.sendKeysJsById(driver, "user-name", email);
	}
	
	public void typePasword(String password) throws Exception {
		skahObj.clearTextAndSendKeys(driver, pwd, password);
		//skahObj.sendKeysJsById(driver, "password", password);
	}
	
	public void clickLogin() {
		login.click();
	}
	
	public boolean isInvalidErrorMsgDisplayed() throws Exception {
		return vahObj.isElementVisible(driver, invalidErrorMsg);
	}
	
	public boolean isEmptyErrorMsgDisplayed() throws Exception {
		return vahObj.isElementSelected(driver, emptyErrorMsg);
	}
	
	public boolean isHamBurgerBtnDisplayed() throws Exception {
		return vahObj.isElementEnabled(driver, hamBurgerBtn);
	}
	
	public void goBrowserBackward() {
		wahObj.navigateBack(driver);
	}
	
	public void refreshTheBrowser() {
		wahObj.refreshBrowser(driver);
	}
}
