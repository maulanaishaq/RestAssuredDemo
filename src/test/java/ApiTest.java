import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;


public class ApiTest {

    @Test
    private void getResponseApi(){
        Response response = get("https://reqres.in/api/users?page=2");

        System.out.println("Response : " + response.asString());
        System.out.println("Status Code : "+response.getStatusCode());
        System.out.println("Body : "+response.getBody().asString());
        System.out.println("Time taken :"+response.getTime());
        System.out.println("Header : "+response.getHeader("content-type"));

        int statusCode = response.statusCode();
        Assert.assertEquals(statusCode, 200);

    }


    @Test
    private void getResponseApiAnother(){
        given().
                get("https://reqres.in/api/users?page=2")
                .then()
                .assertThat().statusCode(200);



    }


}
