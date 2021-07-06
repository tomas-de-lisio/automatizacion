package com.cg.evaluacionCG.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reports {
	static ExtentSparkReporter reporter = new ExtentSparkReporter("reports/report.html");
	static ExtentReports extent = new ExtentReports();
	static ExtentTest logger = extent.createTest("Test");

	public static void log(String test) {
		Reports.logger.log(Status.INFO, test);
	}

	public static void logPass() {
		Reports.logger.log(Status.PASS, "Successful test.");
	}

	public static void logFail() {
		Reports.logger.log(Status.FAIL, "Fail test.");
	}

	public static void attach() {
		Reports.extent.attachReporter(reporter);
	}

	public static void flush() {
		Reports.extent.flush();
	}

	public static void finish() {
		Reports.attach();
		Reports.flush();
	}

}
