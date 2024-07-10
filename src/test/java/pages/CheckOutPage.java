package pages;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CheckOutPage {
    AppiumDriver driver;
    public final String PAYMENT_NAV="//android.widget.TextView[@text=\"Payment\"]";
    public final String VIRTUAL_ACCOUNT="//android.widget.ImageView[@resource-id=\"blibli.mobile.commerce:id/iv_category_select\"]";
    public final String BANK_SELECTED="new UiSelector().text(\"BANK\")";
    public final String PAY_BTN="blibli.mobile.commerce:id/bt_pay_now";
    public final String RETURN_TO_HOME="blibli.mobile.commerce:id/tv_return_home";
    public final String BANK_DESCRIPTION="//android.widget.TextView[@resource-id=\"blibli.mobile.commerce:id/tv_category_description\" and @text=\"Bank BCA\"]";
    public final String NOMINAL="blibli.mobile.commerce:id/tv_value_3";
    public final String ORDER_STATUS_TITLE="new UiSelector().text(\"Order status\")";
    WebDriverWait wait;
    public CheckOutPage(AppiumDriver driver){
        this.driver=driver;
        wait=new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void selectVirtualAccount() {
        Methods.scrollUpTo(driver);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(VIRTUAL_ACCOUNT))).click();
    }

    public void chooseBank(String bank) {
        driver.findElement(AppiumBy.androidUIAutomator(BANK_SELECTED.replace("BANK",bank))).click();
    }


    public void clickPayBtn() {
        driver.findElement(By.id(PAY_BTN)).click();
    }

    public void goToHome(){
        Methods.scrollUpTo(driver);
        driver.findElement(By.id(RETURN_TO_HOME)).click();
    }

    public boolean isVisible(String paymentNav) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(PAYMENT_NAV)));
        return driver.findElement(By.xpath(paymentNav)).isDisplayed();
    }

    public String getBank() {
        return driver.findElement(By.xpath(BANK_DESCRIPTION)).getText();
    }

    public String getNominal() {
        Methods.scrollUpTo(driver);
        Methods.scrollUpTo(driver);
        return driver.findElement(By.id(NOMINAL)).getText();
    }

    public boolean isDisplayed(String orderStatusTitle) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(PAYMENT_NAV.replace("Payment","Order status"))));
        return driver.findElement(AppiumBy.androidUIAutomator(orderStatusTitle)).isDisplayed();
    }
}
