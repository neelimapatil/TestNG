package ej.modules;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.ie.InternetExplorerDriver;

import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;

import org.testng.annotations.Parameters;

import org.testng.annotations.Test;

public class MultiBrowser {

	public WebDriver driver;

	  @Parameters("browser")

	  @BeforeClass

	  // Passing Browser parameter from TestNG xml

	  public void beforeTest(String browser) {

	  // If the browser is Firefox, then do this

	  if(browser.equalsIgnoreCase("firefox")) {

		  driver = new FirefoxDriver();

	  // If browser is IE, then do this	  

	  }else if (browser.equalsIgnoreCase("ie")) { 

		  // Here I am setting up the path for my IEDriver

		  System.setProperty("webdriver.ie.driver", "E:\\selenium\\DRIVERS\\IEDriverServer_32bit_OS_worked_for_IE8-9-10-11.exe");

		  driver = new InternetExplorerDriver();
	  } 

	  // Doesn't the browser type, lauch the Website

	  driver.get("http://localhost:90/finsys"); 

	  }

	  // Once Before method is completed, Test method will start

	  @Test public void login() throws InterruptedException {

		 	driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("dummyfm");
	        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("passw0rd");
	        driver.findElement(By.xpath("//a[@onclick='return ValidateLogin()']")).click();
		}  

	  @AfterClass public void afterTest() {

			driver.quit();

		}

	}

