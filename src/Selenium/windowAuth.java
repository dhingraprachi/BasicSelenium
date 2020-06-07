package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class windowAuth extends Base {

    @Test
    public void handleWindowPopUp() {

        WebDriver driver = setpropforChrome();

        driver.get("http://admin:admin@the-internet.herokuapp.com/");
        driver.findElement(By.linkText("Basic Auth")).click();
    }
}
