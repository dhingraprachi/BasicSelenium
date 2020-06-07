package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionClassUsage extends Base {


	@Test
	public void mouseActions(){

		WebDriver driver = setpropforChrome();
		Actions ac = new Actions(driver);

		//Mouse Hover
		driver.get("https://demoqa.com/menu/");
		ac.moveToElement(driver.findElement(By.id("ui-id-4"))).build().perform();
		System.out.println("Mouse Hover action performed");

		//UpperCase Text Entry
		driver.get("https://www.amazon.in");
		ac.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello").build().perform();
		System.out.println("Text entered in upper case");

		//Double-click
		driver.get("https://www.amazon.in");
		ac.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello").build().perform();
		ac.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).doubleClick().build().perform();
		System.out.println("Double click action performed");
		String str=driver.findElement(By.id("twotabsearchtextbox")).getAttribute("value");

		//Context-click/right click
		driver.get("https://www.amazon.in");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("hello");
		ac.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).contextClick().build().perform();
		System.out.println("Right click action performed");
		driver.close();
	}
}