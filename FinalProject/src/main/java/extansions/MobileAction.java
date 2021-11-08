package extansions;

import com.google.common.util.concurrent.Uninterruptibles;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilitis.CommonOps;

import java.util.concurrent.TimeUnit;

public class MobileAction extends CommonOps {

    @Step("Click on element")
    public static void click(MobileElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    @Step("Type text on filed")
    public static void typeText(MobileElement element, String text){
        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(text);
    }


    @Step("Tap on element")
    public static void tap(int finger, MobileElement element, int duration){
        wait.until(ExpectedConditions.elementToBeClickable(element));
        mobileDriver.tap(finger, element, duration);
    }

    @Step("Swipe")
    public static void swipe(int startX, int startY, int endX, int endY, int duration){
        Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
        mobileDriver.swipe(startX, startY, endX, endY, duration);
    }

    @Step("Zoom to element")
    public static void zoom(MobileElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
        mobileDriver.zoom(element);
    }

    @Step("pinch to element")
    public static void pinch(MobileElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
        mobileDriver.pinch(element);
    }

    @Step("Execute Script")
    public static void executeScript(String script){
        mobileDriver.executeScript(script);
    }

}
