package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class locators extends Base{

	@Test
    public void locators() {

        WebDriver driver= setpropforChrome();
//
//		driver.get("https://www.google.com");   //Opening Google
//		driver.findElement(By.name("q")).sendKeys("Selenium Locators demo"); //Entering parameter using name locator
//		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("this is the xpath"); //Entering parameter using customised xpath locator
//
//		//Entering the data by using customised CSS
//		driver.findElement(By.cssSelector("input[name='q']")).sendKeys("this is css"); //Entering parameter using customised cssSelector locator
//
//		driver.findElement(By.xpath("//div[@jsname='RNNXgb']/div/div/input")).sendKeys("Parent - Child relationship forward traversing");  //Entering the data by using xpath parent child forward traversing  locator

		//Entering the data by using absolute path
		//driver.get("http://www.qaclickacademy.com/interview.php");
//		try{
//            driver.findElement(By.xpath("//body/section/div/div/div/div/ul/li[2]")).click(); //Entering the data by absolute xpath
//
//        }catch (NoSuchElementException e){
//		    e.printStackTrace();
//        }

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://demo.guru99.com/test/guru99home/");

		//Usage of Contains
		driver.findElement(By.xpath("//a[contains(text(),'SELENIUM')]")).click();
        driver.navigate().back();

		//Validating the data by text
		driver.findElement(By.xpath("//a[text()='QTP']")).click();
		driver.navigate().back();

		//Validating the data by sibling
        System.out.println(driver.findElement(By.xpath("//div/a[@href='http://www.guru99.com/selenium-tutorial.html']/following-sibling::h4")).getText());

        //Validating data by traversing from parent to child
        driver.findElement(By.xpath("//div[@class='menu-block']/ul/li[@class='item118 parent']")).click();
        driver.navigate().back();

        //Validating data by traversing from child to parent back
        String val = driver.findElement(By.xpath("//a[contains(text(),'Corporate Training')]//parent::div")).getAttribute("class");


      //  System.out.println(driver.findElement(By.xpath("//li/a[contains(text(),'Courses')]/parent::li")).getAttribute("href"));
        driver.close();

   }

}
