package com.javatpoint.seleniumjavatpoint;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleMainPageTest extends BaseTest{

    @Test(description = "Title of Google Main page",
        enabled = true,
        groups = {"bat", "sanity", "regression", "Google"},
        priority = 0)
    public void testGetGoogleMainPageTitle(){
        String expected = "Google";
        Assert.assertEquals(googleMainPage.currentPageTitle(), expected,
                "current Page Title doesn't match to Google main page");
    }

    @Test(description = "Navigate to Google About Page",
        enabled = true,
        groups = {"bat", "regression", "all", "HomePage"},
        dependsOnMethods = "testGetGoogleMainPageTitle",
        dependsOnGroups = {"sanity"},
        priority = 0
    )
    public void testNavigateToGoogleAboutPage(){
        String expected = "About | Google";
        googleMainPage.navigateToAboutPage();
        Assert.assertEquals(googleAboutPage.currentPageTitle(), expected,
                "current Page Title doesn't match to About page");
    }

}
