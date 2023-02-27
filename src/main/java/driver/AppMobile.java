package driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import static driver.AppiumServer.getInstance;

public class AppMobile {

    static ThreadLocal<AppiumDriver> driver = new ThreadLocal();

    public static AppiumDriver getDriver() {
        return driver.get();
    }

    public static void setDriver(AppiumDriver appiumDriver) {
        driver.set(appiumDriver);
    }

    public static void setUp() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("app", "/Users/williamsoares/Downloads/amazon.apk");
        caps.setCapability("udid", "67c3cacf");
        getInstance().start();
        AppiumDriver driver = null;
        try {
            driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        setDriver(driver);
    }

}
