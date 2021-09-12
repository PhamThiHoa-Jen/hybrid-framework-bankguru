package pageObjects.jquery;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	private static HomePageObject homePage;
	
	private PageGeneratorManager() {
		
	}
	
	public static HomePageObject getHomePage(WebDriver driver) {
		if(homePage == null) {
			return new HomePageObject(driver);
		}
		return homePage;
	}
	
}
