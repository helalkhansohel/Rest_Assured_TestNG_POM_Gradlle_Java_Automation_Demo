package API;
import Utils.Utils;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.configuration.ConfigurationException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class DataFileUp {
    public void fileUploadwithFormParam_1() {
        try {
            File file = new File("./src/test/resources/Testfile.txt");

            Response response = RestAssured.given()
                    .multiPart("file", file)
                    .formParam("title", "foo")
                    .formParam("body", "bar")
                    .formParam("userId", 1)
                    .when()
                    .post("https://jsonplaceholder.typicode.com/posts");

            int statusCode = response.getStatusCode();
            String responseBody = response.getBody().asString();

            //------------print--------------------------------
            System.out.println("HTTP status code: " + statusCode);
            System.out.println("Response body: " + responseBody);

            // Parse the JSON response if needed
            JSONObject json = new JSONObject(responseBody);
            System.out.println(json.toString());
            String technology = json.getString("title");
            System.out.println(technology);

            //--
        } catch (Exception e) {
            System.out.println(e);
        }
    }
   //Best way
    public void fileUploadwithFormParam_2() {
        try {
            File file = new File("./src/test/resources/Testfile.txt");

            Response response = RestAssured.given()
                    .multiPart("file", file)
                    .formParam("title", "foo")
                    .formParam("body", "bar")
                    .formParam("userId", 1)
                    .when()
                    .post("https://jsonplaceholder.typicode.com/posts")
                    .then()
                    .assertThat().statusCode( 200 ).extract().response();

            JsonPath jsonpath = response.jsonPath();
            String token = jsonpath.get("token");

            Utils.updateJSONArray("token",token);

            //--
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public void fileUploadbody() {
        try {
            File file = new File("./src/test/resources/Testfile.txt");

            Response response = RestAssured.given()
                    .contentType("application/json")
                    .multiPart("file", file)
                    .body(
                            "{\"username\":\"salman\",\n" +
                                    "\"password\":\"salman1234\"}"
                    )
                    .when()
                    .post("https://jsonplaceholder.typicode.com/posts")
                    .then()
                    .assertThat().statusCode( 200 ).extract().response();

            JsonPath jsonpath = response.jsonPath();
            String token = jsonpath.get("token");

            Utils.updateJSONArray("token",token);

            //--
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void callingLoginAPI() throws IOException {
        try {

            Response response = RestAssured.given()

                    .contentType("application/json")
                    .accept("application/json")

                    .when()
                    .post("https://jsonplaceholder.typicode.com/posts/1")
                    .then()
                    .assertThat().statusCode( 200 ).extract().response();

//            RestAssured.baseURI  ="https://customer-test-api.herokuapp.com";
//            Response res =
//                    given()
//                            .contentType("application/json")
//                            .body(
//                                    "{\"username\":\"salman\",\n" +
//                                            "\"password\":\"salman1234\"}"
//                            ).
//                            when()
//                            .post("/customer/api/v1/login").
//                            then()
//                            .assertThat().statusCode( 200 ).extract().response();

//            JsonPath jsonpath = res.jsonPath();
//            String Mytoken = jsonpath.get("token");
//            Utils.updateJSONArray("token",Mytoken);
        }
        catch (Exception e){

        }


    }
}
