package com.wipro.shopping1.pages;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Registerpage {
	WebDriver ldriver;
	public Registerpage(WebDriver rdriver){
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
	@FindBy(xpath="//*[@id='input-firstname']")
	@CacheLookup
	WebElement Firstname;
	@FindBy(xpath="//*[@id='input-lastname']")
	@CacheLookup
	WebElement Lastname;
	@FindBy(xpath="//*[@id='input-email']")
	@CacheLookup
	WebElement Email;
	@FindBy(xpath="//*[@id='input-telephone']")
	@CacheLookup
	WebElement Telephone;
	@FindBy(xpath="//*[@id='input-password']")
	@CacheLookup
	WebElement password;
	@FindBy(xpath="//*[@id='input-confirm']")
	@CacheLookup
	WebElement Confirm_Password;
	@FindBy(xpath="//*[@id=\"content\"]/form/fieldset[3]/div/div/label[1]/input")
	@CacheLookup
	WebElement Newsletter_yes;
	@FindBy(xpath="//*[@id=\"content\"]/form/fieldset[3]/div/div/label[2]/input")
	@CacheLookup
	WebElement Newsletter_No;
	@FindBy(xpath="//*[@name=\"agree\"]")
	@CacheLookup
	WebElement Terms_and_Conditions;
	@FindBy(xpath="//*[@class=\"pull-right\"]/input[2]")
	@CacheLookup
	WebElement Submit;
	
	public void Firstname(String firstname) {
		Firstname.sendKeys(firstname);
	}
	
	public void Lastname(String lastname) {
		Lastname.sendKeys(lastname);
	}
	public void Email(String email) {
		Email.sendKeys(email);
	}
	public void Telephone(String tele) {
		Telephone.sendKeys(tele);
	}
	public void password(String pass) {
		password.sendKeys(pass);
	}
	public void Confirm_Password(String confirm) {
		Confirm_Password.sendKeys(confirm);
	}
	public void Newsletter() {
//		Scanner scanner=new Scanner(System.in);
//		String input=scanner.nextLine();
//		if(input.equals(Newsletter_yes)) {
			Newsletter_yes.click();
//		}
//		else{
//			Newsletter_No.click();
//		}
		
	}
	public void Terms_and_Conditions() {
		Terms_and_Conditions.click();
	}
	public void Submit() {
		Submit.click();
	}
	
	
}
