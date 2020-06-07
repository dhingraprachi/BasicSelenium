package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import javax.xml.ws.Action;

public class Frame extends Base {

    @Test
    public void Frame() {

        WebDriver driver = setpropforChrome();
        driver.get("https://jqueryui.com/droppable/");
        System.out.println(driver.findElements(By.tagName("iframe")).size());

        //driver.switchTo().frame(driver.findElement(By.className("demo-frame")));        //Switch by Frame - WebElement
        driver.switchTo().frame(0);       // Switch by Frame - Index
        Actions act= new Actions(driver);
        act.dragAndDrop(driver.findElement(By.id("draggable")),driver.findElement(By.id("droppable"))).build().perform();
        driver.switchTo().defaultContent();
        driver.close();

    }
}