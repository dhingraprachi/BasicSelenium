package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BrokenLinks extends Base {


    private int ActiveLInk;

    @Test
    public void countActiveLinks() throws MalformedURLException {

//        ChromeOptions options = new ChromeOptions();
//        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
//        WebDriver driver = setpropforChromeWithParam(options);
        System.setProperty("webdriver.chrome.driver", "/Users/prachi/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        List<WebElement> links = driver.findElements(By.tagName("a"));

        for (int i = 0; i < links.size(); i++) {
            String url = links.get(i).getAttribute("href");
            ActiveLInk = ActiveLInk + verifyLink(url);
        }

        System.out.println("Total Links are " + links.size() + " and Active Links are " + ActiveLInk);
    }

    private int verifyLink(String url) throws MalformedURLException {
        int activeLink = 0;

        try {

            URL currUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) currUrl.openConnection();
            connection.setConnectTimeout(3000);
            connection.connect();
            if (connection.getResponseCode() == 200) {
                System.out.println(connection.getResponseMessage() + " " + currUrl);
                activeLink++;
            }
            else
            {
                System.out.println(connection.getResponseMessage()+" "+ currUrl);
            }
        } catch (Exception e) {
        }
        return activeLink;
    }
}


