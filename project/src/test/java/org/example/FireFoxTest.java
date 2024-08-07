package org.example;

import org.example.driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class FireFoxTest {

    @Test
    public void test2() throws MalformedURLException, InterruptedException {
        WebDriver driver = DriverSingleton.getInstance("firefox").getDriver();
        driver.get("https://google.com");
        Thread.sleep(10000);
        DriverSingleton.getInstance("firefox").closeDriver();
    }
}
