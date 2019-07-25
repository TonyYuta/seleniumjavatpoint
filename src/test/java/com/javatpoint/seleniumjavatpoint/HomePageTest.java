package com.javatpoint.seleniumjavatpoint;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest{


    @Test(description = "Navigate to Home Page",
        enabled = false,
        groups = {"bat", "HomePage", "regression", "all"},
        dependsOnGroups = {},
        priority = 0)
    public void testNavigateToHomePage(){
        String expected = "javatpoint";
        homePage.navigateToHomePage();
        Assert.assertEquals(homePage.currentPageTitle(), expected, "Mismatck in the page title");
    }

    @Test(description = "search in Google",
            enabled = false,
            groups = {"bat", "regression", "all"},
            priority = 0
        )
    public void testSearchInGoogle(){

    }




}
