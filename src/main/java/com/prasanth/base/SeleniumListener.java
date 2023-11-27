package com.prasanth.base;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

public class SeleniumListener{

    private ExtentTest extentTest;

    public SeleniumListener(ExtentTest extentTest) {
        this.extentTest = extentTest;
    }
    public void afterGet(WebDriver driver, String url){
        logToExtentReport("Clicked on element: afterGet" +url);
    }
    public void afterFindElement(WebDriver driver, By locator, WebElement result){
        logToExtentReport("Clicked on element: afterFindElement");
    }
    public void afterClose(WebDriver driver){
        logToExtentReport("Clicked on element: afterClose");
    }
    public void afterQuit(WebDriver driver){
        logToExtentReport("Clicked on element: afterQuit");
    }
    public void afterClick(WebElement element){
        logToExtentReport("Clicked on element: afterClick");
    }
    public void afterSubmit(WebElement element){
        logToExtentReport("Clicked on element: afterSubmit");
    }
    public void afterSendKeys(WebElement element, CharSequence... keysToSend){
        logToExtentReport("Clicked on element: afterSendKeys"+keysToSend);
    }

    // Override other methods as needed

    private void logToExtentReport(String logMessage) {
        if (extentTest != null) {
            extentTest.log(Status.INFO, logMessage);
        } else {
            System.out.println("ExtentTest is not set. Cannot log to Extent Report.");
        }
    }

    private void logToExtentReport(String logMessage, Status status) {
        if (extentTest != null) {
            extentTest.log(status, logMessage);
        } else {
            System.out.println("ExtentTest is not set. Cannot log to Extent Report.");
        }
    }
}

