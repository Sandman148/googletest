package com.google.tests;

import com.google.pages.HomePage;
import com.google.pages.InboxPage;
import com.google.testdata.TestUser;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by abryhas on 16.03.2016.
 */
public class GmailTests extends TestBase {

    private HomePage homePage;
    private InboxPage inboxPage;
    private InboxPage.NewMessageBlock newMessageBlock;

    @DataProvider
    public Object[][] userDataProvider() {
        return new Object[][] { {
                TestUser.getEmail(),
                TestUser.getPassword(),
                TestUser.getFirstName()},
        };
    }

    @Test(dataProvider = "userDataProvider")
    public void sendEmailToSelf(String email, String password, String name) {
        homePage = signIn(email, password, name);
        inboxPage = homePage.clickGmailLnk();
        newMessageBlock = inboxPage.clickComposeBtn();
        inboxPage = newMessageBlock.sendEmail("testerbox148@gmail.com", "subj", "text");
        Assert.assertEquals(inboxPage.clickInboxLnk().getFirstUnreadEmailSenderName(), "me", "The e-mail was not sent correctly");
    }

    @Test
    public void deleteFirstEmail() {
        inboxPage.deleteFirstEmail();
        Assert.assertNull(inboxPage.getFirstUnreadEmailSenderElement(), "Unread email still present (should be deleted)");
    }
}
