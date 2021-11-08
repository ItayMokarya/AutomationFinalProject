package sanity;

import extansions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilitis.CommonOps;
import workFlow.MobileFlows;

@Listeners(utilitis.Listeners.class)
public class MortgageMobile extends CommonOps {

    @Test(description = "Test01 - Verify Mortgage")
    @Description("")
    public void test01_verifyMortgage(){
        MobileFlows.calculateMortgage("1200", "3", "5");
        Verifications.isElementEqualToText(mortgageMainPage.txt_repayment, "£35.72");
    }

}
