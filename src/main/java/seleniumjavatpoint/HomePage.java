package seleniumjavatpoint;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver){
        super(driver);
    }

    //private static String homePageUrl = "https://www.javatpoint.com/";
    private static String homePageUrl = " https://www.bbc.com//";


    //cssSelector
    private String homePageTab = "#orb-nav-links > ul > li.orb-nav-homedotcom.orb-w > a";
    private String welcomeToBbComLabel = "#page > section.module.module--date.module--highlight > h2 > span";
    private By newsHeaderTab = By.cssSelector("#orb-nav-links > ul > li.orb-nav-newsdotcom.orb-w > a");
    private String dateLabel = "#page > section > h2";
    private By sportHeaderTab = By.cssSelector("#orb-nav-links > ul > li:nth-child(3) > a");
    private By homeHeaderTabSelected = By.cssSelector("div>div>nav>ul:nth-child(1)>li>a>span:nth-child(2)"); //needs getText()
    private By weatherHeaderTab = By.cssSelector("nav>div>ul>li:nth-child(4)>a");

    public HomePage navigateToHomePage(){
        driver.navigate().to(homePageUrl);
        return new HomePage(driver);
    }


}
