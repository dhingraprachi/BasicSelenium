package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SyncAssignment extends Base{
	
	public static void main(String[] args) {

	WebDriver driver = setpropforChrome();

		driver.manage().window().maximize();

		driver.get("http://www.itgeared.com/demo/1506-ajax-loading.html");

		driver.findElement(By.linkText("Click to load get data via Ajax!")).click();

		WebDriverWait wd = new WebDriverWait(driver,7);

		//wd.until(ExpectedConditions.attributeContains(driver.findElement(By.id("modal")),"style","display: none;"));
		wd.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("results"))));
		System.out.println(driver.findElement(By.id("results")).getText());
	}
}
