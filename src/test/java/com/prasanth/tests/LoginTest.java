package com.prasanth.tests;

import com.prasanth.config.ConfigReader;
import com.prasanth.pages.LoginPage;
import com.prasanth.testdata.JsonUtils;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest{

    @Test(priority = 2)
    public void validLoginTest() throws InterruptedException {
        String url = ConfigReader.getProperty("appURL");
        driver.get(url);
        Thread.sleep(3000);
        System.out.println(driver.getTitle());
        LoginPage loginPage = new LoginPage(driver);
        String username = JsonUtils.getValueFromJson(testData, "/login/validUser/username");
        String password = JsonUtils.getValueFromJson(testData, "/login/validUser/password");
        loginPage.login(username, password);
    }

    @Test(priority = 1)
    public void invalidLoginTest() throws InterruptedException {
        String url = ConfigReader.getProperty("appURL");
        driver.get(url);
        Thread.sleep(3000);
        System.out.println(driver.getTitle());
        LoginPage loginPage = new LoginPage(driver);
        String username = JsonUtils.getValueFromJson(testData, "/login/invalidUser/username");
        String password = JsonUtils.getValueFromJson(testData, "/login/invalidUser/password");
        loginPage.login(username, password);
    }
}
