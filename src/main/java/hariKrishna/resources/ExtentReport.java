package hariKrishna.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {
	
	
	public static ExtentReports getReportObject() {
		ExtentSparkReporter reporter = new ExtentSparkReporter(System.getProperty("user.dir")+"\\reports\\index.html");
		reporter.config().setDocumentTitle("Ecommerce Reports");
		reporter.config().setReportName("Rahul Shetty Ecommerce");
		
		ExtentReports reports = new ExtentReports();
		reports.attachReporter(reporter);
		reports.setSystemInfo("Tester", "Hari Krishna");
		return reports;
	}
		
	

}
