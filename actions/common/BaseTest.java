package common;

import java.io.File;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	private WebDriver driver;
	private String ProjectLocation = System.getProperty("user.dir");
	
	private enum BROWSER {
		CHROME, FIREFOX, IE, SAFARI, EDGE_LEGACY, EDGE_CHROMIUM, OPERA;
	}
	
	protected WebDriver getBrowserDriver(String browserName) {
		BROWSER browser =  BROWSER.valueOf(browserName.toUpperCase());
		if(browser==BROWSER.FIREFOX) {
		System.setProperty("webdriver.gecko.driver", ProjectLocation + getDirectorySlash("browserDrivers") + "geckodriver");
		driver = new FirefoxDriver();
		} else if(browser==BROWSER.CHROME) {
			System.setProperty("webdriver.chrome.driver", ProjectLocation + getDirectorySlash("browserDrivers") + "chromedriver");
			driver = new ChromeDriver();
		} else if(browser==BROWSER.EDGE_CHROMIUM) {
			System.setProperty("webdriver.edge.driver", ProjectLocation + getDirectorySlash("browserDrivers") + "msedgedriver");
			driver = new EdgeDriver();
		} else {
			throw new RuntimeException("Please enter correct browser name!");
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(GlobalConstants.DEV_APP_URL);
		return driver;
	}
	
	protected WebDriver getBrowserDriver(String browserName, String appUrl) {
		BROWSER browser =  BROWSER.valueOf(browserName.toUpperCase());
		if(browser==BROWSER.FIREFOX) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if(browser==BROWSER.CHROME) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if(browser==BROWSER.EDGE_CHROMIUM) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			throw new RuntimeException("Please enter correct browser name!");
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(appUrl);
		return driver;
	}
	
	public static String getDirectorySlash(String folderName) {
		String separator = File.separator;
		return separator + folderName + separator;
	}
	
	public String getEmailRandom() {
		Random rand = new Random();
		return "testing" + rand.nextInt(999999) + "@live.com";

	}
}
