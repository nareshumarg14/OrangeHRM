package com.OrangeHRM.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.OrangeHRM.pageObjects.LoginPage;
import com.OrangeHRM.testBase.BaseClass;

public class TC002_VerifyForgotYourPasswordLink extends BaseClass {
	
	@Test
	public void forgotYourPasswordTest() throws IOException {
		LoginPage lp = new LoginPage(driver);
		boolean status = lp.forgotYourPasswordEle();
		capturescreen(driver, "TC002_VerifyForgotYourPasswordLink");
		
		Assert.assertEquals(status, true, "Forgot your Password? link is missing");
		//System.out.println("Forgot your Password? link is existing");
		logger.info("Forgot your Password? link is existing");
	}
}
