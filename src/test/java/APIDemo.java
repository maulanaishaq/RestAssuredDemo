import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;


public class APIDemo {


    @Test
    private void getDemo(){
        given()
                .header("Content-Type","application/json")
                .get("https://reqres.in/api/users?page=2")
                .then()
                .statusCode(200)
                .body("data[1].first_name", equalTo("Lindsay"))
                .body("data.first_name",
                        hasItems("George","Tobias","Michael","Byron"))
                .assertThat().statusCode(200)
                .log().all();
    }

    @Test
    private void postDemo(){
        JSONObject req = new JSONObject();
        req.put("name","Maulana");
        req.put("job","Employee");
        System.out.println(req.toJSONString());

        given()
                .header("Content-Type","application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(req.toJSONString())
                .when()
                .post("https://reqres.in/api/users")
                .then()
                .assertThat().statusCode(201);

    }

    @Test
    private void putDemo(){
        JSONObject req = new JSONObject();
        req.put("name", "Ishaq");
        req.put("job", "Teacher");
        System.out.println(req.toJSONString());

        given()
                .header("Content-Type","application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(req.toJSONString())
                .when()
                .put("https://reqres.in/api/users/2")
                .then()
                .assertThat().statusCode(200)
                .log().all();

    }


    @Test
    private void pastchDemo(){
        JSONObject req = new JSONObject();
        req.put("name","Maulana");
        req.put("job","Teacher");
        System.out.println(req.toJSONString());

        given()
                .header("Content-Type","application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(req.toJSONString())
                .when()
                .patch("https://reqres.in/api/users/2")
                .then()
                .assertThat().statusCode(200)
                .log().all();
    }

    @Test
    private void deleteDemo(){
        when()
                .delete("https://reqres.in/api/users/2")
                .then()
                .assertThat().statusCode(204)
                .log().all();
    }




}
