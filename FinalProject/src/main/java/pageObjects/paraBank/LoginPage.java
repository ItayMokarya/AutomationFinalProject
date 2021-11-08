package pageObjects.paraBank;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    @FindBy(name = "username")
    public WebElement txt_userName;

    @FindBy (name = "password")
    public WebElement txt_password;

    @FindBy(xpath = "//input[@type=\"submit\"]")
    public WebElement btn_login;
    
    @FindBy (xpath = "//*[@id=\"leftPanel\"]/h2")
    public WebElement head_login;

    @FindBy (xpath = "//*[@id=\"rightPanel\"]/h1")
    public WebElement head_error;

    @FindBy (xpath = "//*[@id=\"rightPanel\"]/p")
    public WebElement errorMassage;






}
