package testCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;




import org.testng.Assert;
import pageObjects.AccountRegistrationPage;
import pageObjects.Homepage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {

	@Test (groups= {"Regression","Master"})
	public void verify_Account_Registration()
	{
		logger.info("***Starting TC001_AccountRegistrationTest*** ");
		try
		{
		
		Homepage hp=new Homepage(driver);
		
		hp.clickMyAccount();
		logger.info("Clicked on MyAccount Link");
		hp.clickRegister();
		
		logger.info("Clicked on Register Link");
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		
		logger.info("Providing customer details...");
		regpage.setFirstName(randomString().toUpperCase());
		regpage.setLastName(randomString().toUpperCase());
		regpage.setEmail(randomString()+"@gmail.com");
		regpage.setTelephone(randomnumber());
		
		String password=randomAlphanumberic();
		regpage.setPassword(password);
		regpage.setConformPassword(password);
		
		regpage.checkPrivacyPolicy();
		regpage.clickContinue();
		
		logger.info("Validating Expected Message...");
		String confmsg=regpage.getConfirmationMsg();
		if(confmsg.equals("Your Account Has Been Created!"))
	
		{
			AssertJUnit.assertTrue(true);
		}
		else {
			logger.error("Test Failed...");
			logger.debug("Debug logs...");
			AssertJUnit.assertTrue(false);
		}
		}
	catch(Exception e)
	{
		AssertJUnit.fail();
	}
	                                                                                                                        
		logger.info("*** finished test ***");
	
		
	}
}