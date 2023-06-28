package activities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class activity1 {

    String baseUrl="https://petstore.swagger.io/v2/pet";
    @Test(priority=1)
    public void postRequest()
    {
        String reqBody="{\"id\":77252,\"name\":\"Rileey\",\"status\":\"alive\"}";

        Response response= given().contentType(ContentType.JSON).when().body(reqBody).post(baseUrl);
        response.prettyPrint();
        response.then().body("id",equalTo(77252));
        response.then().body("name",equalTo("Rileey"));
        response.then().body("status",equalTo("alive"));

    }
    @Test(priority = 2)
    public void getRequest()
    {
        Response response=given().contentType(ContentType.JSON).when().pathParam("petId","77252").get(baseUrl+"/{petId}");
        response.prettyPrint();

        response.then().body("id",equalTo(77252));
        response.then().body("name",equalTo("Rileey"));
        response.then().body("status",equalTo("alive"));
    }
    @Test(priority = 3)
    public void deleteRequest()
    {
        Response response = given().contentType(ContentType.JSON).when().pathParam("petId", "77232").delete(baseUrl + "/{petId}"); // Send DELETE request
        String res=response.asPrettyString();
        System.out.println(res);
//        response.then().body("code", equalTo(201));
//        response.then().body("message", equalTo("77252"));
    }
}
