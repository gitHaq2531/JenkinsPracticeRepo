/** @author afzaul */

package com.clientName.vtiger.ListenerUtility;

import java.time.LocalDateTime;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IRetryAnalyzer;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.client.vtiger.WebDriverUtility.UtilityClassObject;

public class ListenerImplementation implements ITestListener, ISuiteListener, IRetryAnalyzer
{
	public ExtentReports report;
	public ExtentTest test;
	
	@Override
	public void onStart(ISuite suite) {
		System.out.println("...........report configuration...........");
		String timeStamp=LocalDateTime.now().toString().replace(':', '-');
		//sparkReport config....
		ExtentSparkReporter spark=new ExtentSparkReporter("./advanceReport/VtigerReport"+timeStamp+".html");
		spark.config().setDocumentTitle("vtiget suit test results");
		spark.config().setReportName("vtiger report");
		spark.config().setTheme(Theme.DARK);
		
		// add env info & create test....
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "windows-10");
		report.setSystemInfo("Browser", "chrome-127");
		
	}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("..........report backup..........");
		report.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(".....====>"+result.getMethod().getMethodName()+" starts.........");
		test= report.createTest(result.getMethod().getMethodName());
		UtilityClassObject.setTest(test);
		test.log(Status.INFO, result.getMethod().getMethodName()+"==> started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println(".....====>"+result.getMethod().getMethodName()+" success......");
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		String testName=result.getMethod().getMethodName();
		test.log(Status.FAIL, testName+"====>test got failed....");

		TakesScreenshot ts=(TakesScreenshot)UtilityClassObject.getDriver();
		System.out.println("After taking ss");
		String filePath= ts.getScreenshotAs(OutputType.BASE64);
		String timeStamp=LocalDateTime.now().toString().replace(':', '-');
		test.addScreenCaptureFromBase64String(filePath, testName+"_"+timeStamp);
		test.log(Status.FAIL, testName+"===> failed");
		test.log(Status.FAIL, result.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("====skipped test cases====");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
	}

	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		return false;
	}


}
