package com.javatpoint.seleniumjavatpoint;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleSearchTest extends BaseTest{

    @Test(description = "Title of Google main page",
        enabled = true,
        groups = {"bat", "sanity", "regression", "Google"},
        priority = 0)
    public void testGetGoogleMainPageTitle(){
        String expected = "Google";
        Assert.assertEquals(googleSearch.currentPageTitle(), expected,
                "current Page Title doesn't match to Google main page");
    }

    @Test(description = "Navigate to About Page",
        enabled = true,
        groups = {"bat", "regression", "all", "HomePage"},
        dependsOnMethods = "testGetGoogleMainPageTitle",
        dependsOnGroups = {"sanity"},
        priority = 0
    )
    public void testNavigateToAboutPage(){
        String expected = "About | Google";
        googleSearch.navigateToAboutPage();
        Assert.assertEquals(aboutPage.currentPageTitle(), expected,
                "current Page Title doesn't match to About page");
    }

}
