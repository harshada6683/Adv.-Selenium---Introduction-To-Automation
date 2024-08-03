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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Que2 {
	@DataProvider(name="mayuri")
	public Object[][] readExcel() throws InvalidFormatException, IOException
	{
		Object[][] data=null;
		
		//1. to get file path
		String filepath="G:\\Tops Techonology\\selenium\\DataDriven.xlsx";
		//2. to make file
		File file=new File(filepath);
		//3. to open a excel file
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		//4. to open a particular sheet
		Sheet sheet=workbook.getSheet("Sheet2");
		//5. to get no of rows
		int nrow = sheet.getPhysicalNumberOfRows();
		System.out.println("no of row is :" +nrow);
		// 6. to select a particular row 
		data=new Object[nrow][];
		for (int i = 0; i < data.length; i++) {
			Row row =sheet.getRow(i);
			//7. to get no of col
			int ncol=row.getPhysicalNumberOfCells();
			System.out.println("no of cells :" +ncol);
			//8. to select a perticular cell
			data [i]= new Object[ncol];
			for (int j = 0; j < data[i].length; j++) {
				Cell cell=row.getCell(j);
				//9. to convert cell value into string
				
				cell.setCellType(CellType.STRING);
				//10. to get data from the cell
				data[i][j]=cell.getStringCellValue();
			}
		}
				
		return data;
	}
	
	WebDriver driver=null;
	@Test(dataProvider = "mayuri")
	public void test(String keyword) throws InterruptedException, InvalidFormatException, IOException
	{
		System.setProperty("webdriver.gecko.driver","G:\\Tops Techonology\\selenium\\geckodriver-v0.33.0-win64\\geckodriver.exe");			
		
		Object[][] data = readExcel();
		
		if (keyword.equals("open browser")) 
		{
			driver=new FirefoxDriver();
			Thread.sleep(3000);
		}else if (keyword.equals("enter url")) 
		{
			driver.get("https://www.saucedemo.com/");
			Thread.sleep(3000);
			
		}else if (keyword.equals("enter username")) 
		{
			driver.findElement(By.id("user-name")).sendKeys("standard_user");
			Thread.sleep(2000);
		}else if (keyword.equals("enter password")) 
		{
			driver.findElement(By.id("password")).sendKeys("secret_sauce");
			Thread.sleep(2000);
		}else if (keyword.equals("click login")) 
		{
			driver.findElement(By.id("login-button")).click();
			Thread.sleep(2000);	
			
			driver.findElement(By.id("react-burger-menu-btn")).click();
			Thread.sleep(2000);
		}
		else if (keyword.equals("click logout")) {
			driver.findElement(By.id("logout_sidebar_link")).click();
			Thread.sleep(2000);
		}else if (keyword.equals("close browser")) {
			Thread.sleep(2000);
			driver.close();
		}
					
		}		
}
