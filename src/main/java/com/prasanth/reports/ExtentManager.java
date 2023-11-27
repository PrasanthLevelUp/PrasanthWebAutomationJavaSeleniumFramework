package com.prasanth.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.prasanth.utils.TestUtils;

public class ExtentManager {
    private static ExtentReports extent;

    public static ExtentReports createInstance() {
        String reportPath = "test-output/"+ TestUtils.getCurrentMilliseconds()+".html";
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(reportPath);
        htmlReporter.config().setDocumentTitle("Prasanth TestFramework");
        htmlReporter.config().setReportName("OrangeHRM Suite Report");

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        return extent;
    }
}
