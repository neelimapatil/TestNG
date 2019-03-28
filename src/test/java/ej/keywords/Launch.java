package ej.keywords;
import ej.modules.*;

public class Launch {

	public void LaunchBrowser() throws Exception
	{
		Login.OpenBrowser("FF32");
		Login.VerifyLaunchApp("//div[contains(text(),'Login to SBDC')]");
	}
}
