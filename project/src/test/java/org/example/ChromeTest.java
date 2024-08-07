package org.example;

import org.example.driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class ChromeTest {

    @Test
    public void test1() throws MalformedURLException, InterruptedException {
        WebDriver driver = DriverSingleton.getInstance("chrome").getDriver();
        driver.get("https://google.com");
        Thread.sleep(10000);
        DriverSingleton.getInstance("chrome").closeDriver();
    }

}
