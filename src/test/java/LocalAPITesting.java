import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class LocalAPITesting {

    @Test
    public void getAllDataTest(){
        baseURI = "https://dummy.restapiexample.com/";

        given()
                .get("/api/v1/employees/")
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void getByIdDataTest(){
        baseURI = "https://dummy.restapiexample.com/";

        given()
                .get("api/v1/employee/23/")
                .then()
                .statusCode(200)
                .log().all();
    }




    @Test
    public void putTest(){
        JSONObject req = new JSONObject();
        req.put("name","Einstein");
        req.put("salary","2");
        req.put("age","23");
        req.put("id","21");

        baseURI = "https://dummy.restapiexample.com/";

        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(req.toJSONString())
                .when()
                .put("api/v1/update/21")
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void deleteTest(){
        baseURI = "https://dummy.restapiexample.com/";
        given()
                .delete("/api/v1/delete/2")
                .then()
                .statusCode(200)
                .log().all();
    }


}
