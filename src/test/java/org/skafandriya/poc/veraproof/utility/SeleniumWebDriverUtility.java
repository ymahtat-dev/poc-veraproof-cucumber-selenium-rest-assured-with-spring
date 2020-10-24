package org.skafandriya.poc.veraproof.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

public class SeleniumWebDriverUtility {

    private static final FirefoxProfile firefoxProfile = new FirefoxProfile();

    public static FirefoxProfile getInstance() {
        return firefoxProfile;
    }

    public static WebDriver getFirefoxWebDriver() {
        FirefoxProfile firefox = getInstance();
        firefox.setPreference("browser.privatebrowsing.autostart", true);
        System.setProperty("webdriver.gecko.driver", "src//test/resources//webdrivers//geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        return driver;
    }


    public static WebDriver getPhantomJsDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "D:\\phantomjs\\phantomjs-2.1.1-windows\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");
        WebDriver driver = new PhantomJSDriver(capabilities);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return driver;
    }

}
