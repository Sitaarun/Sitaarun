package org.iit.healthcare.mmp.patientmodule.pages;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ScheduleAppointmentPage {
	WebDriver driver;
	public ScheduleAppointmentPage(WebDriver driver) {
		this.driver = driver;




	}

	public HashMap<String, String> bookAppointment(String doctorname)
	{
		HashMap<String,String> sMap = new HashMap<String,String>();
		sMap.put("Doctor", "doctorname");

		driver.findElement(By.xpath("//input[@value='Create new appointment']")).click();
		driver.findElement(By.xpath("//h4[text()=doctorname]/ancestor::ul/following-sibling::button[@id='opener']")).click();
		driver.switchTo().frame("myframe");

		sMap.put("Date","06/10/2021");
		driver.findElement(By.id("datepicker")).sendKeys("06/10/2021");

		Select timeSelect = new Select(driver.findElement(By.id("time")));
		sMap.put("Time", "10Am");
		timeSelect.selectByValue("10Am");


		driver.findElement(By.id("ChangeHeatName")).click();
		sMap.put("Appointment","Fever");
		driver.findElement(By.id("sym")).sendKeys("Fever");


		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		return sMap;

	}
	public HashMap<String,String> fetchCurrentAppointmentData() 
	{
	
				
				HashMap<String, String>	sMap = new HashMap<String, String>();
				String time =  driver.findElement(By.xpath("//a[contains(text(),'Time')]")).getText();
				String doctor =  driver.findElement(By.xpath("//a[contains(text(),'Provider')]")).getText();
				String symptoms =  driver.findElement(By.xpath("//a[contains(text(),'Symptoms')]")).getText();
				String date =  driver.findElement(By.xpath("(//h3[@class ='panel-title'])[2] ")).getText();
				sMap.put("Doctor", doctor);
				sMap.put("Date",date);
				sMap.put("Time", time);
				sMap.put("Appointment",symptoms);
				return sMap;

		
		
	}

}





