package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class RealTimePractice extends Base{
    @Test
    public void realTimepractice(){

        WebDriver driver=setpropforChrome();
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");

        //Count the number of links on the webpage
        System.out.println("Total links present in the page are "+driver.findElements(By.tagName("a")).size());

        //Count the links in the footer section
        WebElement footerdriver=driver.findElement(By.id("gf-BIG"));
        System.out.println("Links in footer section is "+footerdriver.findElements(By.tagName("a")).size());

        //Count the links in the first column of the footer section
        WebElement coldriver=footerdriver.findElement(By.xpath("//table/tbody/tr/td/ul[1]"));
        System.out.println("Links in first column of the footer section is "+coldriver.findElements(By.tagName("a")).size());

        //Verify the functioning of the links from column of footer section
        String ctrlclick= Keys.chord(Keys.COMMAND,Keys.ENTER);

        for(int i=1;i<coldriver.findElements(By.tagName("a")).size();i++) {
            coldriver.findElements(By.tagName("a")).get(i).sendKeys(ctrlclick);
        }
        Set<String> wins= driver.getWindowHandles();
        Iterator<String> itr=wins.iterator();

        while (itr.hasNext()){
            driver.switchTo().window(itr.next());
            System.out.println(driver.getTitle());
        }
        driver.close();
    }
}
