package page_objects;

import org.openqa.selenium.By;

import static driver.AppMobile.getDriver;

public class LoginPO {


    public void btnLogin() {
        getDriver().findElement(By.id("com.amazon.mShop." +
                "android.shopping:id/sign_in_button")).click();
    }

    public void skipLogin() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        getDriver().findElement(By.id("com.amazon.mShop." +
                "android.shopping:id/skip_sign_in_button")).click();
    }



}
