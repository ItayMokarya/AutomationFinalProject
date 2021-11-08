package extansions;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import utilitis.CommonOps;

public class UIActions extends CommonOps {

    @Step("Click on element")
    public static void click(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    @Step("Type text on filed")
    public static void typeText(WebElement element, String text){
        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(text);
    }

    @Step("Select From Dropdown")
    public static void selectFromDropDown(WebElement element, String text){
        wait.until(ExpectedConditions.visibilityOf(element));
        Select dropDown = new Select(element);
        dropDown.selectByVisibleText(text);
    }

    @Step("Mouse Hover to element")
    public static void mouseHover(WebElement elem1, WebElement elem2){
        actions.moveToElement(elem1).moveToElement(elem2).click().build().perform();
    }

}
