package com.vtiger.generic.baseUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.client.vtiger.WebDriverUtility.UtilityClassObject;
import com.client.vtiger.WebDriverUtility.WebDriverUtils;
import com.client.vtiger.javaUtility.JavaUtils;
import com.client.vtiger.objectRepository.HomePage;
import com.client.vtiger.objectRepository.LoginPage;
import com.clientName.vtiger.databaseUtility.DatabaseUtility;
import com.clientName.vtiger.generic.fileUtility.FileUtility;

/** @author afzaul
  
  it contains configuration annotated methods like @beforeClass,@beforeSuite etc.
 */

public class BaseClass 
{
	public WebDriver driver=null;
	public WebDriverUtils wdu=new WebDriverUtils();
	public JavaUtils ju=new JavaUtils();
	public DatabaseUtility dbutil=new DatabaseUtility();
	public FileUtility futil=new FileUtility();
	
@BeforeSuite
public void configBaseSuit()
{
	System.out.println("===connect to database====");
	dbutil.getDbConnection();
}
//reading data from xml file...
@BeforeClass
public void configBaseClass() throws IOException {
	System.out.println("===execute baseclass===");
	System.out.println("launch browser here");
	String browser=System.getProperty("browser");
	System.out.println(browser);
	if(browser.equals("chrome")){
		driver=new ChromeDriver();
	}
	else if(browser.equals("edge")){
		driver=new EdgeDriver();
	}
	else if(browser.equals("firefox")){
		driver=new FirefoxDriver();
	}
	UtilityClassObject.setDriver(driver);
	wdu.maximizeWindow(driver);
	wdu.waitToLoadPage(driver);
}

@BeforeMethod
public void configBaseMethod() throws IOException {
	System.out.println("=====execute baseMethod====");
	System.out.println("login to app here");
	String url=futil.getDataFromProperties("url");
	String username=futil.getDataFromProperties("username");
	String password=futil.getDataFromProperties("password");
	LoginPage lp=new LoginPage(driver);
	driver.get(url);
	lp.loginToApp(username, password);
}
@AfterMethod
public void configAfterMethod() {
	System.out.println("===execute after Method here===");
	System.out.println("logout from app");
	HomePage hp= new  HomePage(driver);
	hp.getSignOutFromApp();
}
@AfterClass
public void configAfterClass() {
	System.out.println("===execute after class here===");
	System.out.println("close the browser here");
	driver.quit();
}
@AfterSuite(alwaysRun = true)
public void configAfterSuit() {
	System.out.println("===execute after suit===");
	System.out.println("close database connection");
	dbutil.closeConnection();
}
}
