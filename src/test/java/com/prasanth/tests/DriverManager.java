package com.prasanth.tests;

import com.prasanth.base.BrowserFactory;
import com.prasanth.config.ConfigReader;
import com.prasanth.enums.BrowserType;
import com.prasanth.listeners.TestListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;

public class DriverManager {
    private static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    public void initializeDriver() {
        if (driverThreadLocal.get() == null) {
            BrowserType browserType = BrowserType.valueOf(ConfigReader.getProperty("browser").toUpperCase());
            WebDriver driver = BrowserFactory.createInstance(browserType);
            WebDriverListener listener = new TestListener();
            WebDriver decorated = new EventFiringDecorator(listener).decorate(driver);
            driverThreadLocal.set(decorated);
        }
    }

    public static WebDriver getDriver() {
        return driverThreadLocal.get();
    }

    public void quitDriver() {
        if (driverThreadLocal.get() != null) {
            driverThreadLocal.get().quit();
            driverThreadLocal.remove();
        }
    }
}
