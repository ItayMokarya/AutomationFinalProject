package workFlow;

import extansions.APIActions;
import io.qameta.allure.Step;
import utilitis.CommonOps;

public class APIFlows extends CommonOps {

    static String id;

    @Step("Business Flow: Get users lists")
    public static String getUserProperty(String jPath){
        response = APIActions.get("/api/users?page=2");
        return APIActions.extractFromJSON(response, jPath);
    }

    @Step("Business Flow: Create new user")
    public static int postUser(String name, String job){
        params.put("first_name",name);
        params.put("job",job);
        APIActions.post(params,"/api/users");
        return response.getStatusCode();
    }

    @Step("Business Flow: Update user")
    public static int putUser(String name, String job){
        params.put("first_name",name);
        APIActions.put(params, "/api/users/7");
        return response.getStatusCode();
    }

    @Step("Business Flow: Delete new user")
    public static int deleteUser(){
        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(params.toJSONString());
        response = httpRequest.delete("/api/users/2");
        return response.getStatusCode();

    }



}
