package Selenium;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BrowserNavigation extends Base {

    @Test
    public void checkURL() {
        WebDriver driver = setpropforChrome();
        driver.get("https://www.google.com"); //Opening Firefox
        String curr = driver.getCurrentUrl();
        Assert.assertEquals(curr, "https://www.google.com/");//Using Assertion to verify the current URL of website
        System.out.println("Test Case passed");
        driver.close();

    }

    @Test
    public void checkTitleAndNavigation(){
        WebDriver driver = setpropforChrome();
        driver.get("https://www.google.com"); //Opening Firefox
        System.out.println(driver.getTitle()); //Getting the title of the tab opened.
        driver.get("https://www.flipkart.com");
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");
        driver.navigate().back();
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());

        //System.out.println(driver.getPageSource());

        driver.navigate().forward();
        driver.navigate().to("https://www.paytm.com");
        driver.close();
    }
}
