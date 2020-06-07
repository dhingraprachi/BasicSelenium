package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;


public class calendarHandling extends Base{

    @Test
    public void calendar(){

        WebDriver driver = setpropforChrome();
        driver.get("https://www.path2usa.com/travel-companions");
        driver.findElement(By.id("travel_date")).click();

        String currMonth = "";
        while(!(currMonth.contains("November")))
        {
            currMonth = driver.findElement(By.cssSelector(".datepicker-switch")).getText();
            driver.findElement(By.cssSelector("[class=datepicker-days] [class=next]")).click();
        }
        System.out.println(currMonth);
        int count=driver.findElements(By.className("day")).size();

       for(int i=0;i<count;i++) {
           String doj = driver.findElements(By.className("day")).get(i).getText();

           if(doj.equalsIgnoreCase("30"))
           {
               driver.findElements(By.className("day")).get(i).click();
               break;
           }
       }
       driver.close();
    }
}
