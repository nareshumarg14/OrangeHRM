package com.OrangeHRM.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.OrangeHRM.pageObjects.DashboardPage;
import com.OrangeHRM.pageObjects.LoginPage;
import com.OrangeHRM.testBase.BaseClass;

public class TC001_UserLoginTest extends BaseClass{
	
	@Test
	public void loginTest() throws IOException {
		LoginPage lp = new LoginPage(driver);		
		lp.enterUsername(prop.getProperty("username"));
		lp.enterPassword(prop.getProperty("password"));
		lp.clickLoginButton();
		
		capturescreen(driver, "TC001_UserLoginTest");
		
		DashboardPage dp = new DashboardPage(driver);
		boolean eleStatus = dp.topDashboardElement();
		Assert.assertEquals(eleStatus, true, "User did not logged in successfully");
		//System.out.println("User has logged in successfully");
		logger.info("User has logged in successfully");
		
	}
	
	

}
