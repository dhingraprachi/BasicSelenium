package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DynamicDropDownByParenttoChildXpath extends Base {

    @Test
    public void DDByTraversing(){

        WebDriver driver= setpropforChrome();

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        //Opening a URL
        driver.get("https://www.spicejet.com");

        driver.findElement(By.name("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='BLR']")).click();
        //Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='AMD']")).click();
        System.out.println("Test Case passed");
        driver.close();
    }
}
