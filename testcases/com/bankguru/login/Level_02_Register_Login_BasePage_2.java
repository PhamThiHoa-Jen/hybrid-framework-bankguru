package com.bankguru.login;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import common.BasePage;

public class Level_02_Register_Login_BasePage_2 {
	WebDriver driver;
	BasePage basePage;
	String ProjectLocation = System.getProperty("user.dir");
	String username, password, loginPageUrl;
		

	@BeforeClass
	public void initBrowser() {
		System.setProperty("webdriver.gecko.driver", ProjectLocation + "/browserDrivers/geckodriver");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://demo.guru99.com/v4/");
		loginPageUrl = driver.getCurrentUrl();
		
		basePage = BasePage.getBasePage();
	}
	
	@Test
	public void Login_01_Register_ToSystem () {
		basePage.clickToElement(driver, "//a[text()='here']");
		basePage.senkeyToElement(driver, "//input[@name='emailid']", getEmailRandom());
		basePage.clickToElement(driver, "//input[@name='btnLogin']");
		username = basePage.getElementText(driver, "//td[text()='User ID :']/following-sibling::td");
		password = basePage.getElementText(driver, "//td[text()='Password :']//following-sibling::td");
	}
	
	@Test
	public void Login_02_Login_ToSystem () {
		basePage.openPageUrl(driver, loginPageUrl);
		basePage.senkeyToElement(driver, "//input[@name='uid']", username);
		basePage.senkeyToElement(driver, "//input[@name='password']", password);
		basePage.clickToElement(driver, "//input[@name='btnLogin']");
		
		Assert.assertEquals(basePage.getElementText(driver, "//marquee[@class='heading3']"), "Welcome To Manager's Page of Guru99 Bank");		
	}
	
	  
	@AfterClass
	public void cleanBrowser() {
		driver.quit();
	}

	public String getEmailRandom() {
		Random rand = new Random();
		return "testing" + rand.nextInt(999999) + "@live.com";
		
	}
	
}
