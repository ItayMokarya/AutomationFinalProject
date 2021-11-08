package sanity;

import extansions.UIActions;
import extansions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilitis.CommonOps;
import utilitis.ManageDDT;
import workFlow.WebFlows;

@Listeners(utilitis.Listeners.class)
public class ParaBankWeb extends CommonOps {

    @BeforeMethod
    public void goToHomePage(){
        UIActions.click(mainPage.btn_home);
    }

    @Test(description = "Test01 - Verify Login", dataProvider = "data-provider-users", dataProviderClass = ManageDDT.class)
    @Description("Verify login - with a table using DDT")
    public void test01_verifyLogin(String user, String password, String isExist) {
        WebFlows.login(user, password, isExist);
    }

    @Test(description = "Test02  - Verify all Services")
    @Description("Verify that all account services appears")
    public void test02_verifyAllServices(){
        Verifications.isAllElementsDisplay(servicesMenuPage.allAccountServices);
    }

    @Test(description = "Test03 - Verify account overview")
    @Description("Verify account overview page")
    public void test03_verifyAccountOverview(){
        UIActions.click(servicesMenuPage.link_overview);
        Verifications.isNumberOfElementGood(overviewPage.accountsInTable, 4);
        Verifications.isTotalAmountGood(overviewPage.totalAmount.getText());
    }

    @Test(description = "Test04 - Verify \"Para Bank\" Logo")
    @Description("Verify that para bank logo appears visually")
    public void test04_verifyParaBankLogo(){
        Verifications.isElementVisually("ParaBankLogo");
    }

    @Test(description = "Test05 - Verify Loan Request Module", dataProvider = "data-provider-loans", dataProviderClass = ManageDDT.class)
    @Description("Verify that error massage appears after click submit, using DDT")
    public void test05_verifyLoanRequest(String account, String downAmount, String accountId){
        WebFlows.requestLoan(account,downAmount, accountId);
        try {
            Verifications.isElementEqualToText(requestLoanPage.requestLoanErrorMassage, getData("RequestLoanError"));
        }catch (Exception e){
            WebFlows.statusLoan();
            if (loanStatusPage.loanStatus.getText().equals("Denied")){
                Verifications.isElementEqualToText(loanStatusPage.statusMessage, getData("StatusDeniedError"));
            }else if (loanStatusPage.loanStatus.getText().equals("Approved")) {
                Verifications.isElementEqualToText(loanStatusPage.statusMessage, getData("StatusApprove"));
                Verifications.isElementDisplay(loanStatusPage.accountNumber);
            }else {
                Verifications.isElementEqualToText(loanStatusPage.errorMessage, getData("RequestLoanError"));
            }
        }
    }

    @Test(description = "Test06 - Verify LogOut")
    @Description("Verify logout link")
    public void test08_verifyLogOut(){
        UIActions.click(servicesMenuPage.link_logOut);
        Verifications.isElementEqualToText(loginPage.head_login, getData("LoginTitle"));
    }

}
