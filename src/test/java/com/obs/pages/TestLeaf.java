package com.obs.pages;


import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.obs.actions.ClickActionHelper;
import com.obs.actions.UtilityActionHelper;
import com.obs.actions.WebActionHelper;


public class TestLeaf{
	
	public TestLeaf(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	WebDriver driver;
	WebActionHelper wahObj = new WebActionHelper();
	UtilityActionHelper uahObj = new UtilityActionHelper();
	ClickActionHelper cahObj = new ClickActionHelper();
	
	@FindBy(xpath = "//a//h5[text()='Alert']")
	WebElement alertTab;
	@FindBy(xpath = "//button[contains(.,'Prompt Box')]")
	WebElement showAlertBtn;
	@FindBy(xpath = "//a/h5[text()='Frame']")
	WebElement frameLink;
	@FindBy(xpath = "//button[@id='Click']")
	WebElement frameBtn;
	@FindBy(xpath = "//h1")
	WebElement framePageHeading;
	@FindBy(xpath = "//a//h5[text()='Window']")
	WebElement windowsTab;
	@FindBy(xpath = "//button[@id='color']")
	WebElement multipleWindowBtn;
	@FindBy(xpath = "//table//tbody/tr")
	List <WebElement> tableRow;
	@FindBy(xpath = "(//table//tbody/tr)[1]/th")
	List <WebElement> tableColumn;
	@FindBy (id = "dropdown1")
	WebElement dropDown;
	@FindBy (xpath = "//div[@id='draggable']")
	WebElement source;
	@FindBy (xpath = "//div[@id='droppable']")
	WebElement target;
	@FindBy (xpath = "//h1[text()='Draggable']")
	WebElement doubleclick;
	
	public void giveNavigationUrl(String url) {
		wahObj.navigateToURL(driver, url);
	}
	
	public String returnSiteTitle() {
		return wahObj.getSiteTitle(driver);
	}
	
	public void navigateBrowserBackward() {
		wahObj.navigateBack(driver);
	}
	
	public void navigateBrowserForward() {
		wahObj.navigateForward(driver);
	}
	public void refreshTheBrowser() {
		wahObj.refreshBrowser(driver);
	}
	
	public String returnSiteURL() {
		return wahObj.getSiteURL(driver);
	}
	
	public String returnSitePageSource() {
		return wahObj.getSitePageSource(driver);
	}
	public void dismissAlertBox() {
		wahObj.dismissAlert(driver);
	}
	
	public void acceptAlertBox() {
		wahObj.acceptAlert(driver);
	}
	
	public void clickOnAlertLink() {
		alertTab.click();
	}
	public void clickShowAlertBtn() {
		showAlertBtn.click();
	}
	public String returnAlertBoxContent() {
		return wahObj.getAlertBoxContent(driver);
	}
	public void clickFrameTab() {
		frameLink.click();
	}
	public void switchToFrame(int index) throws Exception {
		wahObj.switchToFrame(driver, index);
	}
	public String returnFrameButtonText() {
		frameBtn.click();
		return frameBtn.getText();
		
	}
	public void switchToParentFrame() throws Exception {
		wahObj.switchToParentFrame(driver);
	}
	public String returnFramePageHeading() {
		return framePageHeading.getText();
	}
	public int returnTotalFrameCount() throws Exception {
		return wahObj.totalFrameCount(driver);
	}
	public int returnWindowCount() throws Exception {
		return wahObj.countTotalWindows(driver);
	}
	public void closeCurrentWindow() throws Exception {
		wahObj.closeCurrentWindow(driver);
	}
	public void clickWindowsTab() {
		windowsTab.click();
	}
	public void clickMultipleWindowBtn() {
		multipleWindowBtn.click();
	}
	public String switchToNewWindow() throws Exception {
		String parentWindow = wahObj.switchToNewelyOpenedWindowAndReturnParentWindow(driver);
		return parentWindow;
	}
	public void switchToParentWindow(String window) throws Exception {
		wahObj.switchToParentWindow(driver, window);
	}
	public int returnTableRowCount() throws Exception {
		int rowCount = uahObj.getTableRowCount(driver, tableRow);
		return rowCount;
	}
	public int returnTableColumnCount() throws Exception {
		int columnCount = uahObj.getTableColumnCount(driver, tableColumn);
		return columnCount;
	}
	public String returnTableCellContent(int row, int column) throws Exception {
		String xpath = "((//table//tbody/tr)["+row+"]/td)["+column+"]";
		return uahObj.getTableContentOnRowAndColumn(driver, xpath);
	}
	public void selectDropDownByVisibleText(String text) throws Exception {
		uahObj.selectDropDownByVisibleText(dropDown, text);
	}
	public void selectDropDownByIndex(int index) throws Exception {
		uahObj.selectDropDownByIndex(dropDown, index);
	}
	public void selectDropDownByValue(String value) throws Exception {
		uahObj.selectDropDownByValue(dropDown, value);
	}
	public String returnDropDownValue() {
		Select select = new Select(dropDown);
		WebElement option = select.getFirstSelectedOption();
		return option.getText();
	}
	public void takeScreenShot() throws Exception {
		uahObj.capturePageScreenshot(driver);
	}
	public void dragAndDrop() throws Exception {
		uahObj.dragAndDrop(driver, source, target);
	}
	public void dragToXY(int x, int y) throws Exception {
		uahObj.dragToXandY(driver, source, x, y);
	}
	public void performRightClick() throws Exception {
		cahObj.rightClick(driver, source);
	}
	public void performDoubleClick() throws Exception {
		cahObj.doubleClick(driver, doubleclick);
	}
	
}
