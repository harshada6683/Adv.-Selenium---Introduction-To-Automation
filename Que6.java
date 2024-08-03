package Adv_selenium_automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Que6 
{
	@Test
	public void testng_webdriver() throws InterruptedException 
	{
			WebDriverManager.chromedriver().setup();
			WebDriver driver=new FirefoxDriver();
			driver.get("https://demo.guru99.com/test/newtours/register.php");
			Thread.sleep(2000);
			WebElement e1=driver.findElement(By.name("country"));
			
			Select s1=new Select(e1);
			
			s1.selectByIndex(1);
			Thread.sleep(1000);
			
			s1.selectByValue("INDIA");
			Thread.sleep(2000);
			
			s1.selectByVisibleText("GERMANY");
			Thread.sleep(1000);
			
			driver.close();
					
	}
}
