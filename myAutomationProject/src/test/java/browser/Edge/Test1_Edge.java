package browser.Edge;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Test1_Edge {
	WebDriver driver;
  @Test
  public void setup() {
	  //Launch the browser
	  driver=new EdgeDriver();
	  //Go to Test Url
	  driver.get("https://www.selenium.dev/");
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	  //Close the browser
	  driver.close();
	  
  }
}
