package com.google.pages;

import com.google.utils.Timeouts;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by abryhas on 14.03.2016.
 */
public class LoginPage extends CommonPage{

    @FindBy(id = "identifierId")
    private WebElement emailInp;

    @FindBy(id = "identifierNext")
    private WebElement nextBtn;

    public LoginPage(WebDriver driver) {
        super(driver);
        waitForElementVisibility(emailInp);
    }

    private void setEmailInp(String email) {
        setTextToInputField(emailInp, email);
    }

    private void clickNextBtn() {
        nextBtn.click();
    }

    public PasswordWindow setEmail(String email) {
        fixedWait(Timeouts.SHORT_MILLIS.getField());
        setEmailInp(email);
        clickNextBtn();
        return new PasswordWindow(driver);
    }

    public class PasswordWindow extends CommonPage {

        @FindBy(css = "[name='password']")
        private WebElement passwordInp;

        @FindBy(id = "passwordNext")
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
            fixedWait(Timeouts.SHORT_MILLIS.getField());
            setPasswordInp(password);
            fixedWait(Timeouts.SHORT_MILLIS.getField());
            clickSignInBtn();
            return new HomePage(driver);
        }

    }
}
