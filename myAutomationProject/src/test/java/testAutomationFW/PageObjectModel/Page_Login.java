package testAutomationFW.PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Page_Login {
  WebDriver driver;
  
  //Specify object/Element Locators
  By UsernameFilled=By.id("user-name");
  By PasswordField=By.id("password");
  By LoginBtn=By.xpath("//input[@id='login-button']");
  
  By text_Product =By.xpath("//div[text()='Products']");
  By button_AddtoCart =By.xpath("(//button[text()='ADD TO CART'])[1]");
  By shopping_cart=By.xpath("//a[contains(@class,'shopping_cart_link')]");
  By text_Cart = By.xpath("//div[text()='Your Cart']");
  
  public Page_Login(WebDriver driver) {
	  this.driver=driver;
  }
  
  public void type_Username(String uname) throws InterruptedException {
	  driver.findElement(UsernameFilled).sendKeys(uname);
	  Thread.sleep(5000);
  }
  
  public void type_UPassword(String pwd) throws InterruptedException {
	  driver.findElement(PasswordField).sendKeys(pwd);
	  Thread.sleep(5000);
  }
  
  public void click_Login() throws InterruptedException {
	  driver.findElement(LoginBtn).click();
	  Thread.sleep(5000);
  }
  
  public String capture_Producttxt(){
	  return driver.findElement(text_Product).getText();
  }
  
  public void click_AddtoCart() throws InterruptedException {
	  driver.findElement(button_AddtoCart).click();
	  Thread.sleep(5000);
  }
  public void click_shopping_cart() throws InterruptedException {
	  driver.findElement(shopping_cart).click();
	  Thread.sleep(5000);
  }
  
  public String capture_text_Cart(){
	  return driver.findElement(text_Cart).getText();
  }
}
