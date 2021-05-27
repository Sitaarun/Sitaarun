package org.iit.healthcare;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class BaseClass {
	
   protected WebDriver driver;
	@BeforeTest
	public void instantiateDriver()
	{
		System.setProperty("webdriver.chrome.driver", "./BrowserExe/chromedriver.exe");
		 driver = new ChromeDriver();
         
		 
	}
	

}
