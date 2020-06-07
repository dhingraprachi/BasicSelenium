package Selenium;
import org.openqa.selenium.*;
import org.testng.annotations.Test;


public class AutoSuggestiveDropDown extends Base {

    @Test
    public void AutoSuggestiveDD(){

        WebDriver driver = setpropforChrome();
        //Opening a URL

        driver.get("https://www.makemytrip.com/");

        WebElement src= driver.findElement(By.id("fromCity"));
        //src.clear();
        src.sendKeys("DEl");
        src.sendKeys(Keys.ARROW_DOWN);
        src.sendKeys(Keys.ENTER);

        JavascriptExecutor js= (JavascriptExecutor) driver;
        String script = "return document.getElementById(\"fromCity\").value;";
        System.out.println(js.executeScript(script));
        driver.close();
    }
}
