package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class FrameAssignment extends Base{

    @Test
    public void FrameAssignment(){

        WebDriver driver = setpropforChrome();

        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.linkText("Nested Frames")).click();
        driver.switchTo().frame(0);
        driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-middle']")));
        System.out.println(driver.findElement(By.id("content")).getText());
        driver.quit();

    }
}
