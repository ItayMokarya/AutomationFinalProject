package utilitis;

import io.appium.java_client.AppiumDriver;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import org.testng.asserts.SoftAssert;
import pageObjects.paraBank.*;

public class Base {

    // General
    protected static WebDriverWait wait;
    protected static Actions actions;
    protected static SoftAssert softAssert;
    protected static Screen screen;

    // Web
    protected static WebDriver driver;

    // Mobile
    protected static AppiumDriver mobileDriver;
    protected static DesiredCapabilities dc = new DesiredCapabilities();

    // Rest API
    protected static RequestSpecification httpRequest;
    protected static Response response;
    protected static JSONObject params = new JSONObject();
    protected static JsonPath jp;

    // Pages objects
    protected static LoginPage loginPage;
    protected static MainPage mainPage;
    protected static ServicesMenuPage servicesMenuPage;
    protected static OverviewPage overviewPage;
    protected static RequestLoanPage requestLoanPage;
    protected static LoanStatusPage loanStatusPage;

    // Pages objects Mobile
    protected static pageObjects.mortgage.MainPage mortgageMainPage;

}
