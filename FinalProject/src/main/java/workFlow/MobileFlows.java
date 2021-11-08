package workFlow;

import extansions.MobileAction;
import io.qameta.allure.Step;
import utilitis.CommonOps;

public class MobileFlows extends CommonOps {

    @Step("Business Flow: Fill Form and Calculate mortgage")
    public static void calculateMortgage(String amount, String term, String rant){

        MobileAction.typeText(mortgageMainPage.txt_amount, amount);
        MobileAction.typeText(mortgageMainPage.txt_term, term);
        MobileAction.typeText(mortgageMainPage.txt_rate, rant);
        MobileAction.tap(1, mortgageMainPage.btn_calculate, 500);

    }
}
