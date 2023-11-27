package com.prasanth.tests;

import com.fasterxml.jackson.databind.JsonNode;
import com.prasanth.config.ConfigReader;
import com.prasanth.testdata.JsonUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.IOException;

public class BaseTest {
    protected DriverManager driverManager;
    public static WebDriver driver;
    protected String testDataFilePath = ConfigReader.getProperty("testDataFilePath");
    protected JsonNode testData;


    @BeforeTest
    public void setUp() {
        driverManager = new DriverManager();
        driverManager.initializeDriver();
        driver = driverManager.getDriver();
        try {
             testData = JsonUtils.readJsonFromFile(testDataFilePath);
        }catch (IOException e){

        }
    }

    @AfterTest
    public void tearDown() {
        if (driverManager != null) {
            driverManager.quitDriver();
        }
    }
}
