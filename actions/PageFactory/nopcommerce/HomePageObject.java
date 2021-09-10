package PageFactory.nopcommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.BasePageFactory;


public class HomePageObject extends BasePageFactory {
	WebDriver driver;
	
	@FindBy(id="nivo-slider")
	WebElement homePageSlider;
	
	@FindBy(className="ico-register")
	WebElement registerLink;
	
	@FindBy(className="ico-login")
	WebElement loginLink;
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean isHomePageSliderDisplay() {
		waitForElementVisible(driver,homePageSlider);
		return isElementDisplay(driver, homePageSlider);
	}

	public void clickToRegisterLink() {
		waitForElementClickable(driver, registerLink);
		clickToElement(driver, registerLink);
	}

	public void clickToLoginLink() {
		waitForElementClickable(driver, loginLink);
		clickToElement(driver, loginLink);
	}

}
