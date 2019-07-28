package com.javatpoint.seleniumjavatpoint;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleMainPageTest extends BaseTest{

    @BeforeMethod(alwaysRun=true)
    public void beforeMethodGoogleMainPage(){
        //public void navigateToMainPage(){
    }


    @AfterMethod(enabled=true, alwaysRun=true)
    public void quitDriver(){
        //driver.close();
        //driver.quit();
    }


    @Test(description = "Title of Google Main page",
        enabled = true,
        groups = {"bat", "sanity", "regression", "Google"},
        priority = 1)
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
        priority = 1)
    public void testNavigateToGoogleAboutPage(){
        String expected = "About | Google";
        googleMainPage.navigateToMainPage();
        googleMainPage.navigateToAboutPage();
        Assert.assertEquals(googleAboutPage.currentPageTitle(), expected,
                "current Page Title doesn't match to About page");
    }


    @Test(description = "Search text",
            enabled = true,
            groups = {"bat", "search"},
            dependsOnGroups = "sanity",
            dependsOnMethods="testGetGoogleMainPageTitle",
            priority = 0)
    public void testSearchText(){
        String searchText = "javatpoint tutorials";
        String expected = "About";
        googleMainPage.navigateToMainPage();
        Assert.assertTrue(googleMainPage.searchText(searchText).contains(expected),"mismatch ir Search Results");
    }


    @Test(description = "Search text",
            enabled = true,
            groups = {"bat", "search"},
            dependsOnGroups = "sanity",
            dependsOnMethods="testGetGoogleMainPageTitle",
            priority = 0)
    public void testSearchText02(){
        String searchText = "javatpoint selenium";
        String expected = "About";
        googleMainPage.navigateToMainPage();
        Assert.assertTrue(googleMainPage.searchText(searchText).contains(expected),"mismatch ir Search Results");
    }













}
