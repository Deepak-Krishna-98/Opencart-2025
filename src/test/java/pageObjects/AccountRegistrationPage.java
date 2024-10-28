package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {
 public AccountRegistrationPage(WebDriver driver)
 {
	 super(driver);
 }
	
 @FindBy(xpath="//input[@id='input-firstname']")WebElement txtFirstname;
@FindBy(xpath="//input[@id='input-lastname']") WebElement txtlastname;
@FindBy(xpath="//input[@id='input-email']") WebElement txteMail;
@FindBy(xpath="//input[@id='input-telephone']")  WebElement txttelephone;
@FindBy(xpath="//input[@id='input-password']")  WebElement txtpassword;
@FindBy(xpath="//input[@id='input-confirm']") WebElement txtpasswordConfirm;
@FindBy(xpath="//input[@name='agree']")  WebElement agree;
@FindBy(xpath="//input[@value='Continue']")  WebElement btncontinue;
@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")  WebElement msgConfirmation;


public void setFirstName(String fname)
{
	txtFirstname.sendKeys(fname);
}

public void setLastName(String lname)
{
	
	txtlastname.sendKeys(lname);
}

public void setEmail(String email)
{
	
	txteMail.sendKeys(email);
}
public void setTelephone(String tel)
{
	
	txttelephone.sendKeys(tel);
}

public void setPassword(String pwd)
{
	
	txtpassword.sendKeys(pwd);
}
public void setConformPassword(String pwd)
{
	
	txtpasswordConfirm.sendKeys(pwd);
}

public void checkPrivacyPolicy( )
{
	
	agree.click();
}
public void clickContinue( )
{
	
	btncontinue.click();
}

public String getConfirmationMsg() {
	try {
		return(msgConfirmation.getText());
	}catch(Exception e) {
		return(e.getMessage());
	}
	
}



}
