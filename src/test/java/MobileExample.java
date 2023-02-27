import driver.AppiumServer;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import page_objects.LoginPO;

import java.net.MalformedURLException;

import static driver.AppMobile.*;

public class MobileExample {

    static AndroidDriver<MobileElement> driver;

    public static void main(String[] args) throws MalformedURLException {
        setUp();
        MobileElement numberSeven = driver.findElement(By.id("com.google.android.calculator:id/digit_7"));
        numberSeven.click();
    }

    @Test(testName = "acessar app sem efetuar login")
    public void acessarAppSemEfetuarLogin() {
        setUp();
        new LoginPO().skipLogin();
        getDriver().quit();
        AppiumServer.stop();
    }




}
