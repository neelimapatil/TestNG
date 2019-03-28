package ej.modules;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import org.apache.log4j.RollingFileAppender;
import org.apache.log4j.SimpleLayout;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Config {
	public static WebDriver driver=null;
	public static String strOp=null;
	public static Logger logger=Logger.getLogger(Config.class);
	public static WebDriverWait objWaitDriver = null;
	public static int intMaxTimeOut = 60;
	public static String strReadValue=null;
	public static Integer intVar=null;
	public static String strResultFolder=null;
	public static boolean isLogEnabled;
	public static  boolean isCaptureScreenShotEnabled;
	public static int intStepCounter=0;
	public static String IS_SCREEN_CAPTURE_ENABLED=null;
	public static String IS_LOG_ENABLED=null;
	public static String MAX_TIMEOUT_IN_SECONDS=null;
	public static String ROOT_FOLDER_PATH=null;
	public static String TEST_SUITE_FOLDER=null;
	public static String TEST_CASE_FOLDER=null;
	public static String TESTDATA_LOCATION=null;
	public static String DB_NAME=null;
	public static String PORT_NUMBER=null;
	public static String DB_USERNAME=null;
	public static String DB_PASSWORD=null;
	public static boolean InitStarted = false;
	public static String strScreenShotFolderPath=null;
	public static String strReportFolderPath=null;
	public static String strScreenShotFileName=null;
	public static String testDataResourcePath=null;
	

	public static void SetLogPath() throws IOException
	{
		SimpleLayout layout = new SimpleLayout(); 
		RollingFileAppender appender = new RollingFileAppender(layout,"E:/log4j-application.log",true);
		logger.addAppender(appender);
		logger.setLevel((Level) Level.DEBUG);
	}
	
    // setting up a FileAppender dynamically...

	
/*	public void LoggingOnOff(boolean isLogEnabled,boolean isCaptureScreenShotEnabled,String RootFolderPath)
	{
		if(isLogEnabled==false)
		{
		  //  Logger.getRootLogger().setLevel(org.apache.log4j.Level.OFF);
		    Logger.getRootLogger().setLevel(Level.OFF);
		}

	}*/
	public String GetParameterValue(String strParamterName) throws IOException
	{
		InputStream input=null;
		Properties objProp=new Properties();
		input=getClass().getClassLoader().getResourceAsStream("config.properties");
		objProp.load(input);
		String strParameterValue= objProp.getProperty(strParamterName);
		return strParameterValue;
	}
	public static void InitFlags() throws IOException {
		Config objConfig=new Config();
		strReadValue=objConfig.GetParameterValue("IS_SCREEN_CAPTURE_ENABLED");
		if(strReadValue.equalsIgnoreCase("Yes"))
		{
			isCaptureScreenShotEnabled = true;
		}
		
		if(strReadValue.equalsIgnoreCase("true"))
		{
			isCaptureScreenShotEnabled = true;
		}
		if(strReadValue.equalsIgnoreCase("No"))
		{
			isCaptureScreenShotEnabled = false;
		}
		if(strReadValue.equalsIgnoreCase("false"))
		{
			isCaptureScreenShotEnabled = false;
		}
		strReadValue=objConfig.GetParameterValue("IS_LOG_ENABLED");
		if(strReadValue.equalsIgnoreCase("Yes"))
		{
			isLogEnabled = true;
		}
		
		if(strReadValue.equalsIgnoreCase("true"))
		{
			isLogEnabled = true;
		}
		if(strReadValue.equalsIgnoreCase("No"))
		{
			isLogEnabled = false;
		}
		if(strReadValue.equalsIgnoreCase("false"))
		{
			isLogEnabled = false;
		}
		if(isLogEnabled==false)
			{
			//  Logger.getRootLogger().setLevel(org.apache.log4j.Level.OFF);
				 Logger.getRootLogger().setLevel(Level.OFF);
			}
		else
		{
			Logger.getRootLogger().setLevel(Level.ALL);
		}
		ROOT_FOLDER_PATH=objConfig.GetParameterValue("ROOT_FOLDER_PATH");
		MAX_TIMEOUT_IN_SECONDS=objConfig.GetParameterValue("MAX_TIMEOUT_IN_SECONDS");
		TEST_SUITE_FOLDER=objConfig.GetParameterValue("TEST_SUITE_FOLDER");
		TEST_CASE_FOLDER=objConfig.GetParameterValue("TEST_CASE_FOLDER");
		TESTDATA_LOCATION=objConfig.GetParameterValue("TESTDATA_LOCATION");
		DB_NAME=objConfig.GetParameterValue("DB_NAME");
		PORT_NUMBER=objConfig.GetParameterValue("PORT_NUMBER");
		DB_USERNAME=objConfig.GetParameterValue("DB_USERNAME");
		PORT_NUMBER=objConfig.GetParameterValue("DB_PASSWORD");
		testDataResourcePath = objConfig.GetParameterValue("testDataResourcePath");
	}
	
	
	public static void CaptureScreenshot(String strRootFolderPath,String strMethodName) throws IOException
	{
		// Take screenshot and store as a file format
		//File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//TakesScreenshot is an interface
		TakesScreenshot ts = (TakesScreenshot) driver;
		 
		File src = ts.getScreenshotAs(OutputType.FILE);
			//return newFileNamePath;
		
		String filename =  new SimpleDateFormat("yyyyMMddhhmmss'.png'").format(new Date());
		File Dest = new File(strRootFolderPath+strMethodName+filename);
					 // now copy the  screenshot to desired location using copyFile //method			
		FileUtils.copyFile(src, Dest);
		//String strPath = Dest.getPath();
		strScreenShotFileName=Dest.getPath();
	}

}
