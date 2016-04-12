package com.google.pages;

import com.google.utils.Timeouts;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by abryhas on 14.03.2016.
 */
public class LoginPage extends CommonPage{

    @FindBy(id = "Email")
    private WebElement emailInp;

    @FindBy(id = "next")
    private WebElement nextBtn;

    public LoginPage(WebDriver driver) {
        super(driver);
        waitForElementVisibility(emailInp);
    }

    private void setEmailInp(String email) {
        emailInp.click();
        emailInp.clear();
        emailInp.sendKeys(email);
    }

    private void clickNextBtn() {
        nextBtn.click();
    }

    public PasswordWindow setEmail(String email) {
        setEmailInp(email);
        fixedWait(Timeouts.SHORT_MILLIS.getField());
        clickNextBtn();
        return new PasswordWindow(driver);
    }

    public class PasswordWindow extends CommonPage {

        @FindBy(id = "Passwd")
        private WebElement passwordInp;

        @FindBy(id = "signIn")
        private WebElement signInBtn;

        public PasswordWindow(WebDriver driver) {
            super(driver);
            waitForElementVisibility(passwordInp);
        }

        private void setPasswordInp(String password) {
            passwordInp.click();
            passwordInp.clear();
            passwordInp.sendKeys(password);
        }

        private void clickSignInBtn() {
            signInBtn.click();
        }

        public HomePage signIn(String password) {
            setPasswordInp(password);
            fixedWait(Timeouts.SHORT_MILLIS.getField());
            clickSignInBtn();
            return new HomePage(driver);
        }

    }
}
