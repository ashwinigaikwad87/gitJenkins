package implicitwait;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class ImplicitWaitTest {
	WebDriver driver;
  @Test
  public void f() {
	  
	  driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");
	  driver.findElement(By.xpath("//div[@id='start']/button")).click();
	  String actualText=driver.findElement(By.xpath("//div[@id='finish']/h4")).getText();
	  
	  
	  //String expectedText="Hello World!";
	  
	  assertEquals(actualText, "Hello World!");
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.gecko.driver", "test\\resources\\geckodriver-64bit.exe");
		driver=new FirefoxDriver(); 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  @AfterMethod
  public void afterMethod() {
	  
	  driver.quit();
  }

}
