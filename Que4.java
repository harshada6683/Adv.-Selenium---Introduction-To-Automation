package Adv_selenium_automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Que4 {
	@Test
	public void web_driver() throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new FirefoxDriver();
		
		driver.get("https://www.facebook.com/");
		driver.findElement(By.id("email")).sendKeys("mayuri@gmail.com");
		Thread.sleep(2000);
		
		driver.findElement(By.id("pass")).sendKeys("1234");
		Thread.sleep(2000);
		
		driver.findElement(By.name("login")).click();
		Thread.sleep(1000);
		
		driver.close();
		
	}

}
