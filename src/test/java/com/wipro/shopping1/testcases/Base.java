package com.wipro.shopping1.testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.safari.SafariDriver;




public class Base {
	
	public static WebDriver driver;
	public Properties prop;
	public Properties dataprop;
	
	
	public Base() {
		
			File src=new File("F:\\testing workspaces\\jenkins\\Shopping1\\src\\main\\java\\com\\wipro\\shopping1\\config\\configuration.properties");
			try {
				FileInputStream fis=new FileInputStream(src);
				prop=new Properties();
				try {
					prop.load(fis);
				} catch (IOException e) {
					System.out.println("error message is" + e.getMessage());
				
				}
			} catch (FileNotFoundException e) {
				System.out.println("error message is" + e.getMessage());
			}
			File testdata=new File("F:\\testing workspaces\\jenkins\\Shopping1\\src\\main\\java\\com\\wipro\\shopping1\\testdata\\testdata.properties");
			try {
				FileInputStream fis1=new FileInputStream(testdata);
				dataprop=new Properties();
				try {
					dataprop.load(fis1);
				} catch (IOException e) {
					System.out.println("error message is" + e.getMessage());
				
				}
			} catch (FileNotFoundException e) {
				System.out.println("error message is" + e.getMessage());
			}
		}
		
		public WebDriver initializeBrowserAndOpenApplicationURL(String browserName) {
			
			if(browserName.equalsIgnoreCase("chrome")) {
				
				driver = new ChromeDriver();
				
			}else if(browserName.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver","F:\\testing workspaces\\jenkins\\Shopping1\\drivers\\geckodriver.exe" );
				
				driver = new FirefoxDriver();
				
			}else if(browserName.equalsIgnoreCase("edge")) {
				
				driver = new EdgeDriver();
				
			}else if(browserName.equalsIgnoreCase("safari")) {
				
				driver = new SafariDriver();
				
			}
		
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			driver.get(prop.getProperty("BaseURL"));
			
		return driver;
		
	}
		

}
