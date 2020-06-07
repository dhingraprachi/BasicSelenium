package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class PracticeExerciseAssignment extends Base{
    @Test
    public void PracticeExerciseAssignemnt(){

        WebDriver driver = setpropforChrome();
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
        WebElement selectedcb= driver.findElement(By.xpath("//div[@class=\"right-align\"] //label[2]/input[1]"));

        selectedcb.click();
        int num=0;
        String val = selectedcb.getAttribute("value");
        System.out.println(selectedcb.getText());

        Select dd = new Select(driver.findElement(By.id("dropdown-class-example")));
        List<WebElement> opt= dd.getOptions();

        for(int i =1; i<opt.size();i++)
        {
            String value = opt.get(i).getAttribute("value");
            if(val==value) {
                dd.selectByValue(value);
                break;
            }
             num=i;
        }
        String txt=opt.get(num).getText();

        driver.findElement(By.id("name")).sendKeys(txt);
        driver.findElement(By.id("alertbtn")).click();

       String alrttxt= driver.switchTo().alert().getText();

       if(alrttxt.contains(txt))
           System.out.println("Test Passed");
       else
           System.out.println("Test Failed");
    }
}