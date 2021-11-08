package extansions;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilitis.CommonOps;

import java.util.List;

import static org.testng.Assert.*;

public class Verifications extends CommonOps {

    @Step("Verify Text Element")
    public static void isElementEqualToText(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element));
        assertEquals(element.getText(), text);
    }

    @Step("Verify the total amount")
    public static void isTotalAmountGood(String amount){
        String [] total = amount.split("\\$");
        Double num = Double.parseDouble(total[1]);
        System.out.println("the total amount is: "+num);
        assertTrue(num<10000);
    }

    @Step("Verify number Of Element")
    public static void isNumberOfElementGood(List<WebElement> elems, int expected) {
        wait.until(ExpectedConditions.visibilityOf(elems.get(elems.size() - 1)));
        softAssert.assertEquals(elems.size(), expected);
    }

    @Step("Verify Visibility Of Elements(Soft-Assertion)")
    public static void isAllElementsDisplay(List<WebElement> elems) {
        for (WebElement elem : elems) {
            softAssert.assertTrue(elem.isDisplayed(), "sorry " + elem.getText() + " NOT display");
        }
        softAssert.assertAll("Some elements were NOT display");
    }

    @Step("Verify if Element Display(Soft-Assertion)")
    public static void isElementDisplay(WebElement elem) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        assertTrue(elem.isDisplayed(), "sorry " + elem.getText() + " NOT display");
    }

    @Step("Verify if element is visually")
    public static void isElementVisually(String pictureName){
        try {
            screen.find(getData("ImageRepo")+ pictureName+".png");
        }catch (Exception e){
            fail("Error Comparing Image file: "+e);
        }
    }

    @Step("Verify that text equal to text ")
    public static void isTextsEqual(String actual, String expected) {
        assertEquals(actual, expected);
    }

    @Step("Verify that amount equal to text ")
    public static void isNumberEqual(int actual, int expected) {
        assertEquals(actual, expected);
    }


}