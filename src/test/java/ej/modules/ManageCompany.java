package ej.modules;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.util.Random;
import java.util.UUID;

import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Test;


public class ManageCompany extends Config{
	
	String strCompanyCreated;
	
	
	//clicks on financial analysis link
	public void ClickonFinAnaLink() throws IOException, InterruptedException
	{
		Thread.sleep(4000);
		try
		{
		// String strReadValue=objLogin.GetParameterValue_again("OBJ_FINANCIAL_ANALYSIS_LINK", "OR.properties");
			WebElement objLink=driver.findElement(By.xpath("//div[contains(text(),'Financial Analysis')]/parent::div"));
			String strVar = objLink.getAttribute("class");
			System.out.println(strVar);
			if (strVar.contains("selected"))
			{
				;
			}	
			else
			{
				objLink=ExplicitWait.WaitForObjectExist("//div[contains(text(),'Financial Analysis')]/following-sibling::div"); //("//div[contains(text(),'Financial Analysis')]/following-sibling::div");
				objLink.click();
			}
		}
		catch(Exception e)
		{
 		}
		
	}
		
	//clicks on company
	public void ClickonCompanyLink() throws IOException
	{
		
		Login objLogin = new Login();
	    
	    try
		{
	    	String strReadValue=objLogin.GetParameterValue_again("OBJ_COMPANY_LINK", "OR.properties");
	    	WebElement objLink=ExplicitWait.WaitForObjectExist(strReadValue);
	    	String strVar = objLink.getAttribute("class");
	    	System.out.println(strVar);
	    	if (strVar.contains("expanded"))
	    	{
	    		;
	    	}	
	    	else
	    	{
	    		objLink=ExplicitWait.WaitForObjectExist(strReadValue);//("//*[@id='_easyui_tree_1']//child::span[1]");
	    		objLink.click();
	    	}
		}
		catch(Exception e)
		{
		}
		
	}
		
	//clicks on manage company
	public void ClickonManageCompanyLink() throws IOException
	{
		Login objLogin = new Login();
		try
		{
			String strReadValue=objLogin.GetParameterValue_again("OBJ_MANAGE_COMPANY_LINK", "OR.properties");
			WebElement objLink=Login.driver.findElement(By.xpath(strReadValue));
			objLink.click();
		}
		catch(Exception e)
		{
		}
	}
		 //When user clicks on New button
	public void ClickonNewButton() throws InterruptedException, IOException
	{
		Login objLogin = new Login();

		try
		{
			String strReadValue=objLogin.GetParameterValue_again("OBJ_NEW_BUTTON", "OR.properties");
			Thread.sleep(2000);
			Login.driver.switchTo().frame(0);
			WebElement objLink=Login.driver.findElement(By.xpath(strReadValue));
			objLink.click();
		}
		catch(Exception e)
		{
		}
	}
	
	//And User enters Company name as "Neelima"
	public void EnterComName(String strName) throws IOException, InterruptedException
	{
		Thread.sleep(2000);
		Login objLogin = new Login();
		
	   /* String strReadValue=objLogin.GetParameterValue_again("OBJ_COMPANY_NAME", "OR.properties");
	    WebElement objLink=Login.driver.findElement(By.xpath(strReadValue));
	    strReadValue=objLogin.GetParameterValue_again("COMPANY_NAME", "parameter.properties");
		//("//td[contains(text(), 'Company Name')]/following-sibling::td[1]//child::input");
		objLink.sendKeys(strName);*/

		try
		{
			UUID uuid = UUID.randomUUID();
			String uniqueID = uuid.toString();
			String strReadValue=objLogin.GetParameterValue_again("OBJ_COMPANY_NAME", "OR.properties");
			WebElement objLink=Login.driver.findElement(By.xpath(strReadValue));
		//WebElement objLink=ExplicitWait.WaitForObjectExist(OBJ_COMPANY_NAME);
			objLink.sendKeys(uniqueID);
			strCompanyCreated = uniqueID;

		}
		catch(Exception e)
		{
		}
	}
	//And User selects Company type as "IT"
	public void SelectComType(String strName) throws IOException
	{
		Login objLogin = new Login();
		
		try
		{
			String strReadValue=objLogin.GetParameterValue_again("OBJ_COMPANY_TYPE", "OR.properties");
			WebElement objDropDown=Login.driver.findElement(By.xpath(strReadValue));//("//select[@id='companytype']");
			Select objDashBoard = new Select(objDropDown);
			strReadValue=objLogin.GetParameterValue_again("COMPANY_TYPE", "parameter.properties");
			objDashBoard.selectByVisibleText(strName);
		}
		catch(Exception e)
		{

		}
	}
	//And User Company Subtype as "Support"
	public void SelectCComSubType(String strName) throws IOException, InterruptedException
	{
		Login objLogin = new Login();
		Thread.sleep(2000);
		try
		{
			String strReadValue=objLogin.GetParameterValue_again("OBJ_COMPANY_SUBTYPE", "OR.properties");
			WebElement objDropDown=Login.driver.findElement(By.xpath(strReadValue));//("//select[@name='subtype']");
			Select objDashBoard = new Select(objDropDown);
			strReadValue=objLogin.GetParameterValue_again("COMPANY_SUBTYPE", "parameter.properties");
			objDashBoard.selectByVisibleText(strName);
		}
		catch(Exception e)
		{
		}
	}	
	
	//And User enters Address as "Pune"
	public void EnterAddress(String strName) throws IOException
	{
		Login objLogin = new Login();
		try
		{
			String strReadValue=objLogin.GetParameterValue_again("OBJ_COMPANY_ADDRESS", "OR.properties");
			WebElement objLink=Login.driver.findElement(By.xpath(strReadValue));
		//("//input[@textboxname='address']//following-sibling::span[1]//child::textarea");
			strReadValue=objLogin.GetParameterValue_again("COMPANY_ADDRESS", "parameter.properties");
			objLink.sendKeys(strName);
		}
		catch(Exception e)
		{
		}
	}
	//And User enters Phone as "0123456789"
	public void EnterPhone(String strName) throws IOException
	{
		Login objLogin = new Login();
		try
		{
		String strReadValue=objLogin.GetParameterValue_again("OBJ_COMPANY_PHONE", "OR.properties");
		WebElement objLink=Login.driver.findElement(By.xpath(strReadValue));//("//input[@textboxname='phone']//following-sibling::span[1]//child::input");
		strReadValue=objLogin.GetParameterValue_again("COMPANY_PHONE", "parameter.properties");
		objLink.sendKeys(strName);
		}
		catch(Exception e)
		{
		}	
	}
	//And User enters Email as "abcdef@gmail.com"
	public void EnterEmail(String strName) throws IOException
	{
		/*Login objLogin = new Login();
		String strReadValue=objLogin.GetParameterValue_again("OBJ_COMPANY_EMAIL", "OR.properties");
		WebElement objLink=Login.driver.findElement(By.xpath(strReadValue));//("//input[@name='email']");
		strReadValue=objLogin.GetParameterValue_again("COMPANY_EMAIL", "parameter.properties");
		objLink.sendKeys(strName);	*/
		try
		{
		String random = String.valueOf(3 < 1 ? 0 : new Random().nextInt((9 * (int) Math.pow(10, 3 - 1)) - 1)
	            + (int) Math.pow(10, 3 - 1));
		String email = "username" + random + "@mail.com";
		Login objLogin = new Login();
		String strReadValue=objLogin.GetParameterValue_again("OBJ_COMPANY_EMAIL", "OR.properties");
		WebElement objLink=Login.driver.findElement(By.xpath(strReadValue));//("//input[@name='email']");
		objLink.sendKeys(email);
		}
		catch(Exception e)
		{
		}	

	}
	//And User enters Pan Details as "ARPPT3211265498"
	public void EnterPan(String strName) throws IOException, InterruptedException
	{
		Thread.sleep(1000);
		Login objLogin = new Login();
		try
		{
		String strReadValue=objLogin.GetParameterValue_again("OBJ_COMPANY_PAN", "OR.properties");
		WebElement objLink=Login.driver.findElement(By.xpath(strReadValue));//("//input[@name='pan']");
		strReadValue=objLogin.GetParameterValue_again("COMPANY_PAN", "parameter.properties");
		objLink.sendKeys(strName);	
		}
		catch(Exception e)
		{
		}	
	}
	//And User enters Tin details as "32165432165487"
	public void EnterTin(String strName) throws IOException, InterruptedException
	{
		Thread.sleep(1000);
		Login objLogin = new Login();
		try
		{
		String strReadValue=objLogin.GetParameterValue_again("OBJ_COMPANY_TIN", "OR.properties");
		WebElement objLink=Login.driver.findElement(By.xpath(strReadValue));//("//input[@name='tin']");
		strReadValue=objLogin.GetParameterValue_again("COMPANY_TIN", "parameter.properties");
		objLink.sendKeys(strName);

	}
		catch(Exception e)
		{

		}	
	}
	//And User enters Mobile Details as "8765567890"
	public void EnterMobile(String strName) throws IOException, InterruptedException
	{
		Thread.sleep(1000);
		Login objLogin = new Login();
		try
		{
		String strReadValue=objLogin.GetParameterValue_again("OBJ_COMPANY_MOBILE", "OR.properties");
		WebElement objLink=Login.driver.findElement(By.xpath(strReadValue));//("//input[@textboxname='mobile']//following-sibling::span[1]//child::input");
		 strReadValue=objLogin.GetParameterValue_again("COMPANY_MOBILE", "parameter.properties");
		objLink.sendKeys(strName);
		}
		catch(Exception e)
		{

		}
	}
	
	//And User enters Website details as "testingt.com"
	public void EnterWebsite(String strName) throws IOException, InterruptedException
	{
		Thread.sleep(1000);
		Login objLogin = new Login();
		try
		{
		String strReadValue=objLogin.GetParameterValue_again("OBJ_COMPANY_WEBSITE", "OR.properties");
	    WebElement objLink=Login.driver.findElement(By.xpath(strReadValue));//("//input[@name='website']");
		strReadValue=objLogin.GetParameterValue_again("COMPANY_WEBSITE", "parameter.properties");
		objLink.sendKeys(strName);
	}
		catch(Exception e)
		{
		}
	}

	//And User enters Country as "INDIA"
	public void SelectCountry(String strName) throws IOException, InterruptedException
	{
		Thread.sleep(2000);
		Login objLogin = new Login();
		try
		{
		String strReadValue=objLogin.GetParameterValue_again("OBJ_COUNTRY", "OR.properties");
	    WebElement objDropDown=Login.driver.findElement(By.xpath(strReadValue));//("//select[@name='countryname']");
		Select objDashBoard = new Select(objDropDown);
		strReadValue=objLogin.GetParameterValue_again("COUNTRY", "parameter.properties");
		objDashBoard.selectByVisibleText(strReadValue);
	}
		catch(Exception e)
		{
		}
	}

	//And User enters State as "MAHARASHTRA"
	public void SelectState(String strName) throws IOException, InterruptedException
	{
		Thread.sleep(2000);
		Login objLogin = new Login();
		try
		{
		String strReadValue=objLogin.GetParameterValue_again("OBJ_STATE", "OR.properties");
	    WebElement objDropDown=Login.driver.findElement(By.xpath(strReadValue));//("//select[@name='state']");
		Select objDashBoard = new Select(objDropDown);
		strReadValue=objLogin.GetParameterValue_again("STATE", "parameter.properties");
		objDashBoard.selectByVisibleText(strName);
		}
		catch(Exception e)
		{
		}
	}
	
	public void SelectCity(String strName) throws IOException, InterruptedException
	{
		Thread.sleep(1000);
		Login objLogin = new Login();
		try
		{
		String strReadValue=objLogin.GetParameterValue_again("OBJ_CITY", "OR.properties");
	    WebElement objDropDown=Login.driver.findElement(By.xpath(strReadValue));//("//select[@name='city']");
		Select objDashBoard = new Select(objDropDown);
		strReadValue=objLogin.GetParameterValue_again("CITY", "parameter.properties");
		objDashBoard.selectByVisibleText(strName);
	}
		catch(Exception e)
		{
		}
	}
	
	//And User enters Total Employee as "1"
	public void EnterTotalEmp(String strName) throws IOException, InterruptedException
	{
		Thread.sleep(1000);
		Login objLogin = new Login();
		try
		{
		String strReadValue=objLogin.GetParameterValue_again("OBJ_TOTAL_EMPLOYEE", "OR.properties");
	    WebElement objLink=Login.driver.findElement(By.xpath(strReadValue));//("//input[@textboxname='totalemployee']//following-sibling::span[1]//child::input");
		strReadValue=objLogin.GetParameterValue_again("TOTAL_EMPLOYEE", "parameter.properties");
		objLink.sendKeys(strReadValue);
		}
		catch(Exception e)
		{
		}
	}

	//And User clicks on Save button
	public void ClickOnSaveButton() throws IOException
	{
		Login objLogin = new Login();
		try
		{
	    String strReadValue=objLogin.GetParameterValue_again("OBJ_SAVE_BUTTON", "OR.properties");
		WebElement objButton=Login.driver.findElement(By.xpath(strReadValue));
		objButton.click();
		Thread.sleep(4000);
		WebElement objTable=Login.driver.findElement(By.xpath(".//*[@id='datagrid-row-r1-2-0']/td[1]/div"));
		String strTableData=objTable.getText();
		AssertJUnit.assertTrue(strCompanyCreated.contains(strTableData));
		//Assert.assertEquals(strCompanyCreated, strTableData);
		}
		catch(Exception e)
		{
		}
	}
	
	public void VerifyCompanyCreated() throws Exception
	{
		Thread.sleep(4000);
		String strExpectedMatchActual;
		String objStr=driver.findElement(By.xpath("//div[contains(text(), 'Neelima')]")).getText();
		if (objStr.equals("Neelima"))
		{
			strExpectedMatchActual = "true";
			System.out.println("Company is created");
		}
		else
		{
			strExpectedMatchActual = "false";
			System.out.println("Company is not created");
		}
	}
	@Test
	public void createNewCo() throws Exception
	{
		Login objLogin = new Login();
		ManageCompany objCom = new ManageCompany();
		Thread.sleep(2000);	
		
		strReadValue=objLogin.GetParameterValue_again("OBJ_FINANCIAL_ANALYSIS_LINK", "OR.properties");
		objCom.ClickonFinAnaLink();
		
		strReadValue=objLogin.GetParameterValue_again("OBJ_COMPANY_LINK", "OR.properties");
		objCom.ClickonCompanyLink();
		
		strReadValue=objLogin.GetParameterValue_again("OBJ_MANAGE_COMPANY_LINK", "OR.properties");
		objCom.ClickonManageCompanyLink();
		
		strReadValue=objLogin.GetParameterValue_again("OBJ_NEW_BUTTON", "OR.properties");
		objCom.ClickonNewButton();
		objCom.EnterComName("Neelima");
		strReadValue=objLogin.GetParameterValue_again("COMPANY_TYPE", "parameter.properties");
		objCom.SelectComType(strReadValue);
		strReadValue=objLogin.GetParameterValue_again("COMPANY_SUBTYPE", "parameter.properties");
		objCom.SelectCComSubType(strReadValue);
		strReadValue=objLogin.GetParameterValue_again("COMPANY_ADDRESS", "parameter.properties");
		objCom.EnterAddress(strReadValue);
		strReadValue=objLogin.GetParameterValue_again("COMPANY_PHONE", "parameter.properties");
		objCom.EnterPhone(strReadValue);
		strReadValue=objLogin.GetParameterValue_again("COMPANY_EMAIL", "parameter.properties");
		objCom.EnterEmail(strReadValue);
		strReadValue=objLogin.GetParameterValue_again("COMPANY_PAN", "parameter.properties");
		objCom.EnterPan(strReadValue);
		strReadValue=objLogin.GetParameterValue_again("COMPANY_TIN", "parameter.properties");
		objCom.EnterTin(strReadValue);
		strReadValue=objLogin.GetParameterValue_again("COMPANY_MOBILE", "parameter.properties");
		objCom.EnterMobile(strReadValue);
		strReadValue=objLogin.GetParameterValue_again("COMPANY_WEBSITE", "parameter.properties");
		objCom.EnterWebsite(strReadValue);
		strReadValue=objLogin.GetParameterValue_again("COUNTRY", "parameter.properties");
		objCom.SelectCountry(strReadValue);
		strReadValue=objLogin.GetParameterValue_again("STATE", "parameter.properties");
		objCom.SelectState(strReadValue);
		strReadValue=objLogin.GetParameterValue_again("CITY", "parameter.properties");
		objCom.SelectCity(strReadValue);
		strReadValue=objLogin.GetParameterValue_again("TOTAL_EMPLOYEE", "parameter.properties");
		objCom.EnterTotalEmp(strReadValue);
		strReadValue=objLogin.GetParameterValue_again("OBJ_SAVE_BUTTON", "parameter.properties");
		objCom.ClickOnSaveButton();
		}
	@BeforeMethod
	 
	public void beforeMethod() {
	 
	System.out.println("in beforeMethod");
	 
	}
	 
	@AfterMethod
	 
	public void afterMethod() {
	 
	System.out.println("in afterMethod");
	 
	}
	 
	@BeforeClass
	 
	public void beforeClass() {
	 
	System.out.println("in beforeClass");
	 
	}
	 
	@AfterClass
	 
	public void afterClass() {
	 
	System.out.println("in afterClass");
	 
	}
	 
	@BeforeTest
	 
	public void beforeTest() {
	 
	System.out.println("in beforeTest");
	 
	}
	 
	@AfterTest
	 
	public void afterTest() {
	 
	System.out.println("in afterTest");
	 
	}
	 
	@BeforeSuite
	 
	public void beforeSuite() {
	 
	System.out.println("in beforeSuite");
	}
	 
	@AfterSuite
	 
	public void afterSuite() {
	System.out.println("in afterSuite");
	}
	@Test
	public void deleteCompany() throws Exception
	{
	/*Login objLogin = new Login();
	ManageCompany objCom = new ManageCompany();
	Thread.sleep(2000);	
	
	strReadValue=objLogin.GetParameterValue_again("OBJ_FINANCIAL_ANALYSIS_LINK", "OR.properties");
	objCom.ClickonFinAnaLink();
	
	strReadValue=objLogin.GetParameterValue_again("OBJ_COMPANY_LINK", "OR.properties");
	objCom.ClickonCompanyLink();
	
	strReadValue=objLogin.GetParameterValue_again("OBJ_MANAGE_COMPANY_LINK", "OR.properties");
	objCom.ClickonManageCompanyLink();
	Login.driver.switchTo().frame(0);*/
	WebElement objTable=Login.driver.findElement(By.xpath(".//*[@id='datagrid-row-r1-2-0']/td[1]/div"));
	objTable.click();
	WebElement objButton=Login.driver.findElement(By.xpath("//span[contains(text(), 'Destroy')]"));
	objButton.click();
	objButton=Login.driver.findElement(By.xpath("//span[contains(text(), 'Ok')]"));
	objButton.click();
	}
	}
/*	public static void main(String[] args) throws Exception
	{
		Login objLogin = new Login();
		String strReadValue=objLogin.GetParameterValue_again("BROWSER_NAME", "parameter.properties");
		Login.OpenBrowser(strReadValue);
		strReadValue=objLogin.GetParameterValue_again("APPLICATION_URL", "parameter.properties");
		objLogin.EnterURL(strReadValue);
	    strReadValue=objLogin.GetParameterValue_again("USERNAME", "parameter.properties");
		objLogin.EnterUserName(strReadValue);
	    strReadValue=objLogin.GetParameterValue_again("PASSWORD", "parameter.properties");
		objLogin.EnterPassword(strReadValue);
		strReadValue=objLogin.GetParameterValue_again("OBJ_LOGIN_BUTTON", "OR.properties");
		objLogin.ClickLoginButton("Welcome");
		ManageCompany objCom = new ManageCompany();
		
		Thread.sleep(2000);		
		strReadValue=objLogin.GetParameterValue_again("OBJ_FINANCIAL_ANALYSIS_LINK", "OR.properties");
		objCom.ClickonFinAnaLink();
		
		strReadValue=objLogin.GetParameterValue_again("OBJ_COMPANY_LINK", "OR.properties");
		objCom.ClickonCompanyLink();
		
		strReadValue=objLogin.GetParameterValue_again("OBJ_MANAGE_COMPANY_LINK", "OR.properties");
		objCom.ClickonManageCompanyLink();
		
		strReadValue=objLogin.GetParameterValue_again("OBJ_NEW_BUTTON", "OR.properties");
		objCom.ClickonNewButton();
		objCom.EnterComName("Neelima");
		strReadValue=objLogin.GetParameterValue_again("COMPANY_TYPE", "parameter.properties");
		objCom.SelectComType(strReadValue);
		strReadValue=objLogin.GetParameterValue_again("COMPANY_SUBTYPE", "parameter.properties");
		objCom.SelectCComSubType(strReadValue);
		strReadValue=objLogin.GetParameterValue_again("COMPANY_ADDRESS", "parameter.properties");
		objCom.EnterAddress(strReadValue);
		strReadValue=objLogin.GetParameterValue_again("COMPANY_PHONE", "parameter.properties");
		objCom.EnterPhone(strReadValue);
		strReadValue=objLogin.GetParameterValue_again("COMPANY_EMAIL", "parameter.properties");
		objCom.EnterEmail(strReadValue);
		strReadValue=objLogin.GetParameterValue_again("COMPANY_PAN", "parameter.properties");
		objCom.EnterPan(strReadValue);
		strReadValue=objLogin.GetParameterValue_again("COMPANY_TIN", "parameter.properties");
		objCom.EnterTin(strReadValue);
		strReadValue=objLogin.GetParameterValue_again("COMPANY_MOBILE", "parameter.properties");
		objCom.EnterMobile(strReadValue);
		strReadValue=objLogin.GetParameterValue_again("COMPANY_WEBSITE", "parameter.properties");
		objCom.EnterWebsite(strReadValue);
		strReadValue=objLogin.GetParameterValue_again("COUNTRY", "parameter.properties");
		objCom.SelectCountry(strReadValue);
		strReadValue=objLogin.GetParameterValue_again("STATE", "parameter.properties");
		objCom.SelectState(strReadValue);
		strReadValue=objLogin.GetParameterValue_again("CITY", "parameter.properties");
		objCom.SelectCity(strReadValue);
		strReadValue=objLogin.GetParameterValue_again("TOTAL_EMPLOYEE", "parameter.properties");
		objCom.EnterTotalEmp(strReadValue);
		strReadValue=objLogin.GetParameterValue_again("OBJ_SAVE_BUTTON", "parameter.properties");
		objCom.ClickOnSaveButton();
	}*/


