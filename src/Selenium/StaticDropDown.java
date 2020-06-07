package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class StaticDropDown extends Base {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.gecko.driver", "/Users/prachidhingra/bin/geckodriver");

        WebDriver driver = setpropforChrome();

        //Opening a URL
        driver.get("https://www.spicejet.com");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

       
        Select curr = new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
        curr.selectByIndex(2);
        curr.selectByValue("USD");
        curr.selectByVisibleText("INR");
        //driver.quit();

        int i=0;
        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(2000);
        Select adults = new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Adult")));
        adults.selectByVisibleText("5");
        driver.findElement(By.id("divpaxinfo")).click();

        Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(),"5 Adult");
        driver.quit();
    }
}
