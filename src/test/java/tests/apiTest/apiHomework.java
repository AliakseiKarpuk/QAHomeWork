package tests.apiTest;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import lombok.SneakyThrows;
import models.apiModels.Listuser;
import models.apiModels.SingleUser;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.Reader;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class apiHomework {

    @SneakyThrows
    @Test
    public void listUserTest(){

        RestAssured.baseURI = "https://reqres.in";
        String endpoint = "/api/users?page=2";

        Gson gson = new Gson();

        Reader reader = new FileReader("src/test/java/testData/apiData/listUSers.json");

        Listuser result = gson.fromJson(reader, Listuser.class);
        String expectedResult = gson.toJson(result);

      String actualResult =  given()
                .when()
                .get(endpoint)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .body()
                .asString();

        Assert.assertEquals(expectedResult,actualResult);

    }

    @SneakyThrows
    @Test
    public void singleUserTest(){

        RestAssured.baseURI = "https://reqres.in";
        String endpoint = "/api/users/2";

        Gson gson = new Gson();
        Reader reader = new FileReader("src/test/java/testData/apiData/singleuser.json");

        SingleUser expectedresult = gson.fromJson(reader, SingleUser.class);
        String result = gson.toJson(expectedresult);

        String res =  given()
                .when()
                .get(endpoint)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .body()
                .asString();

        Assert.assertEquals(res, result);

    }

    @Test
    public void singleUserNotFound(){
        RestAssured.baseURI = "https://reqres.in";
        String endpoint = "/api/users/23";

        given()
                .when()
                .get(endpoint)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_NOT_FOUND)
                .log()
                .body();
    }

    @Test
    public void createTest(){
        RestAssured.baseURI = "https://reqres.in";
        String endpoint = "/api/users";
        String bodyJson = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}";

        given()
                .body(bodyJson)
                .when()
                .post(endpoint)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_CREATED);
    }

    @Test
    public void updateTest(){
        RestAssured.baseURI = "https://reqres.in";
        String endpoint = "/api/users/2";
        String bodyJson = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"zion resident\"\n" +
                "}";

      given()
                .body(bodyJson)
                .when()
                .put(endpoint)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void patchTest(){
        RestAssured.baseURI = "https://reqres.in";
        String endpoint = "/api/users/2";
        String bodyJson = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"zion resident\"\n" +
                "}";

        given()
                .body(bodyJson)
                .when()
                .patch(endpoint)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void deleteTest(){

        RestAssured.baseURI = "https://reqres.in";
        String endpoint = "/api/users/2";

        given()
                .when()
                .delete(endpoint)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_NO_CONTENT);
    }

}
