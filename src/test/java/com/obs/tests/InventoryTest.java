package com.obs.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.obs.pages.InventoryPage;
import com.obs.pages.LoginPage;

public class InventoryTest extends BaseTest{
	
	LoginPage lpage;
	InventoryPage inventoryPageObj;
	
	@Test
	public void inventoryPageTest() throws Exception {
		//login to application
		lpage = new LoginPage(driver);
		lpage.typeUserName("standard_user");
		lpage.typePasword("secret_sauce");
		lpage.clickLogin();
		
		//go to inventory page
		inventoryPageObj = new InventoryPage(driver);
		Assert.assertTrue(lpage.isHamBurgerBtnDisplayed(), "Inventory Page is not displayed");
		
	}
}
