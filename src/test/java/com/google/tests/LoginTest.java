package com.google.tests;

import com.google.pages.HomePage;
import com.google.testdata.TestUser;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by abryhas on 14.03.2016.
 */
public class LoginTest extends TestBase {

    private HomePage homePage;

    @DataProvider
    public Object[][] userDataProvider() {
        return new Object[][] { {
                TestUser.getEmail(),
                TestUser.getPassword(),
                TestUser.getFirstName()},
        };
    }

    @Test(dataProvider = "userDataProvider")
    public void loginToSystemTest(String email, String password, String name) {
        homePage = signIn(email, password, name);
        Assert.assertEquals(homePage.getUserName(), name, "Names don't match.");
    }

    /**
     * To be performed only after loginToSystemTest()
     */
    @Test
    public void signOutTest() {
        homePage.signOut();
        Assert.assertFalse(homePage.isUserNamePresent(), "User name is present (should be absent).");
    }

}
