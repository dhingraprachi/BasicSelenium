package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class AddItemstoCartWithExplicitWait extends Base {

    @Test
   public void addItemsToCart() throws IOException {
        WebDriver driver =  setpropforChrome();

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        SS(driver);

        String[] items = {"Beetroot", "Cucumber", "Potato", "Pumpkin"};
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
            String actualitem = currprod[0].trim();

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

        WebDriverWait w=new WebDriverWait(driver,5);
        driver.findElement(By.xpath("//img[@alt='Cart']")).click();
        driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
        driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
        driver.findElement(By.cssSelector("button.promoBtn")).click();
        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
        System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
    }

}
