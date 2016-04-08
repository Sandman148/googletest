package com.google.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by abryhas on 05/04/2016.
 */
public class GoogleMapsPage extends CommonPage {

    @FindBy(id = "searchbox")
    private WebElement searchBox;

    @FindBy(css = ".searchbox-hamburger")
    private WebElement menuBtn;

    @FindBy(id = "searchboxinput")
    private WebElement searchInp;

    @FindBy(css = ".searchbox-searchbutton")
    private WebElement searchBtn;

    @FindBy(xpath = "//h3[@class='widget-pane-section-result-title']/span")
    private List<WebElement> searchResultTitles;

    @FindBy(css = ".widget-pane-section-listbox")
    private WebElement searhResultBox;

    public GoogleMapsPage(WebDriver driver) {
        super(driver);
        waitForElementVisibility(searchBox);
    }

    public GoogleMapsPage performSearch(String searchText) {
        waitForElementVisibility(searchInp);
        setTextToInputField(searchInp, searchText);
        driverWait(10);
        searchBtn.click();
        waitForElementVisibility(searhResultBox);
        return this;
    }

    public String getSearchResultTitle(int titleNumber) {
        return searchResultTitles.get(titleNumber).getText();
    }


}
