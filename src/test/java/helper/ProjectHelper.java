package helper;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import models.Project;

import static io.restassured.RestAssured.given;

public class ProjectHelper {

    private Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

    public ProjectHelper() {
    }

        public Project getProject(int id) {

        String body = given()
                .when()
                .get("index.php?/api/v2/get_project/" + id)
                .body()
                .asString();


        return gson.fromJson(body, Project.class);
    }


}
