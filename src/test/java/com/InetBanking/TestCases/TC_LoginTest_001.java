package com.InetBanking.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.InetBanking.PageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass
{

	@Test
	public void loginTest() throws InterruptedException, IOException  
	{
		
		logger.info("URL is opened");
		
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Entered UserName");
		
		lp.setPassword(password);
		logger.info("Entered Password");
		Thread.sleep(2000);
		
		
		lp.clickSubmit();
		
		Thread.sleep(2000);
		
		
		 if(driver.getTitle().equals("GTPL Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("Login test passed");
		}
		
		else
		{
			captureScreen(driver,"loginTest");
	        Assert.assertTrue(false);
			logger.info("Login test failed");
		}
		
		
		
	
	} 
}
