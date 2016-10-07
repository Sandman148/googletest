package com.google.tests;

import com.google.pages.HomePage;
import com.google.testdata.TestUser;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;

/**
 * Created by abryhas on 14.03.2016.
 */
public class LoginTests extends TestBase {

    private HomePage homePage;

    @Test
    @Parameters({"userNumber"})
    @Features({"Login tests"})
    public void loginToSystemTest(int userNumber) {
        TestUser user = new TestUser();
        homePage = signIn(user.getEmail(userNumber), user.getPassword(userNumber), user.getFirstName(userNumber));
        Assert.assertTrue(homePage.getUserName().contains(user.getFirstName(userNumber)), "Names don't match.");
    }

    /**
     * To be performed only after loginToSystemTest()
     */
    @Test
    @Features({"Login tests"})
    public void signOutTest() {
        homePage.signOut();
        Assert.assertFalse(homePage.isUserNamePresent(), "User name is present (should be absent).");
    }

}
