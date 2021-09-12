package com.nopcommerce.login;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import pageObjects.nopcommerce.HomePageObject;
import pageObjects.nopcommerce.LoginPageObject;
import pageObjects.nopcommerce.MyAccountPageObject;
import pageObjects.nopcommerce.OrderPageObject;
import pageObjects.nopcommerce.PageGeneratorManager;
import pageObjects.nopcommerce.RegisterPageObject;
import pageObjects.nopcommerce.SearchPageObject;

public class Level_08_Register_Login_Dynamic_Locator extends BaseTest{
	WebDriver driver;
	String emailAddress, password;

	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		
		emailAddress = getEmailRandom();
		password = "123456";
	}
	
	@Test
	public void Login_01_Register_ToSystem() {
		homePage = PageGeneratorManager.getHomePage(driver);
		Assert.assertTrue(homePage.isHomePageSliderDisplay());
		registerPage = homePage.clickToRegisterLink();
		
		registerPage.clickToGenderRadioButton();
		registerPage.inputToFirstnameTextbox("auto");
		registerPage.inputToLastnameTextbox("test");
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);
		registerPage.clickToRegisterButton();
		Assert.assertTrue(registerPage.isSuccessMessageDisplay());
		
		homePage = registerPage.clickToLogoutLink();
		Assert.assertTrue(homePage.isHomePageSliderDisplay());
	}

	@Test
	public void Login_02_Login_ToSystem() {
		loginPage = homePage.clickToLoginLink();
		loginPage.inputToEmailTextbox(emailAddress);
		loginPage.inputToPasswordTextbox(password);
		
		homePage = loginPage.clickToLoginButton();
		Assert.assertTrue(homePage.isHomePageSliderDisplay());
	}
	
	@Test
	public void Login_03_Switch_Page_Footer() {
		//home page -> search page
		searchPage = (SearchPageObject) homePage.getPageFooterByName(driver, "Search");
		//search page -> my account page
		myAccountPage = (MyAccountPageObject) searchPage.getPageFooterByName(driver, "My account");
		//my account page -> order page
		orderPage = (OrderPageObject) myAccountPage.getPageFooterByName(driver, "Orders");
		//order page -> my account page
		myAccountPage = (MyAccountPageObject) orderPage.getPageFooterByName(driver, "My account");
		//my account page -> search page
		searchPage = (SearchPageObject) myAccountPage.getPageFooterByName(driver, "Search");
		//search page -> order page
		orderPage = (OrderPageObject) searchPage.getPageFooterByName(driver, "Orders");
	}
	
	@Test
	public void Login_04_Switch_Page_Footer() {
		//order page -> my account page
		orderPage.openPageFooterByName(driver, "My account");
		myAccountPage = PageGeneratorManager.getMyAccountPage(driver);
		//my account page -> search page
		myAccountPage.openPageFooterByName(driver, "Search");
		searchPage = PageGeneratorManager.getSearchPage(driver);
		//search page -> order page
		searchPage.openPageFooterByName(driver, "Orders");
		orderPage = PageGeneratorManager.getOrderPage(driver);
	}

	@AfterClass
	public void cleanBrowser() {
		driver.quit();
	}

	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	SearchPageObject searchPage;
	MyAccountPageObject myAccountPage;
	OrderPageObject orderPage;
}
