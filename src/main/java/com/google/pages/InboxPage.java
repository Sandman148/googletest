package com.google.pages;

import com.google.utils.Constants;
import com.google.utils.Timeouts;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by abryhas on 16.03.2016.
 */
public class InboxPage extends CommonPage {

    @FindBy(xpath = "//div[contains(text(), 'COMPOSE')]")
    private WebElement composeBtn;

    @FindBy(xpath = "//a[contains(text(), 'Inbox')]")
    private WebElement inboxLnk;

    @FindBy(css = ".T-I.J-J5-Ji.nX")
    private WebElement deleteBtn;

    @FindBy(css = ".zF")
    private List<WebElement> unreadEmailSenders;

    @FindBy(css = ".oZ-jc.T-Jo.J-J5-Ji")
    private List<WebElement> emailCheckboxes;

    public class NewMessageBlock extends CommonPage {

        @FindBy(className = "vO")
        private WebElement recipientsInp;

        @FindBy(className = "aoT")
        private WebElement subjectInp;

        @FindBy(xpath = "//div[@aria-label='Message Body']")
        private WebElement textInp;

        @FindBy(css = ".T-I.J-J5-Ji.aoO.T-I-atl.L3")
        private WebElement sendBtn;

        public NewMessageBlock(WebDriver driver) {
            super(driver);
        }

        public InboxPage sendEmail(String recipient, String subject, String text) {
            setTextToInputField(recipientsInp, recipient);
            Actions act = new Actions(driver);
            act.sendKeys(Keys.ENTER).build().perform();
            setTextToInputField(subjectInp, subject);
            setTextToInputField(textInp, text);
            sendBtn.click();
            return new InboxPage(driver);
        }
    }

    public InboxPage(WebDriver driver) {
        super(driver);
        waitForElementVisibility(composeBtn);
    }

    public NewMessageBlock clickComposeBtn() {
        composeBtn.click();
        return new NewMessageBlock(driver);
    }

    public InboxPage clickInboxLnk() {
        inboxLnk.click();
        fixedWait(Timeouts.SHORT_MILLIS.getField());
        return new InboxPage(driver);
    }

    /**
     * @return first unread email sender name
     */
    public String getFirstUnreadEmailSenderName() {
        waitForElementVisibility(unreadEmailSenders.get(Constants.FIRST_UNREAD_EMAIL.getField()));
        return unreadEmailSenders.get(Constants.FIRST_UNREAD_EMAIL.getField()).getText();
    }

    public WebElement getFirstUnreadEmailSenderElement() {
        try {
            waitForElementVisibility(unreadEmailSenders.get(Constants.FIRST_UNREAD_EMAIL.getField()));
            return unreadEmailSenders.get(Constants.FIRST_UNREAD_EMAIL.getField());
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public void deleteFirstEmail() {
        waitForElementVisibility(emailCheckboxes.get(0));
        selectCheckbox(emailCheckboxes.get(0));
        waitForElementVisibility(deleteBtn);
        deleteBtn.click();
        fixedWait(Timeouts.SHORT_MILLIS.getField());
    }

}
