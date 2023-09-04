package com.wipro.shopping1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
		WebDriver ldriver;
		public Homepage(WebDriver rdriver){
			ldriver=rdriver;
			PageFactory.initElements(rdriver,this);
		}
		
@FindBy(xpath="//*[@id=\"top-links\"]/ul/li[2]")
@CacheLookup
WebElement MyAccount;
@FindBy(xpath="//li[@class='dropdown open']//*[contains(text(),'Register')]")
@CacheLookup
WebElement Register;
@FindBy(xpath="//li[@class='dropdown open']//*[contains(text(),'Login')]")
@CacheLookup
WebElement Login;


public void Click_My_Account() {
	MyAccount.click();
}
public void Click_Register() {
	Register.click();	
}
public void Click_Login() {
	Login.click();	
}
}
