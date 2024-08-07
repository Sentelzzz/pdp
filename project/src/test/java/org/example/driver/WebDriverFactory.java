package org.example.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class WebDriverFactory {

    private WebDriverFactory() {
    }

    public static WebDriver getWebDriver(String browser) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        switch (browser.toLowerCase()) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
                capabilities.setBrowserName("chrome");
                break;

            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, firefoxOptions);
                capabilities.setBrowserName("firefox");
                break;

            case "edge":
                throw new UnsupportedOperationException("Microsoft Edge не поддерживается в этом примере");

            default:
                throw new IllegalArgumentException("Неподдерживаемый браузер" );
        }

        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
        return driver;
    }
}
