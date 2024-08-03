package Adv_selenium_automation;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Que1 {
	@Test 
	public String [][] readExcel() throws InvalidFormatException, IOException
	{	
		String[][] data=null;
		
		//String filepath= "C:\\Users\\HP\\Desktop\\DataDriven.xlsx";
		
		String filepath="G:\\Tops Techonology\\selenium\\DataDriven.xlsx";
		
		File file=new File(filepath);
		 XSSFWorkbook workbook= new XSSFWorkbook(file);
		Sheet sheet=workbook.getSheet("Sheet1");
		int nrow=sheet.getPhysicalNumberOfRows();
		System.out.println("no of row is :" +nrow);
		data=new String[nrow][];
		for (int i = 0; i < data.length; i++) 
		{
			Row row=sheet.getRow(i);
			int ncol=row.getPhysicalNumberOfCells();
			System.out.println("no of cells :" +ncol);
			data[i]= new String[ncol];
				for (int j = 0; j < data.length; j++) 
				{
					Cell cell=row.getCell(j);
					cell.setCellType(CellType.STRING);
					data[i][j]=cell.getStringCellValue();
				}
		}	
		return data;
	}	
	
			WebDriver driver=null;
			@Test
			public void test() throws InterruptedException, InvalidFormatException, IOException
			{
				System.setProperty("webdriver.gecko.driver","G:\\Tops Techonology\\selenium\\geckodriver-v0.33.0-win64\\geckodriver.exe");			
				
				String data[][] =readExcel();
				
				for (int i = 0; i < data.length; i++) 
				{
					driver=new FirefoxDriver();
					driver.get("https://www.saucedemo.com/");
					Thread.sleep(3000);
					
					driver.findElement(By.id("user-name")).sendKeys(data[i][0]);
					Thread.sleep(2000);
					
					driver.findElement(By.id("password")).sendKeys(data[i][1]);
					Thread.sleep(2000);
					
					driver.findElement(By.id("login-button")).click();
					Thread.sleep(2000);
					
					driver.findElement(By.id("react-burger-menu-btn")).click();
					Thread.sleep(2000);
					driver.findElement(By.id("logout_sidebar_link")).click();
					
					Thread.sleep(2000);
					
					driver.close();
					
				}
				
			}
}
