package com.google.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by abryhas on 04/04/2016.
 */
public class WhoresPage extends CommonPage {

    @FindBy(xpath = "//img")
    private WebElement whores;

    public WhoresPage(WebDriver driver) {
        super(driver);
        waitForElementVisibility(whores);
    }

    public String getWhoresSrc() {
        return whores.getAttribute("src");
    }
}
