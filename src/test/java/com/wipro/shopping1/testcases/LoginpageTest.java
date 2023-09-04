package com.wipro.shopping1.testcases;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.wipro.shopping1.pages.Homepage;
import com.wipro.shopping1.pages.LoginPage;
import com.wipro.shopping1.utilities.Utilities;

public class LoginpageTest extends Base {
	LoginPage loginpage;
	Homepage homepage;
	
	public LoginpageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browser"));
		homepage=new Homepage(driver);
		loginpage=new LoginPage(driver);
		
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
		
	
	@Test(priority=2,dataProvider="validCredentialsSupplier")
	public void Login_with_valid_credentials(String email,String password) {
		
		homepage.Click_My_Account();
		homepage.Click_Login();
		loginpage.Enter_Email(email);
		loginpage.Enter_Password(password);
		loginpage.Click_Submit();
		loginpage.sucessmessage();
		
	}
	@DataProvider(name="validCredentialsSupplier")
	public Object[][] supplyTestData() {
		
		Object[][] data = Utilities.getTestDataFromExcel("Login");
		return data;
	}
	@Test(priority=1)
	public void Login_with_Invalid_Credentials() {
		
		homepage.Click_My_Account();
		homepage.Click_Login();
		loginpage.Enter_Email(prop.getProperty("invalidemail"));
		loginpage.Enter_Password(prop.getProperty("invalidpassword"));
		loginpage.Click_Submit();
		loginpage.errormessage();
		
	}

}
