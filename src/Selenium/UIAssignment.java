package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class UIAssignment extends Base{

    public static void main(String[] args) {

//        //System.setProperty("webdriver.gecko.driver", "/Users/prachidhingra/bin/geckodriver");
//        WebDriver driver = setprop();
//
//        driver.manage().window().maximize();
//
//        driver.get("https://www.alaskaair.com/");
//
//        Select dd= new Select(driver.findElement(By.id("Adults")));
//        dd.selectByValue("5");
//        Select cc=new Select(driver.findElement(By.id("Childrens")));
//        cc.selectByValue("3");
//
//        driver.findElement(By.id("DepartDate")).click();
//        driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();
//
//        driver.findElement(By.id("MoreOptionsLink")).click();
//        driver.findElement(By.id("AirlineAutocomplete")).sendKeys("Vistara");
//
//        driver.findElement(By.id("SearchBtn")).click();
//
//        System.out.println(driver.findElement(By.id("homeErrorMessage")).getText());

        //WebDriver driver = setprop();

        System.setProperty("webdriver.chrome.driver", "/Users/prachi/Library/jars/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.cleartrip.com/");
        driver.manage().window().maximize();

        Select adults = new Select(driver.findElement(By.id("Adults")));
        adults.selectByIndex(3);

        Select child = new Select(driver.findElement(By.id("Childrens")));
        child.selectByVisibleText("4");
        driver.findElement(By.id("DepartDate")).click();

        driver.findElement(By.id("MoreOptionsLink")).click();
        driver.findElement(By.id("AirlineAutocomplete")).sendKeys("Vistara");
        driver.findElement(By.id("SearchBtn")).click();
        System.out.println(driver.findElement(By.id("homeErrorMessage")).getText());

    }
}
