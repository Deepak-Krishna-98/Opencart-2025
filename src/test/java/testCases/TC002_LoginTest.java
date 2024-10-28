package testCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
    


import org.testng.Assert;


import pageObjects.Homepage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {
	@Test(groups= {"Sanity", "Master"})
	public void verify_login()
	{
		logger.info("**** Starting TC002_LoginTest ***");	
	try
	{
	Homepage hp=new Homepage(driver);
	hp.clickMyAccount();
	hp.clickLogin();
	
	LoginPage lp=new LoginPage(driver);
	lp.setEmail(p.getProperty("email"));
	lp.setPassword(p.getProperty("password"));
	lp.clickLogin();
	
	MyAccountPage myacc=new MyAccountPage(driver);
	boolean targetpage=myacc.IsMyAccPageExists();
	
	AssertJUnit.assertTrue(targetpage);
	}
	catch(Exception e)
	{
		AssertJUnit.fail();
	}
	logger.info("*** Finished TC002_LoginTest ***");
}
	}