package com.obs.tests;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.obs.actions.WebActionHelper;
import com.obs.datahandler.PropertyDataHandler;

public class BaseTest {

	public static WebDriver driver;
	PropertyDataHandler prop = new PropertyDataHandler();
	
	@Parameters("browserType")
	@BeforeTest
	public void launch(String browserType) throws IOException {
		WebActionHelper wahObj = new WebActionHelper();
		if(browserType.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "E:\\ArchanaB\\chromedriver_win32_101\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		if(browserType.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "E:\\ArchanaB\\edgedriver_win64_102\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		Properties allProp = prop.readPropertiesFile("config.properties");
		wahObj.launchURL(driver, allProp.getProperty("url"));
	}
	
	@AfterTest
	public void close() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
}
