package com.google.tests;

import com.google.pages.GoogleMapsPage;
import com.google.testdata.TestUser;
import com.google.testdata.Urls;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;

/**
 * Created by abryhas on 05/04/2016.
 */
public class GmapsTests extends TestBase {

    private WebDriver driver;
    private GoogleMapsPage googleMapsPage;

    @Test
    @Parameters({"userNumber"})
    @Features({"Gmaps tests"})
    public void verifySearch(int userNumber) {
        TestUser user = new TestUser();
        signIn(user.getEmail(userNumber), user.getPassword(userNumber), user.getFirstName(userNumber));
        driver = getDriver();
        driver.get(Urls.GOOGLE_MAPS.toString());
        googleMapsPage = new GoogleMapsPage(driver);
        Assert.assertTrue(googleMapsPage.performSearch("Symphony Solutions").getSearchResultTitle(0).contains("Symphony Solutions"),
                "Test result and searched text don't match.");
    }

    @Test
    @Features({"Gmaps tests"})
    public void verifySearchWithoutLogin() {
        driver = getDriver();
        driver.get(Urls.GOOGLE_MAPS.toString());
        googleMapsPage = new GoogleMapsPage(driver);
        Assert.assertTrue(googleMapsPage.performSearch("Symphony Solutions").getSearchResultTitle(0).contains("Symphony Solutions"),
                "Test result and searched text don't match.");
    }
}
