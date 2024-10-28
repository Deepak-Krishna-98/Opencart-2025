package testCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;






import org.testng.Assert;



import pageObjects.Homepage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass {
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class)
	public void verify_loginDDT(String email, String pwd, String exp) 
	{
		logger.info("***starting TC003_LoginDDT***");
		try 
		{
		Homepage hp=new Homepage(driver);
		
		hp.clickMyAccount();	
		hp.clickLogin();
		
		LoginPage lp=new LoginPage(driver);  
		lp.setEmail(email);
		lp.setPassword(pwd);
		lp.clickLogin();
		
		MyAccountPage myacc=new MyAccountPage(driver);
		boolean targetpage=myacc.IsMyAccPageExists();
	if(exp.equalsIgnoreCase("Valid"))
	{
		if(targetpage==true)
		{
			AssertJUnit.assertTrue(true);
			myacc.clickLogout();
		}
		else
		{
			AssertJUnit.assertTrue(false);
		}
		
	}
	if(exp.equalsIgnoreCase("Invalid"))
	{
		if(targetpage==true)
		{
			myacc.clickLogout();
			AssertJUnit.assertTrue(false);
		}
			
		else
		{
			AssertJUnit.assertTrue(true);
		}
	}
	
		}
		catch(Exception e)
		{
			AssertJUnit.fail();
		}
		logger.info("***Finishedd TC003_LoginDDT***");
	
	
	}
}
