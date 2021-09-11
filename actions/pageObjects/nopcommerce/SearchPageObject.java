package pageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;

import common.BasePage;

public class SearchPageObject extends BasePage{

	private WebDriver driver;
	
	public SearchPageObject(WebDriver driver) {
		this.driver = driver;
	}
}
