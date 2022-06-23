package com.obs.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.obs.pages.TestLeaf;

public class TestLeafTest extends BaseTest{

	TestLeaf tlObj;
	String parentWindow;
	
	@BeforeMethod
	public void invokeTestLeaf() {
		tlObj = new TestLeaf(driver);
	}
	//=========================WebActionHelper========================================================
	//verify that the browser is navigating to specified URL
	@Test(priority = 0, enabled = false)
	public void verifyNavigateToURL() {
		tlObj.giveNavigationUrl("http://www.leafground.com/home.html");
		Assert.assertEquals(tlObj.returnSiteTitle(), "TestLeaf - Selenium Playground");
	}
	
	//verify that the browser is navigating backward
	@Test(priority = 1, enabled = false)
	public void verifyNavigateBackward() {
		tlObj.navigateBrowserBackward();
		Assert.assertEquals(tlObj.returnSiteTitle(), "Swag Labs");
	}
	
	//verify that the browser is navigating forward
	@Test(priority = 2, enabled = false)
	public void verifyNavigateForward() {
		tlObj.navigateBrowserForward();
		Assert.assertEquals(tlObj.returnSiteTitle(), "TestLeaf - Selenium Playground");
	}
	/**
	 * verify the site URL is returned
	 */
	@Test(priority = 3, enabled = false)
	public void printSiteURL() {
		System.out.println("Site URL : "+tlObj.returnSiteURL());
	}
	/**
	 * verify the site Page Source is returned
	 */
	@Test(priority = 4, enabled = false)
	public void printSitePageSource() {
		System.out.println("Site PageSource : "+tlObj.returnSitePageSource());
	}
	/**
	 * verify the alert is accepting
	 */
	@Test(priority = 5, enabled = false)
	public void verifyAlertAccept() {
		tlObj.clickOnAlertLink();
		tlObj.clickShowAlertBtn();
		tlObj.acceptAlertBox();
		Assert.assertEquals(tlObj.returnSiteTitle(), "TestLeaf - Interact with Alerts");
		tlObj.refreshTheBrowser();
	}
	/**
	 * print alert box content
	 */
	@Test(priority = 6, enabled = false)
	public void printAlertBoxContent() {
		tlObj.clickShowAlertBtn();
		System.out.println("Alert Box Content : "+tlObj.returnAlertBoxContent());
	}
	/**
	 * verify the alert is dismissing
	 */
	@Test(priority = 7, enabled = false)
	public void verifyAlertDismiss() {
		tlObj.dismissAlertBox();
		tlObj.navigateBrowserBackward();
	}
	/*
	 * verify the control switched to frame
	 */
	@Test(priority = 8, enabled = false)
	public void verifySwitchToFrame() throws Exception {
		tlObj.clickFrameTab();
		tlObj.switchToFrame(0);
		Assert.assertEquals(tlObj.returnFrameButtonText(), "Hurray! You Clicked Me.");
	}
	/*
	 * verify the control switched to parent frame
	 * @throws Exception 
	 */
	@Test(priority = 9, enabled = false)
	public void verifySwitchToParentFrame() throws Exception {
		tlObj.switchToParentFrame();
		Assert.assertEquals(tlObj.returnFramePageHeading(), "Fun with frames");
	}
	/**
	 * print the total number of frames
	 * @throws Exception 
	 */
	@Test(priority = 10, enabled = false)
	public void printFrameCount() throws Exception {
		System.out.println("Total number of frames : "+tlObj.returnTotalFrameCount());
		tlObj.navigateBrowserBackward();
	}
	/*
	 * print total count of opened windows
	 * @throws Exception 
	 */
	@Test(priority = 11, enabled = false)
	public void printWindowCount() throws Exception {
		tlObj.clickWindowsTab();
		tlObj.clickMultipleWindowBtn();
		System.out.println("Total no of opened windows : "+tlObj.returnWindowCount());
	}
	/*
	 * verify the control is switching to newely opened window
	 */
	@Test(priority = 12, enabled = false)
	public void verifyWindowSwitching() throws Exception {
		parentWindow = tlObj.switchToNewWindow();
		Assert.assertEquals(tlObj.returnSiteTitle(), "TestLeaf - Interact with Buttons");
	}
	/*
	 * verify the current window is closing
	 * @throws Exception 
	 */
	@Test(priority = 13, enabled = false)
	public void closeTheWindow() throws Exception {
		tlObj.closeCurrentWindow();
		tlObj.switchToParentWindow(parentWindow);
	}
	//====================================UtilityActionHelper==========================================
	/*
	 *print row count
	 */
	@Test(priority = 14, enabled = false)
	public void printRowCount() throws Exception {
		tlObj.giveNavigationUrl("http://www.leafground.com/pages/table.html");
		System.out.println("Table row count : "+tlObj.returnTableRowCount());
		
	}
	/*
	 * print column count
	 */
	@Test(priority = 15, enabled = false)
	public void printColumnCount() throws Exception {
		System.out.println("Table column count : "+tlObj.returnTableColumnCount());
		
	}
	/*
	 * verify getting table content based on row and column value
	 */
	@Test(priority = 16, enabled = false)
	public void getTableCellText() throws Exception {
		System.out.println("Table Cell content : "+tlObj.returnTableCellContent(2, 2));
	}
	/*
	 * verify drop down is selecting by visible text
	 */
	@Test(priority = 17, enabled = false)
	public void verifySelectByVisibleText() throws Exception {
		tlObj.giveNavigationUrl("http://www.leafground.com/pages/Dropdown.html");
		tlObj.selectDropDownByVisibleText("Selenium");
		Assert.assertEquals(tlObj.returnDropDownValue(), "Selenium");
	}
	/*
	 * verify drop down is selecting by index
	 */
	@Test(priority = 18, enabled = false)
	public void verifySelectByIndex() throws Exception {
		tlObj.selectDropDownByIndex(3);
		Assert.assertEquals(tlObj.returnDropDownValue(), "UFT/QTP");
	}
	/*
	 * verify drop down is selecting by index
	 */
	@Test(priority = 19, enabled = false)
	public void verifySelectByValue() throws Exception {
		tlObj.selectDropDownByValue("2");
		Assert.assertEquals(tlObj.returnDropDownValue(), "Appium");
	}
	/*
	 * verify page screenshot
	 */
	@Test(priority = 20, enabled = false)
	public void takeScreenshot() throws Exception {
		tlObj.takeScreenShot();
	}
	/*
	 * verify drag and drop
	 */
	@Test(priority = 21, enabled = false)
	public void verifyDragAndDrop() throws Exception {
		tlObj.giveNavigationUrl("https://jqueryui.com/droppable/");
		tlObj.switchToFrame(0);
		tlObj.dragAndDrop();
		tlObj.switchToParentFrame();
	}
	/*
	 * verify drag to X and Y
	 */
	@Test(priority = 22)
	public void verifyDragToXandY() throws Exception {
		tlObj.giveNavigationUrl("https://jqueryui.com/draggable/");
		tlObj.switchToFrame(0);
		tlObj.dragToXY(140, 140);
		tlObj.switchToParentFrame();
		
	}
	//====================================ClickActionHelper==========================================
	/*
	 * verify right click operation
	 */
	@Test(priority = 23)
	public void verifyRightClickOperation() throws Exception {
		tlObj.giveNavigationUrl("https://jqueryui.com/draggable/");
		tlObj.switchToFrame(0);
		tlObj.performRightClick();
		tlObj.switchToParentFrame();
	}
	/*
	 * verifyDoubleClickOperation
	 */
	@Test(priority = 24)
	public void verifyDoubleClickOperation() throws Exception {
		tlObj.performDoubleClick();
	}
		
}
