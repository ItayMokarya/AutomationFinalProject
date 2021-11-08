package pageObjects.paraBank;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage {

    @FindBy (xpath = "//*[@title=\"ParaBank\"]")
    public WebElement head_paraBank;

    @FindBy(css = "#leftPanel > h2")
    public WebElement head_services;

    @FindBy(linkText = "home")
    public WebElement btn_home;

}
