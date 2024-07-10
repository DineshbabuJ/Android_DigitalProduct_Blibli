package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    AppiumDriver driver;
    public final String EMAIL_FIELD="//android.widget.EditText";
    public final String PASSWORD_FIELD="new UiSelector().className(\"android.widget.EditText\").instance(1)";
    public final String FINAL_LOGINBTN="//android.widget.Button[@text=\"Log in\"]";
    WebDriverWait wait;
    public LoginPage(AppiumDriver driver){
        this.driver=driver;
        wait=new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public boolean isEnabled(String emailField) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(emailField)));
        return driver.findElement(By.xpath(emailField)).isEnabled();
    }

    public void EnterEmail(String email) {
        driver.findElement(By.xpath(EMAIL_FIELD)).sendKeys(email);
    }


    public void clickLogin() {
        driver.findElement(By.xpath(FINAL_LOGINBTN)).click();
    }

    public void enterPassword(String password) {
        driver.findElement(AppiumBy.androidUIAutomator(PASSWORD_FIELD)).sendKeys(password);
    }

    public void continueLogin() {
        driver.findElement(By.xpath(FINAL_LOGINBTN)).click();
    }

    public String getEmail() {
        return driver.findElement(By.xpath(EMAIL_FIELD)).getText();
    }
}
