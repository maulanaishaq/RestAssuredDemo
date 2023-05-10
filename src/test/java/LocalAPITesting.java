import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class LocalAPITesting {

    private String baseURI = "https://reqres.in/api/users";

    private String baseUriRegister = "https://reqres.in/api/register";

    private String baseUriLogin = "https://reqres.in/api/login";


    @Test(priority = 1)
    public void getAllDataTest(){

        given()
                .get(baseURI)
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test(priority = 1)
    public void getByIdDataTest(){

        given()
                .get(baseURI+"/1")
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test(priority = 2)
    public void getByIdDataNotFound(){
        given()
                .get(baseURI+"/23")
                .then()
                .statusCode(404)
                .log().all();
    }

    @Test(priority = 1)
    public void getListDataResource(){
        given()
                .get("https://reqres.in/api/unknown")
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test(priority = 1)
    public void getIdSingleResource(){
        given()
                .get("https://reqres.in/api/unknown/2")
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test(priority = 1)
    public void getIdSingleResourceNotFound(){
        given()
                .get("https://reqres.in/api/unknown/23")
                .then()
                .statusCode(404)
                .log().all();
    }



    @Test(priority = 0)
    public void postTest(){
        JSONObject req = new JSONObject();

        req.put("name","morpheus");
        req.put("job","leader");


        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(req.toJSONString())
                .when()
                .post(baseURI)
                .then()
                .statusCode(201)
                .log().all();
    }



    @Test(priority = 0)
    public void putTest(){
        JSONObject req = new JSONObject();
        req.put("name","morpheus");
        req.put("job","zion resident");

        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(req.toJSONString())
                .when()
                .put(baseURI+"/2")
                .then()
                .statusCode(200)
                .log().all();
    }


    @Test(priority = 0)
    public void deleteTest(){
        given()
                .delete(baseURI+"/2")
                .then()
                .statusCode(204)
                .log().all();
    }




    // API Register

    @Test(priority = 0)
    public void postTestRegisterSuccessful(){
        JSONObject req = new JSONObject();

        req.put("email","eve.holt@reqres.in");
        req.put("password","pistol");


        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(req.toJSONString())
                .when()
                .post(baseUriRegister)
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test(priority = 0)
    public void postTestRegisterUnsuccessful(){
        JSONObject req = new JSONObject();

        req.put("email","eve.holt@reqres.in");

        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(req.toJSONString())
                .when()
                .post(baseUriRegister)
                .then()
                .statusCode(400)
                .log().all();
    }

    // API Login

    @Test(priority = 0)
    public void postTestLoginSuccessful(){
        JSONObject req = new JSONObject();

        req.put("email","eve.holt@reqres.in");
        req.put("password","cityslicka");


        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(req.toJSONString())
                .when()
                .post(baseUriRegister)
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test(priority = 0)
    public void postTestLoginUnsuccessful(){
        JSONObject req = new JSONObject();

        req.put("email","peter@klaven");


        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(req.toJSONString())
                .when()
                .post(baseUriRegister)
                .then()
                .statusCode(400)
                .log().all();
    }

    // Delay Response

    @Test(priority = 1)
    public void getDelayResponseTest(){

        given()
                .get(baseURI+"/?delay=3")
                .then()
                .statusCode(200)
                .log().all();
    }





}
