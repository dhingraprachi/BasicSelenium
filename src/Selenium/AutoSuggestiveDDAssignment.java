package Selenium;


import org.openqa.selenium.*;
import org.testng.annotations.Test;

public class AutoSuggestiveDDAssignment extends Base {

    @Test
    public void AutoSuggestiveDDAssignment(){

        WebDriver driver = setpropforChrome();
        //Opening a URL
        driver.get("http://www.qaclickacademy.com/");
        driver.findElement(By.linkText("PRACTICE")).click();

        int count = 0;

        WebElement txtbox=driver.findElement(By.id("autocomplete"));

        txtbox.sendKeys("Fran");
        txtbox.sendKeys(Keys.DOWN);

        JavascriptExecutor js=(JavascriptExecutor)driver;
        String script="return document.getElementById(\"autocomplete\").value;";
        String val= (String) js.executeScript(script);

        while (!(val.equalsIgnoreCase("France Metropolitan"))){
            txtbox.sendKeys(Keys.DOWN);
            val= (String) js.executeScript(script);
            count++;
            if (count>10)
            {
                System.out.println("Required element could not be found");
                break;
            }
        }

        if (count<10)
        {
            System.out.println("Required element found at location "+count);
        }
        driver.close();
    }
}