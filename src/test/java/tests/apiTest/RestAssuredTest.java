package tests.apiTest;

import com.google.gson.Gson;
import enums.ProjectType;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.Project;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class RestAssuredTest {

    @Test
    public void simpleRestAssuredtest1_2(){

        RestAssured.baseURI = "https://reqres.in";
        String endpoint = "/api/users/2";

        given().when()
                .get(endpoint)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log()
                .body();

    }

    @Test
    public void simpleRestAssuredtest2_2(){

        RestAssured.baseURI = "https://reqres.in";
        String endpoint = "/api/users/2";

        given()
                .when()
                .get(endpoint)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .assertThat()
                .body("data.id", equalTo(2))
                .body("data.first_name", equalTo("Janet"));
    }
@Test
    public void simpleRestAssuredtest3_1(){

        RestAssured.baseURI = "https://reqres.in";
        String endpoint = "/api/users";
        String bodyJson = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}";

       int projectId = given()
                .body(bodyJson)
                .when()
                .post(endpoint)
                .then()
                .statusCode(HttpStatus.SC_CREATED)
                .log().body()
                .extract().jsonPath().getInt("id");

    System.out.println(projectId);
    }

    @Test
    public void serializationTest(){
        Gson gson = new Gson();

        Project project = Project.builder()
                .name("Name")
                .type(ProjectType.MULTIPLE)
                .isShowAnnouncement(true)
                .announcement("announcmen description")
                .build();

        String result = gson.toJson(project);

        System.out.println(result);
    }
    @Test
    public void deserializationTest(){
     Project expectedProject = Project.builder()
             .name("Name")
             .type(ProjectType.MULTIPLE)
             .isShowAnnouncement(true)
             .announcement("announcmen description")
             .build();

        Gson gson = new Gson();

        String jsonString = "{\"name\":\"Name\",\"announcement\":\"announcmen description\",\"isShowAnnouncement\":true,\"type\":\"MULTIPLE\"}";

        Project project = gson.fromJson(jsonString, Project.class);

        System.out.println(project.toString());
     Assert.assertTrue(expectedProject.equals(project));
    }
}
