package Selenium;

import com.sun.xml.internal.ws.server.DefaultResourceInjector;
import org.openqa.selenium.*;
import org.testng.annotations.Test;

public class AutoSuggestiveDropDownwithHiddenElems extends Base {

    @Test
    public void AutoSuggestivewithJSEXecutor() throws InterruptedException
    {

        WebDriver driver = setpropforChrome();

        //Opening a URL
        driver.get("https://ksrtc.in/oprs-web/");
        //driver.findElement(By.cssSelector("button.close")).click();
        int count=0;
        WebElement txt = driver.findElement(By.id("fromPlaceName"));
        txt.sendKeys("hyd");
        txt.sendKeys(Keys.DOWN);

        JavascriptExecutor js=(JavascriptExecutor)driver;
        String script="return document.getElementById(\"fromPlaceName\").value;";
        String val= (String) js.executeScript(script);

        while (!(val.equalsIgnoreCase("HYDERABAD")))
        {
            txt.sendKeys(Keys.DOWN);
             val= (String) js.executeScript(script);
            count++;

            if (count>5)
            {
                System.out.println("Not present");
                break;
            }
        }
            if (count<5)
                System.out.println("Element is present at location "+count);
    }
}
