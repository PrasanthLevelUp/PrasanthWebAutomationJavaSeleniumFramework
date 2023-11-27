package com.prasanth.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.prasanth.reports.ExtentManager;
import com.prasanth.tests.BaseTest;
import org.openqa.selenium.*;
import org.openqa.selenium.support.events.WebDriverListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class TestListener implements ITestListener, WebDriverListener {

    private static ExtentReports extent = ExtentManager.createInstance();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    public void onStart(ITestContext context) {
        System.out.println("Test Suite is starting: " + context.getName());
    }

    public void onFinish(ITestContext context) {
        System.out.println("Test Suite is ending: " + context.getName());
        extent.flush();
    }

    public void onTestStart(ITestResult result) {
        System.out.println("Test method is starting: " + result.getName());
        ExtentTest extentTest = extent.createTest(result.getName());
        test.set(extentTest);
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("Test method is successful: " + result.getName());
        test.get().log(Status.PASS, "Test Passed");
    }

    public void onTestFailure(ITestResult result) {
        System.out.println("Test method failed: " + result.getName());
        test.get().log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" Test Failed", ExtentColor.RED));
        test.get().fail(result.getThrowable());
        WebDriver driver = BaseTest.driver;
        TakesScreenshot screenshotDriver = (TakesScreenshot) driver;
        String screenshot = screenshotDriver.getScreenshotAs(OutputType.BASE64);
        test.get().fail(MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot).build());
//        test.get().addScreenCaptureFromBase64String(screenshot, result.getName());
    }

    public void onTestSkipped(ITestResult result) {
        System.out.println("Test method is skipped: " + result.getName());
        test.get().log(Status.SKIP, MarkupHelper.createLabel("Test Skipped", ExtentColor.YELLOW));
        test.get().skip(result.getThrowable());
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    public void onTestFailedWithTimeout(ITestResult result) {
        System.out.println("Test method failed due to timeout: " + result.getName());
    }

    public void onException(Throwable throwable, ITestResult result) {
        System.out.println("An exception occurred: " + throwable.getMessage());
    }

    private String takeScreenshot(WebDriver driver, String testName) {
        String screenshot = null;
        try {
            if (driver instanceof TakesScreenshot) {
                TakesScreenshot screenshotDriver = (TakesScreenshot) driver;
                screenshot = screenshotDriver.getScreenshotAs(OutputType.BASE64);
            }
        } catch (WebDriverException e) {
            System.out.println("Failed to take a screenshot: " + e.getMessage());
        }
        return screenshot;

    }

//    public void afterGet(WebDriver driver, String url) {
//        test.get().log(Status.PASS, "afterGet");
//    }

    public void afterFindElement(WebDriver driver, By locator, WebElement result) {
//        test.get().log(Status.PASS, "afterFindElement");
    }

    public void afterClose(WebDriver driver) {
//        test.get().log(Status.PASS, "afterFindElement");
    }

//    public void afterQuit(WebDriver driver) {
//        test.get().log(Status.PASS, "afterQuit");
//    }

    public void afterClick(WebElement element) {
        test.get().log(Status.PASS, "afterClick");
    }

    public void afterSubmit(WebElement element) {
        test.get().log(Status.PASS, "afterSubmit");
    }

    public void afterSendKeys(WebElement element, CharSequence... keysToSend) {
        test.get().log(Status.PASS, "afterSendKeys");
    }
}
