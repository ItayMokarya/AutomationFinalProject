package helper;


import org.testng.annotations.Test;
import utilitis.CommonOps;
import static org.testng.Assert.assertTrue;

public class TempAPI extends CommonOps {

    @Test
    public void test01_getAPI(){

//        response = httpRequest.get("/api/unknown");
        response = httpRequest.get("/api/users/itay");
        response.prettyPrint();
    }

    @Test
    public void test02_createUser(){

        params.put("name","Itay");
        params.put("job","QA");
        httpRequest.header("Content-Type", "application/json");

        httpRequest.body(params.toJSONString());
        response = httpRequest.post("/api/users");

        response.prettyPrint();
    }

    @Test
    public void test03_UpdateJob(){

//        params.put("name","Itay");
//        params.put("job","automation developer");
//        httpRequest.header("Content-Type", "application/json");
//
//        httpRequest.body(params.toJSONString());
//        response = httpRequest.put("/api/users/2");
//
//        response.prettyPrint();
    }

    @Test
    public void test03_deleteUser(){

        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(params.toJSONString());
        response = httpRequest.delete("/api/users/2");
        System.out.println(response.getStatusCode());
        assertTrue(response.getStatusCode()==204);
    }
}
