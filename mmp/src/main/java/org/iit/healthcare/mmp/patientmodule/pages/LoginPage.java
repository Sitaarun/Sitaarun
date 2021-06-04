package org.iit.healthcare.mmp.patientmodule.pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		
	}
  public void launchBrowser(String url) 
  {
	  driver.get(url);
  }
	public void login(String uname, String pword) {
		
			
			// driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
			// driver.manage().window().maximize();
				
			 driver.findElement(By.id("username")).sendKeys(uname);
			 driver.findElement(By.id("password")).sendKeys(pword);
			 driver.findElement(By.name("submit")).click();
		System.out.println("Login Successful");
			 
		
	}

}
