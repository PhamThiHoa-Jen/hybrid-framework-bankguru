package com.jquery.datatable;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import pageObjects.jquery.HomePageObject;
import pageObjects.jquery.PageGeneratorManager;

public class Level_09_Datatable extends BaseTest{
	WebDriver driver;
	HomePageObject homePage;

	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorManager.getHomePage(driver);
	}
	

	public void Table_01_Paging() {
		homePage.openPageByNumber("15");
		Assert.assertTrue(homePage.isPageActiveByNumber("15"));
		
		homePage.openPageByNumber("1");
		Assert.assertTrue(homePage.isPageActiveByNumber("1"));
		
		homePage.openPageByNumber("10");
		Assert.assertTrue(homePage.isPageActiveByNumber("10"));
	}


	public void Table_02_Input_Header_Textbox() {
		homePage.inputToHeaderTextboxByName("Females","24128");
		homePage.sleepInsecond(3);
		homePage.refreshCurrentPage(driver);
		
		homePage.inputToHeaderTextboxByName("Country","Antigua and Barbuda");
		homePage.sleepInsecond(3);
		homePage.refreshCurrentPage(driver);
		
		homePage.inputToHeaderTextboxByName("Males","16456");
		homePage.sleepInsecond(3);
		homePage.refreshCurrentPage(driver);
	}
	

	public void Table_03_Action_Edit_Remove() {
		homePage.clickToIconByCountryName("Algeria","remove");
		homePage.sleepInsecond(3);
		
		homePage.clickToIconByCountryName("Afghanistan","remove");
		homePage.sleepInsecond(3);
		
		homePage.clickToIconByCountryName("Antigua and Barbuda","edit");
		homePage.sleepInsecond(3);
		homePage.refreshCurrentPage(driver);
		
		homePage.clickToIconByCountryName("Aruba","edit");
		homePage.sleepInsecond(3);
	}
	
	public void Table_04_Verify_Data() {
		homePage.inputToHeaderTextboxByName("Country","Afghanistan");
		Assert.assertTrue(homePage.isRowValueDisplayed("384187","Afghanistan","407124","791312"));
		homePage.sleepInsecond(3);
		
		homePage.inputToHeaderTextboxByName("Country","Albania");
		Assert.assertTrue(homePage.isRowValueDisplayed("24128","Albania","25266","49397"));
		homePage.sleepInsecond(3);
		
		homePage.openPageByNumber("2");
		homePage.inputToHeaderTextboxByName("Country","Australia");
		Assert.assertTrue(homePage.isRowValueDisplayed("145412","Australia","154696","300109"));
		Assert.assertTrue(homePage.isRowValueDisplayed("175157","Australia/New Zealand","186032","361190"));
		homePage.sleepInsecond(3);
	}

	public void Table_05_Input_Row_Textbox() {
		homePage.inputToTextboxByRowNumber("Contact Person","3", "Auto test");
		homePage.sleepInsecond(3);
		
		homePage.inputToTextboxByRowNumber("Order Placed","2", "5");
		homePage.sleepInsecond(3);
	}
	
	@Test
	public void Table_06_Click_Icon_At_Row() {
		homePage.clickToIconByRowNumber("2","Move Up");
		homePage.sleepInsecond(3);
		
		homePage.clickToIconByRowNumber("3","Remove Current Row");
		homePage.sleepInsecond(3);
	}
	
	@AfterClass
	public void cleanBrowser() {
		driver.quit();
	}

}
