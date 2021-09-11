package pageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	private static HomePageObject homePage;
	private static LoginPageObject loginPage;
	private static RegisterPageObject registerPage;
	private static SearchPageObject searchPage;
	private static MyAccountPageObject myAccountPage;
	private static OrderPageObject orderPage;
	
	private PageGeneratorManager() {
		
	}
	
	public static HomePageObject getHomePage(WebDriver driver) {
		if(homePage == null) {
			return new HomePageObject(driver);
		}
		return homePage;
	}
	
	public static LoginPageObject getLoginPage(WebDriver driver) {
		if(loginPage == null) {
			return new LoginPageObject(driver);
		}
		return loginPage;
	}
	
	public static RegisterPageObject getRegisterPage(WebDriver driver) {
		if(registerPage == null) {
			return new RegisterPageObject(driver);
		}
		return registerPage;
	}

	public static SearchPageObject getSearchPage(WebDriver driver) {
		if(searchPage == null) {
			return new SearchPageObject(driver);
		}
		return searchPage;
	}

	public static MyAccountPageObject getMyAccountPage(WebDriver driver) {
		if(myAccountPage == null) {
			return new MyAccountPageObject(driver);
		}
		return myAccountPage;
	}

	public static OrderPageObject getOrderPage(WebDriver driver) {
		if(orderPage == null) {
			return new OrderPageObject(driver);
		}
		return orderPage;
	}
}
