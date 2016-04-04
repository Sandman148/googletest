package com.google.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by abryhas on 04/04/2016.
 */
public class BlackJackPage extends CommonPage {

    @FindBy(id = "eow-title")
    private WebElement title;

    public BlackJackPage(WebDriver driver) {
        super(driver);
        waitForElementVisibility(title);
    }

    public String getTitle() {
        return title.getText();
    }
}
