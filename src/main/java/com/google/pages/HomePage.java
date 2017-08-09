package com.google.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by abryhas on 14.03.2016.
 */
public class HomePage extends CommonPage {

    @FindBy(id = "gb_70")
    private WebElement logInBtn;

    @FindBy(linkText = "Gmail")
    private WebElement gmailLnk;

    @FindBy(css = ".gb_tb.gb_ub")
    private WebElement userName;

    @FindBy(css = ".gbii")
    private WebElement profileBtn;

    @FindBy(id = "gb_71")
    private WebElement signOutBtn;

    @FindBy(css = "[title='No thanks']")
    private WebElement noThanksBtn;

    public HomePage(WebDriver driver) {
        super(driver);
        waitForElementVisibility(gmailLnk);
    }

    public LoginPage clickLoginBtn() {
        logInBtn.click();
        return new LoginPage(driver);
    }

    private void clickSignOutBtn() {
        waitForElementVisibility(signOutBtn);
        signOutBtn.click();
    }

    @Step("Click Gmail link")
    public InboxPage clickGmailLnk() {
        gmailLnk.click();
        return new InboxPage(driver);
    }

    public String getUserName() {
        clickProfileBtn();
        waitForElementVisibility(userName);
        String name = userName.getText();
        clickProfileBtn();
        return name;
    }

    public void clickProfileBtn() {
        waitForElementVisibility(profileBtn);

        //for Firefox browser
        if (isElementPresent(noThanksBtn)) {
            noThanksBtn.click();
        }

        profileBtn.click();
    }

    @Step("Sign out")
    public HomePage signOut() {
        clickProfileBtn();
        clickSignOutBtn();
        return this;
    }

    public boolean isUserNamePresent() {
        return isElementPresent(userName);
    }

}
