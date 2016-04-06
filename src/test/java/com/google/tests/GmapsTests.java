package com.google.tests;

import com.google.pages.GoogleMapsPage;
import com.google.testdata.Urls;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by abryhas on 05/04/2016.
 */
public class GmapsTests extends TestBase {

    private WebDriver driver;
    private GoogleMapsPage googleMapsPage;

    @Test(dataProvider = "userDataProvider")
    public void verifySearch(String  email, String password, String name) {
        signIn(email, password, name);
        driver = getDriver();
        driver.get(Urls.GOOGLE_MAPS.toString());
        googleMapsPage = new GoogleMapsPage(driver);
        Assert.assertTrue(googleMapsPage.performSearch("softserve").getSearchResultTitle(0).contains("SoftServe"),
                "Test result and searched text don't match.");
    }
}
