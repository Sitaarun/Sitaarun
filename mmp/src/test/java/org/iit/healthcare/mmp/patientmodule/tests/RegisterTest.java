package org.iit.healthcare.mmp.patientmodule.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterTest {
	@Test
	public class RegisterationPatientPage {
		WebDriver driver;
		@BeforeMethod
		public void setUP() throws Exception {
			System.setProperty("webdriver.chrome.driver", "./BrowserExe/chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
		@Test (priority =1)
		public void clickRegisterButton()
		{
			 driver.findElement(By.xpath("//input[@value='Register']")).click();
			  String title="Login SuccessFul";
			     Assert.assertEquals(title, "Login");
			     System.out.println("The registration Page is displayed with: "+ title);
			   driver.close();
			}
		@Test (priority =2)
		public void US_002_RegisterPatient_validateSSN() throws Exception
		{
			driver.findElement(By.xpath("//input[@value='Register']")).click();
			 driver.findElement(By.id("ssn" )).sendKeys("869029165");
			   driver.findElement(By.name("register")).click();
			   	String string="Valid";
		  System.out.println("The SSN number is"+" "+ string);
		  Thread.sleep(3000);
		  driver.close();
			
		}
		@Test (priority =3)
		public void US_002_RegisterPatient_ValidateSSN() throws Exception
		{
			  driver.findElement(By.xpath("//input[@value='Register']")).click();
			   driver.findElement(By.id("ssn" )).sendKeys("ABCD$$%%&");
			   driver.findElement(By.name("register")).click();
		    	  String str1="Invalid";
		System.out.println(" Please enter the valid SSN is"+ " "+str1);
		Thread.sleep(3000);
		driver.close();
		}
		@AfterMethod
		public void tearDown()
		{
			driver.quit();
		}

}

}
