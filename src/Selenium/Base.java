package Selenium;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;

public class Base {

    public static WebDriver setpropforChrome() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    public static WebDriver setpropforChromeWithParam(ChromeOptions param) {
        System.setProperty("webdriver.chrome.driver", "/Users/prachi/Library/jars/chromedriver");
        WebDriver driver = new ChromeDriver(param);
        driver.manage().window().maximize();
        return driver;
    }

    public static WebDriver setpropforFirefox(){
        System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"/src/resources/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize(); // Maximizing the wind)
        return driver;
    }

    public static void SS(WebDriver driver) throws IOException {
        File scrn = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrn, new File("Screenshots/1.jpg"));
    }
}


