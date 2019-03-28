package ej.modules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ExplicitWait {
	public static WebElement WaitForObjectExist(String strXpath)
	{
		return Login.objWaitDriver.until(ExpectedConditions.presenceOfElementLocated(By.xpath(strXpath)));
	}
}
