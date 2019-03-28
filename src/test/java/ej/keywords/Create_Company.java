package ej.keywords;

import java.io.IOException;

import ej.modules.*;

public class Create_Company {
	
	public void CreateCompany() throws Exception
	{
	String strReadValue;
	ManageCompany objCom = new ManageCompany();
	Login objLogin = new Login();
	
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
	objCom.VerifyCompanyCreated();
}
}
