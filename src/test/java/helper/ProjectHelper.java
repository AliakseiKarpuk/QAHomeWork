package helper;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dao.ProjectDaoImpl;
import lombok.SneakyThrows;
import models.Project;

import java.util.Arrays;

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


    @SneakyThrows
    public int getProjectId() {

        int projectId = 0;

        String body = given()
                .when()
                .get("index.php?/api/v2/get_projects/")
                .body()
                .asString();

        Project[] projectsList = gson.fromJson(body, Project[].class);
        for (Project project : projectsList) {
            if (project.getName().equals(Arrays.stream(projectsList).findFirst().get().getName())) ;
            projectId = project.getId();

        }

        return projectId;
    }


}
