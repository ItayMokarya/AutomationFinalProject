package pageObjects.paraBank;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class OverviewPage {

    @FindBy (xpath = "//div/h1")
    public WebElement head_accountOverview;

    @FindBy (xpath = "//tr[@ng-repeat='account in accounts']")
    public List<WebElement> accountsInTable;

    @FindBy (xpath = "//tr/td[2]/b")
    public WebElement totalAmount;


}
