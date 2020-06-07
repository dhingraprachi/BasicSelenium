package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class ChildWindows extends Base {

   @Test
   public void childWindows(){

        WebDriver driver = setpropforChrome();
        driver.get("https://accounts.google.com/signup");

        String ctrlClick = Keys.chord(Keys.SHIFT,Keys.ENTER);
        driver.findElement(By.linkText("Help")).sendKeys(ctrlClick);
       driver.findElement(By.linkText("Privacy")).sendKeys(ctrlClick);

        Set<String> wins= driver.getWindowHandles();
        Iterator<String> itr = wins.iterator();


        String parwin=itr.next();
        String win1 = itr.next();
       String win2=itr.next();

        driver.switchTo().window(win1);
        System.out.println("I am in help window " + driver.getTitle());

        driver.switchTo().window(parwin);
        System.out.println(("I am in main window " + driver.getTitle()));

        //driver.findElement(By.linkText("Privacy")).click();

       driver.switchTo().window(win2);
       System.out.println("I am in 2nd window " + driver.getTitle());
       driver.close();
   }
}
