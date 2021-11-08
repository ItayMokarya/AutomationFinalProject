package utilitis;

import org.openqa.selenium.support.PageFactory;
import pageObjects.paraBank.*;

public class ManagePages extends Base {

    public static void initParaBank(){

        loginPage = PageFactory.initElements(driver, LoginPage.class);
        mainPage = PageFactory.initElements(driver, MainPage.class);
        servicesMenuPage = PageFactory.initElements(driver, ServicesMenuPage.class);
        overviewPage = PageFactory.initElements(driver, OverviewPage.class);
        requestLoanPage = PageFactory.initElements(driver, RequestLoanPage.class);
        loanStatusPage = PageFactory.initElements(driver,LoanStatusPage.class);

    }

    public static void initMortgage() {
        mortgageMainPage = new pageObjects.mortgage.MainPage(mobileDriver);
    }
}
