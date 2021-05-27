package org.iit.healthcare.mmp.patientmodule.tests;

import java.util.HashMap;


import org.iit.healthcare.mmp.patientmodule.pages.ScheduleAppointmentPage;
import org.iit.healthcare.mmp.patientmodule.pages.LoginPage;
import org.iit.healthcare.BaseClass;
import org.iit.healthcare.mmp.patientmodule.pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;




public class ScheduleAppointmentTests extends BaseClass {
	WebDriver driver;

	@Test
	public void validateBookAppointment() 
	{

		LoginPage lpage = new LoginPage(driver);
		lpage.launchBrowser("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
		lpage.login("ria1", "Ria12345");
		HomePage hPage = new HomePage(driver);
		hPage.navigationToAModule("scheduleAppointment");
		ScheduleAppointmentPage sPage = new ScheduleAppointmentPage(driver);

		SoftAssert sAssert = new SoftAssert();
		HashMap<String,String> expHMap = sPage.bookAppointment("Dr.Beth");
		HashMap<String,String> actHMap = hPage.fetchPatientDetails();
		sAssert.assertEquals(actHMap, expHMap);

		actHMap = sPage.fetchCurrentAppointmentData();
		sAssert.assertEquals(actHMap, expHMap);
		sAssert.assertAll();
		

	}

	public void navigationToAModule(String moduleName)
	{

		driver.findElement(By.xpath("//span[contains(text(),'"+moduleName+"')]")).click();
	}

}
