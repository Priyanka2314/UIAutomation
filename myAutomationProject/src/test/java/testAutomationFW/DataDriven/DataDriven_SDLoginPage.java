package testAutomationFW.DataDriven;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class DataDriven_SDLoginPage {
	public WebDriver driver;
  @Test(dataProvider="sd_testdata")
  public void sdLogin(String userName,String passwd) throws InterruptedException {
	//TC 1: Launch Chrom Browser
		 driver = new ChromeDriver();
	 // TC 2: Go to Test Url
		    driver.get("https://www.saucedemo.com/v1/");
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	 // TC 3: manage the browser window to maximize -  Maximize Browser Window
		    driver.manage().window().maximize();
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	 // TC 4: Fill Username Textbox with input
		    driver.findElement(By.id("user-name")).sendKeys(userName);
		    Thread.sleep(3000);
	 // TC 5: Fill password Textbox with input
		    driver.findElement(By.id("password")).sendKeys(passwd);
		    Thread.sleep(3000);
	 // TC 6: Click on Login Button
		    driver.findElement(By.xpath("//input[@id='login-button']")).click();
		    Thread.sleep(3000);
	 //TC 7: Verify Login 
		     String expectedUrl="https://www.saucedemo.com/v1/inventory.html";
		     String actualUrl = driver.getCurrentUrl();
		    Assert.assertEquals(actualUrl, expectedUrl);
  }
  
  @AfterMethod
//TC 8: Close the Browser 
  public void teardown() {
	  driver.close();
  }
  
  
  @DataProvider(name="sd_testdata")
  public Object[][] readExcel() throws BiffException, IOException{
	  //open File to read and write, which is available in the same package
	  File f=new File("E:\\Personal_Workspace\\Oct14th_2023\\Automation\\myAutomationProject\\src\\test\\resources\\allResouceFiles\\TestData_SwagDemo.xls");
	  Workbook w=Workbook.getWorkbook(f);
	  Sheet s=w.getSheet(0);
	  
	  int noOfRows=s.getRows();
	  int noOfColumns=s.getColumns();
	  
	  //Creating an array to store the data of an Excel sheet
	  String inputData[][]=new String[noOfRows-1][noOfColumns];
	  int count=0;
	  for(int i=1;i<noOfRows;i++) {
		  for(int j=0;j<noOfColumns;j++) {
			  Cell c=s.getCell(j, i);
			  inputData[count][j]=c.getContents();
		  }
		  count++;
	  }
	return inputData;
	  
  }
}
