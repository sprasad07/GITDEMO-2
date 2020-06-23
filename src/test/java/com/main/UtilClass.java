package com.main;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class UtilClass extends Test123{
	ExtentReports extent;
	
	public static String Screenshot(String method) throws IOException
	{
		String filePath = System.getProperty("user.dir")+"\\Screenshots\\"+method+" "+CurrentDate()+".png";
		System.out.println(filePath);
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File(filePath));
		return filePath;
	}

	public static String CurrentDate()
	{
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy HH-mm-ss");
		
		return sdf.format(cal.getTime());
	}
	
	public ExtentReports ExtentReportGen()
	{
		ExtentSparkReporter reporter = new ExtentSparkReporter(System.getProperty("user.dir")+"//ExtentReports//reports.html");
		reporter.config().setDocumentTitle("Extent Report");
		reporter.config().setReportName("Automation Report");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		return extent;
	}
}
