package com.google.tests;

import com.google.pages.HomePage;
import com.google.pages.LoginPage;
import com.google.testdata.TestUser;
import com.google.testdata.Urls;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;

/**
 * Created by abryhas on 14.03.2016.
 */
public class LoginTest {

    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
    private LoginPage.PasswordWindow passwordWindow;

    @BeforeTest
    public void init() {
        File file = new File("C:/Selenium/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        driver = new ChromeDriver();
        driver.get(Urls.GOOGLE_HOME.toString());
        driver.manage().window().maximize();
    }

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
        homePage = new HomePage(driver);
        loginPage = homePage.clickLoginBtn();
        passwordWindow = loginPage.setEmail(email);
        homePage = passwordWindow.signIn(password);
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

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}
