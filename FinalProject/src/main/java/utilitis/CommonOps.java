package utilitis;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import java.lang.reflect.Method;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;

public class CommonOps extends Base {

    public static String getData(String nodeName)
    {
        DocumentBuilder dBuilder;
        Document doc = null;
        File fXmlFile = new File("./Configuration/DataConfig.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fXmlFile);
        }
        catch(Exception e) {
            System.out.println("Exception in reading XML file: " + e);
        }
        doc.getDocumentElement().normalize();
        return doc.getElementsByTagName(nodeName).item(0).getTextContent();
    }

    public void initBrowser(String browserType){
        if (browserType.equalsIgnoreCase("chrome")){
            driver = initChromeDriver();
        }else if(browserType.equalsIgnoreCase("firefox")){
            driver = initFirefoxDriver();
        }else if(browserType.equalsIgnoreCase("IE")){
            driver = initIEDriver();
        }else{
            throw new RuntimeException("Invalid Browser type");
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timeout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Long.parseLong(getData("Timeout")));
        driver.get(getData("Url"));
        ManagePages.initParaBank();
        actions = new Actions(driver);

    }

    private WebDriver initChromeDriver(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        return  driver;
    }

    private WebDriver initFirefoxDriver(){
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        return  driver;
    }

    private WebDriver initIEDriver(){
        WebDriverManager.iedriver().setup();
        WebDriver driver = new InternetExplorerDriver();
        return  driver;
    }

    private static void initMobile() {

        dc.setCapability(MobileCapabilityType.UDID, getData("UDID"));
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, getData("AppPackege"));
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, getData("AppActivity"));
        try {
            mobileDriver = new AndroidDriver<>(new URL(getData("AppiumServer")), dc);
        }catch (Exception e){
            System.out.println("Can not connect to appium server, see details: "+ e);
        }
        ManagePages.initMortgage();
        mobileDriver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timeout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(mobileDriver, Long.parseLong(getData("Timeout")));

    }

    public static void initRestAPI() {

        RestAssured.baseURI=getData("UrlAPI");
        httpRequest= RestAssured.given();
    }

    @BeforeClass
    public void startSession(){
//        String platform = "web";
        if (getData("PlatformName").equalsIgnoreCase("web")){
            initBrowser(getData("BrowserName"));
        }else if(getData("PlatformName").equalsIgnoreCase("mobile")){
            initMobile();
        }else if(getData("PlatformName").equalsIgnoreCase("api")) {
            initRestAPI();
        }else {
            throw new RuntimeException("Invalid platform");
        }

        softAssert = new SoftAssert();
        screen = new Screen();
    }



    @AfterClass
    public void closeSession(){
        if(!getData("PlatformName").equalsIgnoreCase("api")) {
            if (!getData("PlatformName").equalsIgnoreCase("mobile"))
                driver.quit();
            else if (getData("PlatformName").equalsIgnoreCase("mobile")) {
                mobileDriver.quit();
            }
        }
    }

    @BeforeMethod
    public void beforeMethods(Method method){
        if(!getData("PlatformName").equalsIgnoreCase("api")){
            try {
                MonteScreenRecorder.startRecord(method.getName());
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}