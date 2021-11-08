package extansions;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import utilitis.CommonOps;

public class APIActions extends CommonOps {

    @Step("Get data from server")
    public static Response get(String paraValue){
        response = httpRequest.get(paraValue);
        response.prettyPrint();
        return response;
    }

    @Step("Extract value from JSON format")
    public static String extractFromJSON(Response response, String path){
        jp = response.jsonPath();
        return  jp.get(path).toString();
    }

    @Step("Post data to server")
    public static void post(JSONObject params, String resource){
        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(params.toJSONString());
        response = httpRequest.post(resource);
        response.prettyPrint();
    }

    @Step("Put data to server")
    public static void put(JSONObject params, String resource){
        params.put("job","automation developer");
        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(params.toJSONString());
        response = httpRequest.put(resource);
        response.prettyPrint();
    }





}
