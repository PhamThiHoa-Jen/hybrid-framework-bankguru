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

public class Level_07_Register_Login_Switch_Page extends BaseTest{
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
		searchPage = homePage.openSearchPage(driver);
		//search page -> my account page
		myAccountPage = searchPage.openMyAccountPage(driver);
		//my account page -> order page
		oderPage = myAccountPage.openOrderPage(driver);
		//order page -> my account page
		myAccountPage = oderPage.openMyAccountPage(driver);
		//order page -> search page
		searchPage = myAccountPage.openSearchPage(driver);
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
	OrderPageObject oderPage;
}
