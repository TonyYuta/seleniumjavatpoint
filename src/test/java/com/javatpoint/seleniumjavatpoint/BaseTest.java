package com.javatpoint.seleniumjavatpoint;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import seleniumjavatpoint.AboutPage;
import seleniumjavatpoint.GoogleSearch;

import java.util.ArrayList;
import java.util.HashSet;

public class BaseTest {

        public WebDriver driver;

        AboutPage aboutPage;
        GoogleSearch googleSearch;

        ArrayList<String> al;
        HashSet<String> hs;

        /**
         * @param browser
         * @param appURL
         */
        @Parameters({"browser", "appURL", "groups"})
        @BeforeClass(alwaysRun = true)
        public void initializeTestBaseSetup(String browser, String appURL, String groups) {
            try {
                DriverFactory.setDriver(browser, appURL, groups);

            } catch (Exception e) {
                System.out.println("Error....." + e.getStackTrace());
            }
            driver = DriverFactory.getDriver();

            aboutPage = new AboutPage(driver);
            googleSearch = new GoogleSearch(driver);

        }

        @AfterClass(enabled = true, alwaysRun = true)
        public void afterClassTearDown() {
            //driver.close();
            driver.quit();
        }



}
