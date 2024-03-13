package Melaleuca.mobileAutomation.Utils;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.appium.java_client.AppiumDriver;

public class Listeners extends AppiumUtils implements ITestListener {

	ExtentTest test;
	AppiumDriver driver;
	ExtentReports extentreport=ExtentReportsGenerate.config();
	@Override
	public void onTestStart(ITestResult result) {
		 test = extentreport.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test Passed");
//		try {
//			driver = (AppiumDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
//			test.addScreenCaptureFromPath(getScreenShotPath(result.getMethod().getMethodName(), driver), result.getMethod().getMethodName());
//		} catch (IOException | IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.fail(result.getThrowable());

		try { 
    		driver = (AppiumDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
		try {
		test.addScreenCaptureFromPath(getScreenShotPath(result.getMethod().getMethodName(),driver), result.getMethod().getMethodName());
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Skip of test cases and its details are : "+result.getName());  
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Failure of test cases and its details are : "+result.getName());  
	}

	@Override
	public void onFinish(ITestContext context) {
		extentreport.flush();
	}
	

}
