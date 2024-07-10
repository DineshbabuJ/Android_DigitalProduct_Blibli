package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    AppiumDriver driver;
    public final String POPUP="/hierarchy/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ImageView";
    public final String BILLS_TOPUP="new UiSelector().text(\"Bills & Top-ups\")";
    public final String OTHER_PRODUCTS="new UiSelector().className(\"android.view.ViewGroup\").instance(15)";
    public final String PULSA="new UiSelector().text(\"Pulsa\").instance(0)";
    WebDriverWait wait;
    public HomePage(AppiumDriver driver){
        this.driver=driver;
        wait= new WebDriverWait(driver, Duration.ofSeconds(15));
    }


    public void chooseBillsTopUpSection() {
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.androidUIAutomator(BILLS_TOPUP))).click();
    }

    public void clickotherProducts() {
        driver.findElement(AppiumBy.androidUIAutomator(OTHER_PRODUCTS)).click();
    }

    public void selectPulsa() {
        driver.findElement(AppiumBy.androidUIAutomator(PULSA)).click();
    }

    public boolean isClickable(String locator) {
        return driver.findElement(AppiumBy.androidUIAutomator(locator)).isEnabled();
    }
}
