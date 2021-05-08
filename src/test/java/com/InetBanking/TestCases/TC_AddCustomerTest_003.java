package com.InetBanking.TestCases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.InetBanking.PageObjects.AddCustomerPage;

import com.InetBanking.PageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass
{

	@Test
	public void addNewCustomer() throws IOException, InterruptedException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("User name is provided");
		lp.setPassword(password);
		logger.info("Password is provided");
		lp.clickSubmit();
		Thread.sleep(2000);
		
		Thread.sleep(3000);
		
		AddCustomerPage addcust=new AddCustomerPage(driver);
		
		addcust.clickAddNewCustomer();
		
		logger.info("providing customer details....");
		
		
		addcust.custName("rupesh");
		addcust.custgender("male");
		addcust.custdob("09","Jun","1991");
		Thread.sleep(5000);
		addcust.custaddress("INDIA");
		addcust.custcity("HYD");
		addcust.custstate("TS");
		addcust.custpinno("500060");
		addcust.custtelephoneno("987654321 ");
		Thread.sleep(3000);
		String email=randomstring()+"@gmail.com";
		addcust.custemailid(email);
		//addcust.custpassword("abcdef");
		Thread.sleep(3000);
		addcust.custsubmit();
		
		Thread.sleep(3000);
		
		logger.info("validation started....");
		
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("test case passed....");
			
		}
		else
		{
			logger.info("test case failed....");
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
		}
			
		
	}
	
	public String randomstring()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(8);
		return(generatedstring);
	}
	
	public static String randomNum()
	{
		String generatedstring2=RandomStringUtils.randomNumeric(6);
		return(generatedstring2);
	}
	
	
}

