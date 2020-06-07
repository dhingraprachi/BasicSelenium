package Selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class Synchronization extends Base {
    @Test
    public void SyncHandling(){
        WebDriver driver = setpropforChrome();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);


        driver.get("https://alaskatrips.poweredbygps.com/g/pt/hotels?MDPCID=ALASKA-US.TPS.BRAND.hotels.HOTEL");

        driver.findElement(By.xpath("//input[@id='package-origin-hp-package']")).sendKeys("NYC");
        driver.findElement(By.xpath("//input[@id='package-origin-hp-package']")).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//input[@id='package-destination-hp-package']")).sendKeys("TEXAS");
        driver.findElement(By.xpath("//input[@id='package-destination-hp-package']")).sendKeys(Keys.ENTER);

        driver.findElement(By.id("search-button-hp-package")).click();

        WebDriverWait d= new WebDriverWait(driver,20);
        d.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.linkText("❮ Back to AlaskaAir.com"))));

        driver.findElement(By.linkText("❮ Back to AlaskaAir.com")) .click();

        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.findElement(By.cssSelector("div#start button")).click();
        Wait<WebDriver> wt = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);

        WebElement btn = wt.until(new Function<WebDriver, WebElement>() {
            public WebElement apply (WebDriver driver){
                if(driver.findElement(By.cssSelector("div#finish h4")).isDisplayed())
                    return driver.findElement(By.cssSelector("div#finish h4"));
                return null;
            }
        });
        System.out.println(driver.findElement(By.cssSelector("div#finish h4")).getText());
        driver.close();
    }
}
