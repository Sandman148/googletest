package com.google.pages;

import com.google.utils.Timeouts;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

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

    @Step("Get whores source")
    public String getWhoresSrc() {
        fixedWait(Timeouts.LONG_MILLIS.getField()); //for you to enjoy!
        return whores.getAttribute("src");
    }
}
