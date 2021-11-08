package pageObjects.paraBank;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RequestLoanPage {

    @FindBy(xpath = "//h1[@class=\"title\"]")
    public WebElement head_requestLoan;

    @FindBy (id = "amount")
    public WebElement txt_amount;

    @FindBy (id = "downPayment")
    public WebElement txt_downPayment;

    @FindBy (id = "fromAccountId")
    public WebElement select_AccountId;

    @FindBy(xpath = "//*[@type=\"submit\"]")
    public WebElement btn_submit;

    @FindBy(xpath = "//div[@ng-if='showError']/h1")
    public WebElement head_ErrorMassage;

    @FindBy(xpath = "//div[@ng-if='showError']/p")
    public WebElement requestLoanErrorMassage;



}
