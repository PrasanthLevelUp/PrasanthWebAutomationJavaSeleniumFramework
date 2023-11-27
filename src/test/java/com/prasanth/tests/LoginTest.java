package com.prasanth.tests;

import com.prasanth.config.ConfigReader;
import com.prasanth.pages.LoginPage;
import com.prasanth.testdata.JsonUtils;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest{

    @Test
    public void loginTest() throws InterruptedException {
        String url = ConfigReader.getProperty("appURL");
        driver.get(url);
        Thread.sleep(3000);
        System.out.println(driver.getTitle());
        LoginPage loginPage = new LoginPage(driver);
        String username = JsonUtils.getValueFromJson(testData, "/login/validUser/username");
        String password = JsonUtils.getValueFromJson(testData, "/login/validUser/password");
        loginPage.login(username, password);
    }
}
