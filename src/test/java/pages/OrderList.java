package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class OrderList {
    AppiumDriver driver;
    public final String ORDER_LIST="new UiSelector().text(\"Order list\")";
    public final String BILLS_SECTION="//android.widget.TextView[@text=\"Bills & Top-ups\"]";
    public final String CANCEL_ORDER_BTN="new UiSelector().resourceId(\"blibli.mobile.commerce:id/bt_cancel_order\")";
    public final String CANCEL_OK_POP="blibli.mobile.commerce:id/bt_one";
    public final String ORDER_DETAIL_TITLE="new UiSelector().text(\"Order detail\")";
    public final String ORDERED_PRODUCT="new UiSelector().resourceId(\"blibli.mobile.commerce:id/digital_orders_detail\").instance(0)";
    public final String NAVIGATE_BACK="//android.widget.ImageButton[@content-desc=\"Navigate up\"]";
    public final String CANCELED_SECTION="//android.widget.TextView[@resource-id=\"blibli.mobile.commerce:id/canceled_tab\"]";
    public final String NOMINAL_IN_ORDERED="blibli.mobile.commerce:id/tv_detail_three";
    public final String CANCELLED_ORDER="new UiSelector().resourceId(\"blibli.mobile.commerce:id/tv_operator_name\").instance(0)";
    WebDriverWait wait;
    public OrderList(AppiumDriver driver){
        this.driver=driver;
        wait=new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void navigateToOrderList() {
        driver.findElement(AppiumBy.androidUIAutomator(ORDER_LIST)).click();
    }

    public void goToBillsSection() {
        driver.findElement(By.xpath(BILLS_SECTION)).click();
    }

    public void viewOrderedProduct(){
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.androidUIAutomator(ORDERED_PRODUCT))).click();
    }

    public void cancelOrder() throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.androidUIAutomator(ORDER_DETAIL_TITLE)));
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator(CANCEL_ORDER_BTN)));
        driver.findElement(AppiumBy.androidUIAutomator(CANCEL_ORDER_BTN)).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(CANCEL_OK_POP))).click();
    }

    public void navigateToCancelledSection() {
        driver.findElement(By.xpath(NAVIGATE_BACK)).click();
        driver.findElement(By.xpath(CANCELED_SECTION)).click();

    }


    public String getNominal() {
        Methods.scrollUpTo(driver);
        return driver.findElement(By.id(NOMINAL_IN_ORDERED)).getText();

    }

    public boolean verifyProduct(String nominal) {
        return driver.findElement(AppiumBy.androidUIAutomator(CANCELLED_ORDER)).getText().contains(nominal);
    }
}
