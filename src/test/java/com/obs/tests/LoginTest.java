package com.obs.tests;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.obs.pages.LoginPage;

public class LoginTest extends BaseTest{
	LoginPage lpage;
	
	@BeforeMethod
	public void invokeLoginPage() {
		lpage = new LoginPage(driver);
	}
	
	//verify that user is able to login to the page with valid uname and password
	@Test(priority = 0, enabled= true)
	public void verifyValidLogin() throws Exception {
		
		lpage.typeUserName("standard_user");
		lpage.typePasword("secret_sauce");
		lpage.clickLogin();
		Assert.assertTrue(lpage.isHamBurgerBtnDisplayed(), "Inventory page is not displayed");
		lpage.goBrowserBackward();
	}
	
	//verify that user is unable to login to the page with invalid uname and password
	@Test(priority = 1, enabled= true)
	public void verifyInValidLogin() throws Exception {
			
		lpage.typeUserName("standard_us");
		lpage.typePasword("secret_sau");
		lpage.clickLogin();
		Assert.assertTrue(lpage.isInvalidErrorMsgDisplayed(), "Invalid error msg is not displayed");
		lpage.refreshTheBrowser();
	}
	
	//verify that user is unable to login to the page with empty uname and password
	@Test(priority = 2, enabled= true)
	public void verifyEmptyLogin() throws Exception {
		lpage.typeUserName("");
		lpage.typePasword("");
		lpage.clickLogin();
		Thread.sleep(2000);
		Assert.assertTrue(lpage.isEmptyErrorMsgDisplayed(), "Empty error msg is not displayed");
		lpage.refreshTheBrowser();
	}
	
	//verify that user is unable to login to the page with valid uname and invalid password
	@Test(priority = 3, enabled= true)
	public void verifyLoginWithInvalidPassword() throws Exception {
				
		lpage.typeUserName("standard_user");
		lpage.typePasword("secret_sau");
		lpage.clickLogin();
		Assert.assertTrue(lpage.isInvalidErrorMsgDisplayed(), "Invalid error msg is not displayed");
		lpage.refreshTheBrowser();
	}
	
	
	
	//verify that user is unable to login to the page with invalid uname and valid password
	@Test(priority = 4, enabled= true)
	public void verifyLoginWithInvalidUname() throws Exception {
			
		lpage.typeUserName("standard_us");
		lpage.typePasword("secret_sauce");
		lpage.clickLogin();
		Assert.assertTrue(lpage.isInvalidErrorMsgDisplayed(), "Invalid error msg is not displayed");
	}
	
	//-----------data provider----------------------------------
	/*
	 @Test(dataProvider = "Credientials")
	public void validateAllLogin(String uname, String pwd) {
		
		lpage = new LoginPage(driver);
		lpage.typeUserName(uname);
		lpage.typePasword(pwd);
		lpage.clickLogin();
		Assert.assertTrue(lpage.isHamBurgerBtnDisplayed(), "Inventory page is not displayed");
		driver.navigate().back();
	}
	
	@DataProvider (name = "Credientials")
	public Object[][] getData(){
		Object[][] data = new Object[4][2];
		data[0][0] = "locked_out_user";
		data[0][1] = "secret_sauce";
		data[1][0] = "locked_out_user";
		data[1][1] = "secret_sauce";
		data[2][0] = "problem_user";
		data[2][1] = "secret_sauce";
		data[3][0] = "performance_glitch_user";
		data[3][1] = "secret_sauce";
		return data;
	}
	//--------------data proivider (end)-------------------------------
	
	//----------------Screenshot-------------------------
	@Test (priority = 0)
	public void capturePageScreenshot() throws IOException {
		//TakesScreenshot interface enables the Selenium WebDriver to take a screenshot and store it in different ways. 
		 // "getScreenshotAs()" method captures the screenshot and store it in the specified location.
		     File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		     FileHandler.copy(src, new File("PageScreenshot.png"));
		}
*/
	
	

}
