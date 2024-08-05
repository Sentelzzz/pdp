package org.example;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class PdpTest {

    @Test
    public void dpdInitialTest() throws MalformedURLException {
        WebDriver driver = SeleniumTest.getDriver("chrome");
        driver.get("https://google.com");

        driver.quit();
    }

}
