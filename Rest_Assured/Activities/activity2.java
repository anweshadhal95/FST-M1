package activities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class activity2 {

    // Set base URL
    final static String ROOT_URI = "https://petstore.swagger.io/v2/user";

    @Test(priority = 1)
    public void addNewUser() throws IOException {
        // Import JSON file
        FileInputStream inputJSON = new FileInputStream("src/test/resources/input.json");

        // Read JSON file as String
        String reqBody = new String(inputJSON.readAllBytes());
        //System.out.println(reqBody);

        Response response = given().contentType(ContentType.JSON).body(reqBody).when().post(ROOT_URI);
        response.prettyPrint();

        inputJSON.close();

        response.then().body("code", equalTo(200));
        response.then().body("message", equalTo("9801"));
    }

    @Test(priority=2)
    public void getUserInfo() {
        // Import JSON file to write to
        File outputJSON = new File("src/test/java/activities/userGETResponse.json");

        Response response =
                given().contentType(ContentType.JSON) // Set headers
                        .pathParam("username", "anwesha") // Pass request body from file
                        .when().get(ROOT_URI + "/{username}"); // Send POST request

        String resBody = response.getBody().asPrettyString();

        try {
            // Create JSON file
            outputJSON.createNewFile();
            // Write response body to external file
            FileWriter writer = new FileWriter(outputJSON.getPath());
            writer.write(resBody);
            writer.close();
        } catch (IOException excp) {
            excp.printStackTrace();
        }

        response.then().body("id", equalTo(9801));
        response.then().body("username", equalTo("anwesha"));
        response.then().body("firstName", equalTo("Anwesha"));
        response.then().body("lastName", equalTo("Dhal"));
        response.then().body("email", equalTo("anweshadhal@mail.com"));
        response.then().body("password", equalTo("password123"));
        response.then().body("phone", equalTo("9812763451"));
    }

    @Test(priority=3)
    public void deleteUser() throws IOException {
        Response response =
                given().contentType(ContentType.JSON) // Set headers
                        .pathParam("username", "anwesha") // Add path parameter
                        .when().delete(ROOT_URI + "/{username}"); // Send POST request

        response.then().body("code", equalTo(200));
        response.then().body("message", equalTo("anwesha"));
    }

}
