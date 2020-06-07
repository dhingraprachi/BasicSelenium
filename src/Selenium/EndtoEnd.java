package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class EndtoEnd extends Base{

    @Test
    public void E2E() {

        WebDriver driver=setpropforChrome();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        //Opening a URL
        driver.get("https://www.spicejet.com");
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='BHO']")).click();
        driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='PNQ']")).click();
        driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();
 // if(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5"))

//  {
//            Assert.assertTrue(true);
//        }
//        else
//            Assert.assertTrue(false);
//

            String pass=driver.findElement(By.id("divpaxinfo")).getText();
            Assert.assertEquals(pass,"1 Adult");
            driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
            driver.close();
    }
}