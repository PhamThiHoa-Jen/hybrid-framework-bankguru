package com.liveguru.login;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.liveguru.HomePageObject;
import pageObjects.liveguru.LoginPageObject;
import pageObjects.liveguru.MyDashboardPageObject;



public class Level_03_Register_Login_PageObject {
	WebDriver driver;
	String ProjectLocation = System.getProperty("user.dir");

	@BeforeClass
	public void initBrowser() {
		System.setProperty("webdriver.gecko.driver", ProjectLocation + "/browserDrivers/geckodriver");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Test
	public void Login_01_Empty_Email_And_Password() {
		driver.get("http://live.demoguru99.com/");
		homePage = new HomePageObject(driver);
		homePage.clickToMyAccountFooterLink();
		
		loginPage = new LoginPageObject(driver);
		loginPage.loginToSystem("","");
		
		Assert.assertEquals(loginPage.getEmptyEmailErrorMessage(), "This is a required field.");
		Assert.assertEquals(loginPage.getEmptyPasswordErrorMessage(), "This is a required field.");
	}

	@Test
	public void Login_02_Invalid_Email() {
		loginPage.refreshCurrentPage(driver);
		loginPage.loginToSystem("123@456.789","123456");
		
		Assert.assertEquals(loginPage.getInvalidEmailErrorMessage(), "Please enter a valid email address. For example johndoe@domain.com.");
	}
	
	@Test(description = "input password less than 6 charaters")
	public void Login_03_Invalid_Password() {
		loginPage.refreshCurrentPage(driver);
		loginPage.loginToSystem("auto@gmail.com","123");
		
		Assert.assertEquals(loginPage.getInvalidPasswordErrorMessage(), "Please enter 6 or more characters without leading or trailing spaces.");
	}
	
	@Test(description = "input email not exist on system")
	public void Login_04_Incorrect_Email() {
		loginPage.refreshCurrentPage(driver);
		loginPage.loginToSystem(getEmailRandom(),"123456");
		
		Assert.assertEquals(loginPage.getIncorrectEmailOrPassword(), "Invalid login or password.");
	}
	
	@Test
	public void Login_05_Incorrect_Password() {
		loginPage.refreshCurrentPage(driver);
		loginPage.loginToSystem("dam@gmail.com","123eds");
		
		Assert.assertEquals(loginPage.getIncorrectEmailOrPassword(), "Invalid login or password.");
	}
	
	@Test
	public void Login_06_Valid_Email_And_Password() {
		loginPage.refreshCurrentPage(driver);
		loginPage.loginToSystem("dam@gmail.com","123123");
		
		myDashboardPage = new MyDashboardPageObject(driver);
		Assert.assertTrue(myDashboardPage.isMyDashboardHeaderDisplay());
	}

	@AfterClass
	public void cleanBrowser() {
		driver.quit();
	}

	public String getEmailRandom() {
		Random rand = new Random();
		return "testing" + rand.nextInt(999999) + "@live.com";
	}
	
	HomePageObject homePage;
	LoginPageObject loginPage;
	MyDashboardPageObject myDashboardPage;
}
