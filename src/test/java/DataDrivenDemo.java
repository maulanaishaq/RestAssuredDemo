import data.DataForTests;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class DataDrivenDemo extends DataForTests {



    @Test(dataProvider = "DataForPost")
    public void postTest(String name, int subjectId){
        JSONObject req = new JSONObject();
        req.put("name", name);
        req.put("subjectId", subjectId);

        baseURI = "http://localhost:3000/";

        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(req.toJSONString())
                .when()
                .post("/users")
                .then()
                .statusCode(201)
                .log().all();

    }

    @Test(dataProvider = "DataForDelete")
    public void deleteTest(int userId){
        baseURI = "http://localhost:3000/";

        given()
                .delete("/users"+userId)
                .then()
                .statusCode(200)
                .log().all();
    }


}
