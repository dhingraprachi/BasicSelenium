package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AddItemstoCartWithImplicitWait extends Base {

    @Test
    public void addItemstoCart() throws IOException {

        WebDriver driver = setpropforChrome();

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        SS(driver);

        String[] items = {"Beetroot", "Cucumber", "Potato", "Pumpkin"};
        //Implicit Wait Implemented
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        addItems(driver, items);
        checkout(driver);
        driver.close();
    }

        public static void addItems(WebDriver driver,String[] items) throws IOException {
            int j=0;
        List itemsreqd= Arrays.asList(items);
        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

        for(int i=0;i<products.size();i++) {
            String[] currprod = products.get(i).getText().split(" ");
            //String actualitem = currprod[0].trim();

            if (itemsreqd.contains(currprod[0])) {
                driver.findElements(By.cssSelector("div.product-action button")).get(i).click();
                j++;
                if (j == itemsreqd.size())
                    break;
                SS(driver);
            }
        }
    }

    public static void checkout(WebDriver driver){

        driver.findElement(By.xpath("//img[@alt='Cart']")).click();
        driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
        driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
        driver.findElement(By.cssSelector("button.promoBtn")).click();
        System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
    }
}
