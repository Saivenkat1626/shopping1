package com.wipro.shopping1.testcases;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.wipro.shopping1.pages.Homepage;
import com.wipro.shopping1.pages.LoginPage;
import com.wipro.shopping1.pages.Registerpage;

public class RegisterpageTest extends Base {
	LoginPage loginpage;
	Homepage homepage;
	Registerpage rp;
	
	public RegisterpageTest() {
		super();
	}
	@BeforeMethod
	public void setup() {
		
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browser"));
		homepage=new Homepage(driver);
		loginpage=new LoginPage(driver);
		rp=new Registerpage(driver);
		
	}
	
	@AfterMethod
	
		public void tearDown(ITestResult result){
			//using ITestResult.FAILURE is equals to result.getStatus then it enter into if condition
				if(ITestResult.FAILURE==result.getStatus()){
					try{
						// To create reference of TakesScreenshot
						TakesScreenshot screenshot=(TakesScreenshot)driver;
						// Call method to capture screenshot
						File src=screenshot.getScreenshotAs(OutputType.FILE);
						// Copy files to specific location 
						// result.getName() will return name of test case so that screenshot name will be same as test case name
						FileUtils.copyFile(src, new File("F:\\testing workspaces\\jenkins\\Shopping1\\screenshots"+result.getName()+".png"));
						System.out.println("Successfully captured a screenshot");
					}catch (Exception e){
						System.out.println("Exception while taking screenshot "+e.getMessage());
					} 
			}
			driver.quit();
			}
	@Test
	public void User_enter_details() throws InterruptedException {
		homepage.Click_My_Account();
		homepage.Click_Register();
		rp.Firstname(dataprop.getProperty("lastname"));
		Thread.sleep(100);
		rp.Lastname(dataprop.getProperty("lastname"));
		Thread.sleep(100);
		rp.Email(dataprop.getProperty("email"));
		Thread.sleep(100);
		rp.Telephone(dataprop.getProperty("telephone"));
		Thread.sleep(100);
		rp.password(dataprop.getProperty("password"));
		Thread.sleep(100);
		rp.Confirm_Password(dataprop.getProperty("confirm"));
		Thread.sleep(100);
		rp.Newsletter();
		Thread.sleep(100);
		rp.Terms_and_Conditions();
		Thread.sleep(100);
		rp.Submit();
		
		
	}
	

}
