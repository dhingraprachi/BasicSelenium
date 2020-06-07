package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class windowhandlingAssignment {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/Users/prachi/Library/jars/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.linkText("Multiple Windows")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.linkText("Click Here")).click();

        Set<String> wins= driver.getWindowHandles();
        Iterator<String> itrs= wins.iterator();

        String win1=itrs.next();
        String win2=itrs.next();

        driver.switchTo().window(win2);
        System.out.println(driver.findElement(By.xpath("//div[@class='example']")).getText());

        driver.switchTo().window(win1);
        System.out.println(driver.findElement(By.xpath("//div/div/div/h3")).getText());

    }
}
