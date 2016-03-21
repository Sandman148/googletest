package com.google.tests;

import com.google.pages.HomePage;
import com.google.pages.LoginPage;
import com.google.testdata.Urls;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;

/**
 * Created by abryhas on 16.03.2016.
 * Test base to initialize web driver
 */
public class TestBase {

    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
    private LoginPage.PasswordWindow passwordWindow;

    @BeforeTest(alwaysRun = true)
    public void initTest() {
        File file = new File("C:/Selenium/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        driver = new ChromeDriver();
        driver.get(Urls.GOOGLE_HOME.toString());
        driver.manage().window().maximize();
    }

    @AfterTest(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }

    protected WebDriver getDriver() {
        return this.driver;
    }

    public HomePage signIn(String email, String password, String name) {
        homePage = new HomePage(driver);
        loginPage = homePage.clickLoginBtn();
        passwordWindow = loginPage.setEmail(email);
        homePage = passwordWindow.signIn(password);
        return homePage;
    }

}
