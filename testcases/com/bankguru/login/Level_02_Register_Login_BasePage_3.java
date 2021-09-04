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

public class Level_02_Register_Login_BasePage_3 extends BasePage{
	WebDriver driver;
	String ProjectLocation = System.getProperty("user.dir");
	String username, password, loginPageUrl;
		

	@BeforeClass
	public void initBrowser() {
		System.setProperty("webdriver.gecko.driver", ProjectLocation + "/browserDrivers/geckodriver");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://demo.guru99.com/v4/");
		loginPageUrl = driver.getCurrentUrl();		
	}
	
	@Test
	public void Login_01_Register_ToSystem () {
		clickToElement(driver, "//a[text()='here']");
		senkeyToElement(driver, "//input[@name='emailid']", getEmailRandom());
		clickToElement(driver, "//input[@name='btnLogin']");
		username = getElementText(driver, "//td[text()='User ID :']/following-sibling::td");
		password = getElementText(driver, "//td[text()='Password :']//following-sibling::td");
	}
	
	@Test
	public void Login_02_Login_ToSystem () {
		openPageUrl(driver, loginPageUrl);
		senkeyToElement(driver, "//input[@name='uid']", username);
		senkeyToElement(driver, "//input[@name='password']", password);
		clickToElement(driver, "//input[@name='btnLogin']");
		
		Assert.assertEquals(getElementText(driver, "//marquee[@class='heading3']"), "Welcome To Manager's Page of Guru99 Bank");		
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
