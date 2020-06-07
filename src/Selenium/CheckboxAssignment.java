package Selenium;

import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckboxAssignment extends Base{

    @Test
    public void checkBoxAssignment(){

        WebDriver driver = setpropforChrome();

        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
    try{
        WebElement cb1 = driver.findElement(By.id("checkBffoxOption1"));

//        cb1.click();
//        Assert.assertEquals(cb1.isSelected(),true);
//        System.out.println("Checked");
//        cb1.click();
//        Assert.assertEquals(cb1.isSelected(),false);
//        System.out.println("Unchecked");

        System.out.println("Total checkboxes present in the page are "+driver.findElements(By.cssSelector("input[type='checkbox']")).size());
        driver.close();
    }
    catch (NoSuchElementException e){
        System.out.println("This messagse is from basic catch block");;
    }
    catch (Exception e){
        System.out.println("This messagse is from main catch block");;
    }

    }
}
