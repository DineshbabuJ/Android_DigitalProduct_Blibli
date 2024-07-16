package pages;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.*;

public class DigitalPage {
    AppiumDriver driver;
    public final String PULSA_TITLE_NAV="new UiSelector().text(\"Pulsa & Data Packages\")";
    public final String BILLS_NAV="//android.widget.TextView[@resource-id=\"blibli.mobile.commerce:id/tv_bill_detail\"]";
    public final String TOP_UP_TITLE="//android.widget.TextView[@resource-id=\"blibli.mobile.commerce:id/tv_section_title\" and @text=\"Top-ups\"]";
    public final String PHONE_NO="blibli.mobile.commerce:id/atv_text";
    public final String NOMINALS_LIST="//android.widget.TextView[@resource-id=\"blibli.mobile.commerce:id/tv_recharge_title\"]";
    public final String NOMINAL_CHOICE="//android.widget.TextView[@resource-id=\"blibli.mobile.commerce:id/tv_recharge_title\" and @text=\"NOMINAL\"]";
    public final String MAKE_PAYMENT_BTN="blibli.mobile.commerce:id/bt_buy_now";
    public final String NOMINAL_PRICE="//android.widget.TextView[@resource-id=\"blibli.mobile.commerce:id/tv_final_price\" and @text=\"Rp40.000\"]";
    WebDriverWait wait;
    public String nominalPrice;
    public DigitalPage(AppiumDriver driver){
        this.driver=driver;
        wait=new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void enterPhoneNumber(String number) {
        driver.findElement(By.id(PHONE_NO)).sendKeys(number);
    }

    public boolean isNominalsListed() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(NOMINALS_LIST)));
        Methods.scrollUpTo(driver);
        List<WebElement> nominalList=driver.findElements(By.xpath(NOMINALS_LIST));
        return !nominalList.isEmpty();
    }

    public void chooseNominal(String nominal) {
        nominalPrice=driver.findElement(By.xpath(NOMINAL_PRICE)).getText();
        driver.findElement(By.xpath(NOMINAL_CHOICE.replace("NOMINAL",nominal))).click();
    }

    public void makePayment() {
        driver.findElement(By.id(MAKE_PAYMENT_BTN)).click();
    }

    public boolean isDisplayed(String xpathLocator) {
        return driver.findElement(By.xpath(xpathLocator)).isDisplayed();
    }

    public boolean isTitleVisible(String pulsaTitleNav) {
        return driver.findElement(AppiumBy.androidUIAutomator(pulsaTitleNav)).isDisplayed();
    }

    public String getInput() {
        return driver.findElement(By.id(PHONE_NO)).getText();
    }

    public boolean isEnabled(String phoneNo) {
        return driver.findElement(By.id(phoneNo)).isEnabled();
    }

}
