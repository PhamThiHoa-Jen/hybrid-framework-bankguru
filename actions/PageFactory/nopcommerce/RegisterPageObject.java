package PageFactory.nopcommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.BasePageFactory;

public class RegisterPageObject extends BasePageFactory {
	WebDriver driver;
	
	
	@FindBy(id="gender-male")
	WebElement genderRadioButton;
	
	@FindBy(id="FirstName")
	WebElement firstNametextbox;	
	
	@FindBy(id="LastName")
	WebElement lastNametextbox;
	
	@FindBy(id="Email")
	WebElement emailTextbox;
	
	@FindBy(id="Password")
	WebElement passwordTextbox;
	
	@FindBy(id="ConfirmPassword")
	WebElement confirmPasswordTextbox;
	
	@FindBy(id="register-button")
	WebElement registerButton;
	
	@FindBy(xpath="//div[@class='result' and text()='Your registration completed']")
	WebElement successMessage;
	
	@FindBy(className="ico-logout")
	WebElement logoutLink;
	
	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickToGenderRadioButton() {
		waitForElementClickable(driver, genderRadioButton);
		clickToElement(driver, genderRadioButton);
	}

	public void inputToFirstnameTextbox(String firstname) {
		waitForElementVisible(driver, firstNametextbox);
		senkeyToElement(driver, firstNametextbox, firstname);		
	}

	public void inputToLastnameTextbox(String lastname) {
		waitForElementVisible(driver, lastNametextbox);
		senkeyToElement(driver, lastNametextbox, lastname);
	}

	public void inputToEmailTextbox(String emailAddress) {
		waitForElementVisible(driver, emailTextbox);
		senkeyToElement(driver, emailTextbox, emailAddress);
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, passwordTextbox);
		senkeyToElement(driver, passwordTextbox, password);
	}

	public void inputToConfirmPasswordTextbox(String confirmPassword) {
		waitForElementVisible(driver, confirmPasswordTextbox);
		senkeyToElement(driver, confirmPasswordTextbox, confirmPassword);
	}

	public void clickToRegisterButton() {
		waitForElementClickable(driver, registerButton);
		clickToElement(driver, registerButton);
	}

	public boolean isSuccessMessageDisplay() {
		waitForElementVisible(driver, successMessage);
		return isElementDisplay(driver, successMessage);
	}

	public void clickToLogoutLink() {
		waitForElementClickable(driver, logoutLink);
		clickToElement(driver, logoutLink);
	}

}
