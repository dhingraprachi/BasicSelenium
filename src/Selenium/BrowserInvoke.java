package Selenium;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;


public class BrowserInvoke extends Base {


    @Test
    public void chromeBrowserInvoke() {
        //Invoking ChromeBrowser
        WebDriver driver =  setpropforChrome();
        driver.get("https://www.google.com"); //Opening Google
        driver.close();
    }

    @Test
         public void firefoxBrowserInvoke() {
        //Invoking FirefoxBrowser
        WebDriver driver1 = setpropforFirefox();
        driver1.get("https://www.google.com"); //Opening Firefox
        driver1.close();
    }

}
