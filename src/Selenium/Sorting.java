package Selenium;

import Selenium.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.*;

public class Sorting extends Base {
    public static void main(String[] args){

        setpropforChrome();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        //driver.findElements(By.tagName("a")).get(1).click();

        driver.findElement(By.linkText("Top Deals")).click();

        Set<String> wins = driver.getWindowHandles();
        Iterator<String> itr=wins.iterator();

        String curr = itr.next();
        String newwin=itr.next();

        driver.switchTo().window(newwin);

        List<WebElement> veg=driver.findElements(By.cssSelector("td:nth-child(2)"));

        driver.findElement(By.cssSelector("tr th:nth-child(2)")).click();
       driver.findElement(By.cssSelector("tr th:nth-child(2)")).click();

        ArrayList<String> original = new ArrayList<String>();
        for(int i=0;i<veg.size();i++)
        {
            original.add((veg.get(i).getText()));
        }

        ArrayList<String> sortedlist = new ArrayList<String>();

        for(int i=0;i<original.size();i++)
        {
            sortedlist.add((veg.get(i).getText()));
        }

        Collections.sort(sortedlist);

        Assert.assertEquals(original,sortedlist);
        System.out.println("Ascending order Pass");
    }
}
