package workFlow;

import com.google.common.util.concurrent.Uninterruptibles;
import extansions.UIActions;
import extansions.Verifications;
import io.qameta.allure.Step;
import utilitis.CommonOps;

import java.util.concurrent.TimeUnit;


public class WebFlows extends CommonOps {

    @Step("Business Flow - Verify Login")
    public static void login(String user, String password, String isExist){
        Verifications.isElementDisplay(loginPage.head_login);
        UIActions.typeText(loginPage.txt_userName, user);
        UIActions.typeText(loginPage.txt_password, password);
        UIActions.click(loginPage.btn_login);

        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
        if (isExist.equalsIgnoreCase("exist"))
            Verifications.isElementEqualToText(mainPage.head_services, getData("ServicesTitle"));
        else if (isExist.equalsIgnoreCase("not-exist"))
            Verifications.isElementEqualToText(loginPage.errorMassage, getData("LoginErrorMassage"));
        else
            throw new RuntimeException("Invalid Expected Output option in Data Driven testing");
    }

    @Step("Business flow: Verify Request Loan module")
    public static void requestLoan(String amount, String downAmount, String accountId){
        UIActions.click(servicesMenuPage.link_requestLoan);
        Verifications.isElementDisplay(requestLoanPage.head_requestLoan);
        UIActions.typeText(requestLoanPage.txt_amount, amount);
        UIActions.typeText(requestLoanPage.txt_downPayment, downAmount);
        UIActions.selectFromDropDown(requestLoanPage.select_AccountId, accountId);
        UIActions.click(requestLoanPage.btn_submit);
        try {
            Verifications.isElementDisplay(requestLoanPage.head_ErrorMassage);
        }catch (Exception e){
            Verifications.isElementDisplay(loanStatusPage.head_ShowResult);
        }

    }

    @Step("Business flow: Verify that loans is Approve or Denied")
    public static void statusLoan(){
        Verifications.isElementDisplay(loanStatusPage.head_ShowResult);
        Verifications.isElementDisplay(loanStatusPage.ProviderName);
        Verifications.isElementDisplay(loanStatusPage.responseDate);

    }

}
