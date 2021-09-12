package pageObjects.jquery;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.jquery.HomePageUI;

public class HomePageObject extends BasePage{
	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void openPageByNumber(String pageNumber) {
		waitForElementClickable(driver, HomePageUI.PAGING_BY_NUMBER, pageNumber);
		clickToElement(driver, HomePageUI.PAGING_BY_NUMBER, pageNumber);
	}

	public boolean isPageActiveByNumber(String pageNumber) {
		waitForElementVisible(driver, HomePageUI.PAGING_BY_NUMBER_ACTIVE, pageNumber);
		return isElementDisplay(driver, HomePageUI.PAGING_BY_NUMBER_ACTIVE, pageNumber);
	}

	public void inputToHeaderTextboxByName(String headerName, String searchValue) {
		waitForElementVisible(driver, HomePageUI.INPUT_HEADER_TEXTBOX, headerName);
		senkeyToElement(driver, HomePageUI.INPUT_HEADER_TEXTBOX, searchValue, headerName);
		presskeyToElement(driver, HomePageUI.INPUT_HEADER_TEXTBOX, Keys.ENTER, headerName);
	}

	public void clickToIconByCountryName(String countryName, String iconAction) {
		waitForElementClickable(driver, HomePageUI.ICON_BY_COUNTRY_NAME, countryName, iconAction);
		clickToElement(driver, HomePageUI.ICON_BY_COUNTRY_NAME, countryName, iconAction);
	}

	public boolean isRowValueDisplayed(String femalesValue, String countryValue, String malesValue, String totalValue) {
		waitForElementVisible(driver, HomePageUI.ROW_VALUE, femalesValue, countryValue, malesValue, totalValue);
		return isElementDisplay(driver, HomePageUI.ROW_VALUE, femalesValue, countryValue, malesValue, totalValue);
	}

	public void inputToTextboxByRowNumber(String columnName, String rowIndex, String value) {
		int coloumnIndex = getElementSize(driver, HomePageUI.HEADER_NAME_INDEX, columnName) + 1;
		waitForElementVisible(driver, HomePageUI.TEXTBOX_BY_COLUMN_ROW_INDEX, rowIndex, String.valueOf(coloumnIndex));
		senkeyToElement(driver, HomePageUI.TEXTBOX_BY_COLUMN_ROW_INDEX, value, rowIndex, String.valueOf(coloumnIndex));
	}

	public void clickToIconByRowNumber(String rowIndex, String actionIcon) {
		waitForElementClickable(driver, HomePageUI.ACTION_BUTTON_BY_ROW_INDEX, rowIndex, actionIcon);
		clickToElement(driver, HomePageUI.ACTION_BUTTON_BY_ROW_INDEX, rowIndex, actionIcon);
	}

}
