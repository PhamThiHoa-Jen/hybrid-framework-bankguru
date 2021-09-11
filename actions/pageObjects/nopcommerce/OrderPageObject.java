package pageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;

import common.BasePage;

public class OrderPageObject extends BasePage {

	private WebDriver driver;
	
	public OrderPageObject(WebDriver driver) {
		this.driver = driver;
	}

}
