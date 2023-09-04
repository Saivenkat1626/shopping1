package com.wipro.shopping1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {
	WebDriver ldriver;
	public LoginPage(WebDriver rdriver){
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
@FindBy(xpath="//input[@id=\"input-email\"]")
@CacheLookup
WebElement Email;
@FindBy(xpath="//input[@id=\"input-password\"]")
@CacheLookup
WebElement Password;
@FindBy(xpath="//*[@id=\"content\"]/div/div[2]/div/form/input")
@CacheLookup
WebElement Submit;
@FindBy(xpath="//div[@id=\"content\"]//h2[1]")
@CacheLookup
WebElement sucessmessage;
@FindBy(xpath="//*[contains(text(),\"Warning: No match for E-Mail Address and/or Password.\")]")
@CacheLookup
WebElement errormessage;
public void Enter_Email(String email) {
	Email.sendKeys(email);
}
public void Enter_Password(String password) {
	Password.sendKeys(password);
}
public void Click_Submit() {
	Submit.click();
}
public void sucessmessage() {

	String msg= sucessmessage.getText();
	Assert.assertEquals(msg, "My Account");

}
public void errormessage() {
	String errormsg=errormessage.getText();
	Assert.assertEquals(errormsg, "Warning: No match for E-Mail Address and/or Password.");
}
}
