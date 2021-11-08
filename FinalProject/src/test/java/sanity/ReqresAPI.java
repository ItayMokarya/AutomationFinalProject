package sanity;

import extansions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import utilitis.CommonOps;
import workFlow.APIFlows;

public class ReqresAPI extends CommonOps {

    @Test(description = "Test01 - Verify Users")
    @Description("Verify if user exist")
    public void test01_verifyUsers(){
        Verifications.isTextsEqual(APIFlows.getUserProperty("data[0].first_name"),"Michael");
    }

    @Test(description = "test 02 - add user and verify")
    @Description("Create user and Verify status")
    public void test02_addUserAndVerify(){
        Verifications.isNumberEqual(APIFlows.postUser("itay","QA"),201);
    }

    @Test(description = "test 03 - Update user and verify")
    @Description("Update user and Verify status")
    public void test03_updateUserAndVerify(){
        Verifications.isNumberEqual(APIFlows.putUser("Itay","Automation Develop"),200);
    }

    @Test(description = "test 04 - Delete user and verify")
    @Description("Delete user and Verify status")
    public void test04_deleteUserAndVerify(){
        Verifications.isNumberEqual(APIFlows.deleteUser(),204);
    }

}
