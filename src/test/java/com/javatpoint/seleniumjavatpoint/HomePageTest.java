package com.javatpoint.seleniumjavatpoint;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest{


    @Test(description = "Navigate to Home Page",
        enabled = true,
        groups = {"bat", "HomePage", "regression"},
        dependsOnGroups = {},
        priority = 0)
    public void testNavigateToHomePage(){
        String expected = "javatpoint";
        homePage.navigateToHomePage();
        Assert.assertEquals(homePage.currentPageTitle(), expected, "Mismatck in the page title");
    }

    @Test(description = "search in Google",
            enabled = true,
            groups = {"bat", "regression"},
            priority = 0
        )
    public void testSearchInGoogle(){

    }


}
