package com.google.pages;

import com.google.utils.Timeouts;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

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

    @Step("Get page title")
    public String getTitle() {
        fixedWait(Timeouts.BLACKJACK_TIMEOUT.getField()); //for you to enjoy!
        return title.getText();
    }
}
