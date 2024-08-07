package org.example.driver;

import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public class DriverSingleton {

    private static final ThreadLocal<DriverSingleton> instance = new ThreadLocal<>();

    private WebDriver driver;

    private DriverSingleton(String browser) throws MalformedURLException {
        driver = WebDriverFactory.getWebDriver(browser);
    }

    public static synchronized DriverSingleton getInstance(String browser) throws MalformedURLException {
        if (instance.get() == null) {
            instance.set(new DriverSingleton(browser));
        }
        return instance.get();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void closeDriver() {
        try {
            driver.quit();
            driver = null;
        } finally {
            instance.remove();
        }
    }
}
