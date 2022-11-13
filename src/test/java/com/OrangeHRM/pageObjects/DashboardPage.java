package com.OrangeHRM.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
	public WebDriver driver;
	
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@class='oxd-topbar-header-breadcrumb']")
	WebElement lblTopDashboardText;
	
	public boolean topDashboardElement() {
		boolean status = lblTopDashboardText.isDisplayed();
		return status;
	}
}
