package com.javatpoint.seleniumjavatpoint;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MiscellaneousTest extends BaseTest{

    @Test(description = "open url: 2 methods"
            ,enabled = true
            ,groups = {"miscellaneous", "all"}
            ,priority = 5)
    public void testUrl() throws InterruptedException {
        driver.get("https://yandex.ru");
        Assert.assertTrue(driver.getTitle().equals("Яндекс"), "mismatch in Yandex title");

        driver.navigate().to("https://javatpoint.com/selenium-tutorial");
        Assert.assertEquals(driver.getTitle(), "Selenium Tutorial - javatpoint", "mismatch in javatpointtitle");
    }

    @Test(description="clear input. using driver.findElement",
            enabled=true,
            groups = {"miscellaneous", "all"},
            priority=5)
    public void testClearInputByDriver(){

        driver.get("https://yandex.ru");
        Assert.assertEquals(driver.getTitle(), "Яндекс", "mismatch in a title");

        String yandexSearchBox = ".input__control.input__input[id='text']"; //cssSelector
        String searchText = "The clear() method is used to clear the user inputs from the text box."; //cssSelector

        driver.findElement(By.cssSelector(yandexSearchBox)).sendKeys(searchText);
        driver.findElement(By.cssSelector(yandexSearchBox)).clear();

        Assert.assertEquals(driver.getTitle(), "Яндекс", "mismatch in a title");
    }


    @Test(description="clear input. using By. navigate to Gmail",
            enabled=true,
            groups = {"miscellaneous", "all"},
            priority=5)
    public void testGoogleInputByBy() throws InterruptedException {
        driver.get("https://google.com/");
        Assert.assertEquals(driver.getTitle(), "Google", "mismatch in a title");

        String searchText = "The clear() method is used to clear the user inputs from the text box.";
        Assert.assertEquals(miscellaneous.googleInputByBy(searchText),
                "Gmail - Free Storage and Email from Google","mismatch with data in search box");
    }


    @Test(description="navigating Backward In Browser History",
            enabled=true,
            groups = {"miscellaneous", "all"},
            dependsOnGroups={},
            dependsOnMethods={},
            priority=5)
    public void testNavigatingBackwardInBrowserHistory(){
        String expected = "Gmail - Free Storage and Email from Google | Google | Gmail - Free Storage and Email from Google";
        Assert.assertEquals(miscellaneous.navigatingBackwardForwardInBrowserHistory(), expected,
                "mismatch in pages titles");
    }


    @Test(description="refreshReloadAWebPage",
            enabled=true,
            groups = {"miscellaneous", "all"},
            dependsOnGroups={},
            dependsOnMethods={},
            priority=5)
    public void testRefreshReloadAWebPage(){
        String expected = "Google | Google";
        Assert.assertEquals(miscellaneous.refreshReloadAWebPage(),expected,"mismatch in page title");
    }


    @Test(description="practiceSwitchWindow",
            enabled=true,
            groups = {"miscellaneous", "all"},
            dependsOnGroups={},
            dependsOnMethods={},
            priority=6
    )
    public void testPracticeSwitchWindow(){
        Assert.assertEquals(miscellaneous.practiceSwitchWindow(),2,"mismatch in number of windows");
    }


    @Test(description="drag and drop",
        enabled=true,
        groups={"regression", "drag&drop", "all"},
        dependsOnGroups={},
        dependsOnMethods={},
        priority=5)
    public void testDragAndDrop(){
        Assert.assertEquals(miscellaneous.dragAndDrop(),null,"drag and drop: target is empty");
    }


    @Test(description="radio btn",
        enabled=true,
        groups={"all","radiobtn"},
        dependsOnGroups={},
        dependsOnMethods={},
        priority=5)
    public void testRadioBtnMale(){
        Map<String, Boolean> expected = new LinkedHashMap<>();
        expected.put("male", true);
        expected.put("female", false);
        Assert.assertEquals(miscellaneous.radioBtnMale(),expected,"radio btn male not clicked");
    }


    @Test(description = "checkbox",
        enabled=true,
        groups={"all", "checkbox"},
        dependsOnGroups={},
        dependsOnMethods={},
        priority=5)
    public void testCheckBox(){
        Map<String, Boolean> expected = new HashMap<>();
        expected.put("Automation Testing", true);
        expected.put("Performance Testing", false);
        Assert.assertEquals(miscellaneous.checkBox(true, false),expected, "mismatch in checkbox status");
    }


    @Test(description="Use Select class for selecting value from dropdown",
        enabled=true,
        groups={"all","dropdown"},
        dependsOnGroups={},
        dependsOnMethods={},
        priority=5
    )
    public void testDropdown(){
        String url = "https://www.testandquiz.com/selenium/testing.html";
        String elementSelect = "Database Testing";
        Assert.assertEquals(miscellaneous.dropdown(url, elementSelect), elementSelect, "mismatch in selected element");
    }


    @Test(description="get current url",
    enabled=true,
    groups={"all"},
    dependsOnGroups={},
    dependsOnMethods={},
    priority=5)
    public void testGetCurrentUrl(){
        String url = "https://www.testandquiz.com/selenium/testing.html";
        Assert.assertEquals(miscellaneous.getCurrentUrl(url),url,"mismatch in current url");
    }

    @Test(description = "get page source",
        enabled=true,
        groups={"all"},
        dependsOnGroups={},
        dependsOnMethods={},
        priority=5)
    public void testGetPageSource() {
        String url = "https://www.testandquiz.com/selenium/testing.html";
        String expected = "<title>Sample Test Page</title>";
        Assert.assertTrue(miscellaneous.getPageSource(url).contains(expected), "mismatch in source code");
    }


    @Test(description="navigate to",
        enabled=true,
        groups={"all", "bat", "regression"},
        dependsOnGroups={},
        dependsOnMethods={},
        priority=5)
    public void testNavigate(){
        String url = "https://www.javatpoint.com";
        String expected = "Tutorials List - Javatpoint";
        Assert.assertEquals(miscellaneous.navigate(url),expected, "mismatch in a title");
    }





}
