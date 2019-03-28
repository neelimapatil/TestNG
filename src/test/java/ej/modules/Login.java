package ej.modules;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class Login extends Config {
	public static WebDriverWait objWaitDriver = null;
	final static Logger logger=Logger.getLogger(Login.class);
	
//TestNG DataProviders
	/*
	 * 
	 * When you need to pass complex parameters or parameters that need to be created from Java 
	 * (complex objects, objects read from a property file or a database, etc…), in such cases 
	 * parameters can be passed using Dataproviders
	 */
@DataProvider(name = "Authentication")
		 
	public static Object[][] credentials() {
		 
	return new Object[][] { { "dummyfm", "passw0rd" }, { "dummyrm", "passw0rd" }
	};
	}
@DataProvider(name = "Authentication1")

public static String[] credentials1() {
	 
return new String[] {"FF32"};
}
	@Test(groups = {"launch"}, dataProvider = "Authentication1")
	//@Parameters({"browsername"})
	//@When("^user opens the \"(.*)\" browser$")
	//(dataProvider = "Authentication1")
	public static void OpenBrowser(String strBrowserName) throws Exception
	{
		//String strBrowserName="FF32";
		try
		{
			if(strBrowserName.equalsIgnoreCase("FF32")){
				driver = new FirefoxDriver();
			}
			if(strBrowserName.equalsIgnoreCase("FF64")){
				driver = new FirefoxDriver();
			}
			objWaitDriver=new WebDriverWait(driver, 40);
			}
		catch(Exception e)
		{
					
		}
	}
//	@And("^user enters the url \"(.*)\"$")
	@Test(dependsOnMethods= "OpenBrowser",groups = {"launch"})
	@Parameters({"url"})
	public void EnterURL(String strUrl) throws Exception
	{
		try
		{
		driver.get(strUrl);
		WebElement To=driver.findElement(By.xpath("//div[contains(text(),'Login to SBDC')]"));
		String strValRead = To.getText();
		AssertJUnit.assertEquals("Login to SBDC", strValRead);
		}
		catch(Exception e)
		{
				System.out.println("Login application page is not displayed");
		}

	}
	@Test(groups = {"login"},dependsOnGroups = "launch")
	@Parameters({"username"})
	public void EnterUserName(String strUserName) throws Exception
	{
		Thread.sleep(2000);
		try
		{
		WebElement To=ExplicitWait.WaitForObjectExist("//input[@placeholder='Username']");
		To.sendKeys(strUserName);
		}
		catch(Exception e)
		{
		}
	}
	
	@Test
	(dataProvider = "Authentication")
	//@Parameters({"username","password"})
	public void EnterUserNamePassword(String strUserName, String strPassword) throws Exception
	{
		Thread.sleep(2000);
		try
		{
			Login objLogin = new Login();
			String strReadValue=objLogin.GetParameterValue_again("BROWSER_NAME", "parameter.properties");
			Login.OpenBrowser("FF32");
			strReadValue=objLogin.GetParameterValue_again("APPLICATION_URL", "parameter.properties");
			objLogin.EnterURL(strReadValue);
			WebElement To=ExplicitWait.WaitForObjectExist("//input[@placeholder='Username']");
			To.sendKeys(strUserName);
			Thread.sleep(2000);
			To=ExplicitWait.WaitForObjectExist("//input[@placeholder='Password']");
			To.sendKeys(strPassword);
	       	strReadValue=objLogin.GetParameterValue_again("OBJ_LOGIN_BUTTON", "OR.properties");
	    	To=ExplicitWait.WaitForObjectExist(strReadValue);
	    	To.click();
			To=ExplicitWait.WaitForObjectExist("//span[contains(text(),'Welcome')]");
			strReadValue=To.getText();
	//		Assert.assertTrue(strReadValue.contains(textmessage));
		}
		catch(Exception e)
		{
		}
	}
	//@And("^user enters \"(.*)\" as password$")
	@Test(groups = {"login"},dependsOnMethods= "EnterUserName",dependsOnGroups = "launch")
	@Parameters({"password"})
	public void EnterPassword(String strPassword) throws Exception
	{
		Thread.sleep(2000);
		try
		{
		WebElement To=ExplicitWait.WaitForObjectExist("//input[@placeholder='Password']");
		To.sendKeys(strPassword);
		}
		catch(Exception e)
		{
		}
	}
    //@And("^user clicks on Login button$")
	@Test(groups = {"login"},dependsOnMethods= "EnterPassword",dependsOnGroups = "launch")
	@Parameters({"textmessage"})
	public void ClickLoginButton(String textmessage) throws Exception
	{
    	Thread.sleep(2000);
    	try
    	{
        Login objLogin = new Login();
    	String strReadValue=objLogin.GetParameterValue_again("OBJ_LOGIN_BUTTON", "OR.properties");
    	WebElement To=ExplicitWait.WaitForObjectExist(strReadValue);
    	To.click();
		To=ExplicitWait.WaitForObjectExist("//span[contains(text(),'Welcome')]");
		strReadValue=To.getText();
		AssertJUnit.assertTrue(strReadValue.contains(textmessage));
		}
		catch(Exception e)
		{
		}
 	}
	
   // @And("^Close the Broswer$")
    
      public static void CloseBrowser() throws Exception
    {
    	Thread.sleep(5000);
    	driver.close();
    }
   
	public String GetParameterValue_again(String strParamterName, String strFileName) throws IOException
	{
		InputStream input=null;
		Properties objProp=new Properties();
		input=getClass().getClassLoader().getResourceAsStream(strFileName);
		objProp.load(input);
		String strParameterValue= objProp.getProperty(strParamterName);
		return strParameterValue;
	}
	
    public static void VerifyLogoutLink() throws Exception {
    	Thread.sleep(2000);
		try
		{
			WebElement objTemp=ExplicitWait.WaitForObjectExist("//a[contains(text(),'LOGOUT')]");
			String strVal = objTemp.getText();
			String strTemp = "LOGOUT";
			if (strVal.matches(strTemp))
			{
				System.out.println("User is successfully loged in");
			}
			else
			{
				System.out.println("User is unable to loged in");
			}
		}
		catch(Exception e)
		{
			System.out.println("User is unable to loged in");
		}
    }
    public static void VerifyLaunchApp(String strVal)
    {
    	String strExpectedMatchActual;
		try 
		{
			WebElement To=driver.findElement(By.xpath(strVal));
			String strValRead = To.getText();
			//String strTemp = strArray[3];
			System.out.println(strVal);
			if (strVal.matches(strValRead))
			{
				strExpectedMatchActual = "true";
			}
			else
			{
				strExpectedMatchActual = "false";
			}
		}
		catch(Exception e)
		{
			strExpectedMatchActual = "false";	
		}
	}
 /*   @BeforeMethod
	 
	public void beforeMethod() {
	 
	System.out.println("in beforeMethod");
	 
	}
	 
	@AfterMethod
	 
	public void afterMethod() {
	 
	System.out.println("in afterMethod");
	 
	} */
   /* @BeforeTest
	 
	public void beforeTest() {
	 
	System.out.println("in Login beforeTest");
	 
	}
	 
	@AfterTest
	 
	public void afterTest() {
	 
	System.out.println("in Login afterTest");
	 
	}*/
	public static void main(String[] args) throws Exception
	{
		Config.InitFlags();
		Login objLogin = new Login();
		String strReadValue=objLogin.GetParameterValue_again("BROWSER_NAME", "parameter.properties");
		Login.OpenBrowser("FF32");
		strReadValue=objLogin.GetParameterValue_again("APPLICATION_URL", "parameter.properties");
		objLogin.EnterURL(strReadValue);
	    strReadValue=objLogin.GetParameterValue_again("USERNAME", "parameter.properties");
	    String strReadValue1=objLogin.GetParameterValue_again("PASSWORD", "parameter.properties");
	   // objLogin.EnterUserNamePassword(strReadValue,strReadValue1,"Welcome");
		strReadValue=objLogin.GetParameterValue_again("OBJ_LOGIN_BUTTON", "OR.properties");
		objLogin.ClickLoginButton("Welcome");
	}
}

