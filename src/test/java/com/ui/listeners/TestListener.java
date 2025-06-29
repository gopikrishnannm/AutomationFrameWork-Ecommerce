package com.ui.listeners;

import java.util.Arrays;

import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.ui.pages.TestBase;
import com.utility.BrowserUtility;
import com.utility.ExtentReportUtility;
import com.utility.LoggerUtility;

public class TestListener implements ITestListener {

	Logger logger = LoggerUtility.getLogger(this.getClass());

	ExtentSparkReporter extentSparkReporter;
	ExtentReports extentReports;
	ExtentTest extentTest;

	public void onTestStart(ITestResult result) {
		logger.info(result.getMethod().getMethodName());
		logger.info(result.getMethod().getDescription());
		logger.info(Arrays.toString(result.getMethod().getGroups()));
		ExtentReportUtility.createExtentTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		logger.info(result.getMethod().getMethodName() + " Passed");
		ExtentReportUtility.getTest().log(Status.PASS, result.getMethod().getMethodName());
	}

	public void onTestFailure(ITestResult result) {
		logger.info(result.getMethod().getMethodName() + " Failed");
		logger.info(result.getThrowable().getMessage());
		ExtentReportUtility.getTest().log(Status.FAIL, result.getMethod().getMethodName() + " Failed");
		ExtentReportUtility.getTest().log(Status.FAIL,result.getThrowable().getMessage());
		
		Object testClass = result.getInstance();
		BrowserUtility browserUtility = ((TestBase)testClass).getInstance();
		logger.info("Capturing screenshot from the failed tests");
		String screenshotPath = browserUtility.takeScreenshot(result.getMethod().getMethodName());
		ExtentReportUtility.getTest().addScreenCaptureFromPath(screenshotPath);
		logger.info("Attaching the screenshot to the html file");

	}

	public void onTestSkipped(ITestResult result) {
		logger.info(result.getMethod().getMethodName() + " Skipped");
		ExtentReportUtility.getTest().log(Status.SKIP, result.getMethod().getMethodName() + " Skipped");
	}

	public void onStart(ITestContext context) {
		logger.info("Test suite started");
		ExtentReportUtility.setupSparkReporter("report.html");
	}

	public void onFinish(ITestContext context) {
		logger.info("Test suite Completed");
		ExtentReportUtility.flushReport();
	}
}
