package pageObjects.paraBank;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoanStatusPage {


    @FindBy(xpath = "//div[@ng-if='showResult']/h1")
    public WebElement head_ShowResult;

    @FindBy(id = "loanProviderName")
    public WebElement ProviderName;

    @FindBy(id = "responseDate")
    public WebElement responseDate;

    @FindBy(id = "loanStatus")
    public WebElement loanStatus;

    @FindBy(xpath = "//*[@id=\"rightPanel\"]/div/div/div/p[1]")
    public WebElement statusMessage;

    @FindBy(xpath = "//*[@id=\"rightPanel\"]/div/div/div/p[2]")
    public WebElement accountNumber;

    @FindBy(xpath = "//*[@id=\"rightPanel\"]/div/div/p")
    public WebElement errorMessage;



}
