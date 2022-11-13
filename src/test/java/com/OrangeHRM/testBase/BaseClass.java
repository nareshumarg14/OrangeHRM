package com.OrangeHRM.testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public WebDriver driver;
	public Properties prop;
	public Logger logger = LogManager.getLogger(this.getClass());
	
	@BeforeMethod
	@Parameters("browsername")
	public void setup(String br) throws IOException {
		
		//Reading values from properties file.
		prop = new Properties();
		FileInputStream fis = new FileInputStream("D:\\Training\\Selenium\\ClassTraining_2022\\OrangeHRM\\resources\\config.properties");
		prop.load(fis);
		
		if (br.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			logger.info("Chrome Browser is launched successfully");
		} else if(br.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			logger.info("Edge Browser is launched successfully");
		}else if(br.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			logger.info("Firefox Browser is launched successfully");
		}else {
			logger.info("Supported browsers are chrome / edge / firefox");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		String appTitle = driver.getTitle();
		Assert.assertEquals(appTitle, "OrangeHRM","OrangeHRM application is not opened");
		//System.out.println("OrangeHRM application is opened");
		logger.info("OrangeHRM application is opened");
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
		//System.out.println("Application closed successfully");
		logger.info("Application closed successfully");
	}
	
	public void capturescreen(WebDriver driver, String testName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "\\screenshots\\"+ testName + ".png");
		FileUtils.copyFile(source, target);
		logger.info("Screenshot captured successfully");
	}
}
