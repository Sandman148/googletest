package com.google.pages;

import com.google.utils.Timeouts;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

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
    private List<WebElement> multipleSearchResultTitles;

    @FindBy(xpath = "//h1")
    private WebElement singleSearchResultTitle;

    @FindBy(css = ".widget-pane-section-listbox")
    private WebElement searhResultBox;

    public GoogleMapsPage(WebDriver driver) {
        super(driver);
        waitForElementVisibility(searchBox);
    }

    @Step("Perform search")
    public GoogleMapsPage performSearch(String searchText) {
        waitForElementVisibility(searchInp);
        setTextToInputField(searchInp, searchText);
        fixedWait(Timeouts.LONG_MILLIS.getField());
        searchBtn.click();
        return this;
    }

    @Step("Get search result")
    public String getSearchResultTitle(int titleNumber) {
        //for the case when search returns multiple results
        waitForElementVisibility(searhResultBox);
        return multipleSearchResultTitles.get(titleNumber).getText();
    }

}
