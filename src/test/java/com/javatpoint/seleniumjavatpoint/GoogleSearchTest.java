package com.javatpoint.seleniumjavatpoint;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleSearchTest extends BaseTest{

    @Test(description = "Navigate to About Page",
        enabled = true,
        dependsOnGroups = {},
        groups = {"bat", "regression", "all", "HomePage"},
        priority = 0
    )
    public void testNavigateToAboutPage(){
        String expected = "About page";
        googleSearch.navigateToAboutPage();
        Assert.assertEquals(aboutPage.currentPageTitle(), expected, "current Page Title doesn't match to About page");
    }

}
