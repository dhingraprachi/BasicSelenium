package Selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class TableAssignment extends Base {

    public static void main(String[] args) {


        WebDriver driver = setpropforChrome();

        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
        //driver.findElement(By.linkText("PRACTICE")).click();

        WebElement table=driver.findElement(By.id("product"));

        int rowsize= table.findElements(By.tagName("tr")).size();

        WebElement firstdatarow=table.findElements(By.tagName("tr")).get(1);

        int colsize= firstdatarow.findElements(By.tagName("td")).size();

        System.out.println("Row size:- "+rowsize+"\n"+ "Columns size is:- "+colsize + "\n"+"Data of the second row is:- "+"\n");
       for(int i=0;i<colsize;i++) {
           System.out.println(table.findElements(By.tagName("tr")).get(2).findElements(By.tagName("td")).get(i).getText());
       }

    }
}
