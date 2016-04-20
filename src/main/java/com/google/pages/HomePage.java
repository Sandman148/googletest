package com.google.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by abryhas on 14.03.2016.
 */
public class HomePage extends CommonPage {

    @FindBy(id = "gb_70")
    private WebElement logInBtn;

    @FindBy(linkText = "Gmail")
    private WebElement gmailLnk;

    @FindBy(css = ".gb_P.gb_R")
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

    public InboxPage clickGmailLnk() {
        gmailLnk.click();
        return new InboxPage(driver);
    }

    public String getUserName() {
        return userName.getText();
    }

    public void clickProfileBtn() {
        waitForElementVisibility(profileBtn);

        //for Firefox browser
        if (isElementPresent(noThanksBtn)) {
            noThanksBtn.click();
        }

        profileBtn.click();
    }

    public HomePage signOut() {
        clickProfileBtn();
        clickSignOutBtn();
        return this;
    }

    public boolean isUserNamePresent() {
        return isElementPresent(userName);
    }

}
