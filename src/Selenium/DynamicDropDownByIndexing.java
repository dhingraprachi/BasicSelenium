package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class DynamicDropDownByIndexing extends Base{

    @Test
    public void DDByIndexing(){

        WebDriver driver = setpropforChrome();

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        //Opening a URL
        driver.get("https://www.spicejet.com");
        driver.findElement(By.name("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.xpath("//a[@value='BHO']")).click();
        //Thread.sleep(2000);
        driver.findElement(By.xpath("(//a[@value='AMD'])[2]")).click();
        System.out.println("Test Case Passed");
        driver.close();
    }
}
