package Selenium;

import Selenium.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Table extends Base {

    public static void main(String[] args){


        WebDriver driver= setpropforChrome();

        int sum=0;
        driver.manage().window().maximize();
        driver.get("https://www.cricbuzz.com/live-cricket-scorecard/23264/pak-vs-sl-2nd-odi-sri-lanka-tour-of-pakistan-2019");

        WebElement table=driver.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-ltst-wgt-hdr']")).get(0);
        int count=table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)")).size();

        for (int i=0;i<count-2;i++){
            String name= table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)")).get(i).getText();
            sum=Integer.parseInt(name)+sum;
        }

        sum=sum+Integer.parseInt(table.findElement(By.xpath("//div[text()='Extras']/following-sibling::div[1]")).getText());

        int Expectedcount = Integer.parseInt(table.findElement(By.xpath("//div[text()='Total']/following-sibling::div[1]")).getText());

        Assert.assertEquals(sum,Expectedcount);
        System.out.println("Test passed as Calculated count "+sum +" is equal to the Expected count "+Expectedcount);
    }


}
