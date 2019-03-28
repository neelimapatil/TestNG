package ej.modules;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

import org.testng.annotations.DataProvider;

import utility.ExcelUtils;

public class DataProviderWithExcel_001 {

		 WebDriver driver;
	 
	     @BeforeMethod
	 
	     public void beforeMethod() throws Exception {
	 
	    	 driver = new FirefoxDriver();
	         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	         driver.get("http://localhost:90/finsys"); 
	 }
	 
	 @Test(dataProvider="Authentication")
	 
	    public void Registration_data(String sUserName,String sPassword)throws  Exception{
		 	driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(sUserName);
	        System.out.println(sUserName);
	        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(sPassword);
	        System.out.println(sPassword);
	        driver.findElement(By.xpath("//a[@onclick='return ValidateLogin()']")).click();
	        System.out.println(" Login Successfully, now it is the time to Log Off buddy.");
	  //      driver.findElement(By.xpath(".//*[@id='account_logout']/a")).click();
	 	 }
	 
	    @DataProvider
	 
	    public Object[][] Authentication() throws Exception{
	 
	         Object[][] testObjArray = ExcelUtils.getTableArray("E://selenium//Workspace//WS_TestNG//TestNG//src//test//java//testData//TestData.xlsx","Sheet1",1);
	 
	         return (testObjArray);
		 }
	 
	    @AfterMethod
	 
	    public void afterMethod() {
	 
	  	    driver.close();
	 
	     }
	 
}
