package com.OrangeHRM.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="username")
	WebElement txtUsername;
	
	@FindBy(name="password")
	WebElement txtPassword;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement btnLogin;
	
	@FindBy(xpath="//div[@class='orangehrm-login-forgot']")
	WebElement lnkForgotPassword;
	
	public boolean forgotYourPasswordEle() {
		boolean status = lnkForgotPassword.isDisplayed();
		return status;
	}
	
	public void enterUsername(String val) {
		txtUsername.clear();
		txtUsername.sendKeys(val);
		String valEntered = txtUsername.getAttribute("value");
		System.out.println("Value entered in Username field is - " + valEntered);
	}
	
	public void enterPassword(String val) {
		txtPassword.clear();
		txtPassword.sendKeys(val);
		String valEntered = txtPassword.getAttribute("value");
		System.out.println("Value entered in Password field is - " + valEntered);
	}
	
	public void clickLoginButton() {
		btnLogin.click();
		System.out.println("Clicked on Login button");
	}
	
	

}
