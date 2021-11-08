package pageObjects.paraBank;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ServicesMenuPage {

    @FindBy(linkText = "Open New Account")
    public WebElement link_openAccount;

    @FindBy(linkText = "Accounts Overview")
    public WebElement link_overview;

    @FindBy(linkText = "Transfer Funds")
    public WebElement link_transfer;

    @FindBy(linkText = "Bill Pay")
    public WebElement link_billPay;

    @FindBy(linkText = "Find Transactions")
    public WebElement link_transactions;

    @FindBy(linkText = "Update Contact Info")
    public WebElement link_updateInfo;

    @FindBy(linkText = "Request Loan")
    public WebElement link_requestLoan;

    @FindBy(linkText = "Log Out")
    public WebElement link_logOut;

    @FindBy (xpath = "//*[@id=\"leftPanel\"]/ul/li")
    public List<WebElement> allAccountServices;

}
