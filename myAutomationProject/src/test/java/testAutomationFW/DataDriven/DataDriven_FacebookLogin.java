package testAutomationFW.DataDriven;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class DataDriven_FacebookLogin {
	WebDriver driver;
  @Test(dataProvider = "facebook_data" )
  public void facebook_login(String fname, String lname,String email,String pwd) throws InterruptedException {
	  //Launch the Chrome Browser
	  driver=new ChromeDriver();
	  //Goto Test Url https://en-gb.facebook.com/
	  driver.get("https://en-gb.facebook.com/");
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	  //Click on Create account
	  driver.findElement(By.xpath("//a[contains(text(),'Create new account')]")).click();
	  Thread.sleep(3000);
	  //Fill First name as input
	  driver.findElement(By.name("firstname")).sendKeys(fname);
	  Thread.sleep(3000);
	  //Fill lastname as input
	  driver.findElement(By.name("lastname")).sendKeys(lname);
	  Thread.sleep(3000);
	  //Fill Email
	  driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys(email);
	  Thread.sleep(3000);
	  //Fill New password
	  driver.findElement(By.xpath("//input[@id='password_step_input']")).sendKeys(pwd);
	  Thread.sleep(3000);
  }
  
  @AfterMethod
  
  public void teardown() {
	  driver.close();
  }
  
  @DataProvider(name="facebook_data")
  public Object[][] readExcel() throws BiffException, IOException{
	//open File to read and write, which is available in the same package
	  File f=new File("E:\\Personal_Workspace\\Oct14th_2023\\Automation\\myAutomationProject\\src\\test\\resources\\allResouceFiles\\TestData_FB_Registration.xls");
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
