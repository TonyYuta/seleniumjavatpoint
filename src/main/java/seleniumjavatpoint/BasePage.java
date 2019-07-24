package seleniumjavatpoint;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {

    protected WebElement we;
    protected WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public String currentPageTitle(){
        return driver.getTitle();
    }



}
