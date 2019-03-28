package ej.keywords;

import ej.modules.Login;

public class LOGIN {
	
	public void LOGINAPP() throws Exception
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
	Login.VerifyLogoutLink();
	}
}
