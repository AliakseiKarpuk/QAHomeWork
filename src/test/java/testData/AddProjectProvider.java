package testData;

import dao.ProjectDaoImpl;
import enums.ProjectType;
import lombok.SneakyThrows;
import models.Project;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;

public class AddProjectProvider {

    @SneakyThrows
    @DataProvider(name = "Add Project")
    public static Object[][] AddData(){
        ArrayList<Project> objects = new ArrayList<>();
        ProjectDaoImpl prDao = new ProjectDaoImpl();

       for(Project project : prDao.getProjects()) {

            Project project1 = Project.builder()
                    .name(project.getName())
                    .announcement(project.getAnnouncement())
                    .isShowAnnouncement(project.isShowAnnouncement())
                    .type(project.getType())
                    .build();
            objects.add(project1);
        }
       return new Object[][]{
               {objects.get(0)},
               {objects.get(1)},
               {objects.get(2)}
        };
    }

    @DataProvider(name = "Update Project")
    public static Object[][] UpdateData(){
        return new Object[][]{
                {"AKarpuk_01", "new_AKarpuk_01"},
                {"AKarpuk_02", "new_AKarpuk_02"},
                {"AKarpuk_03", "new_AKarpuk_03"}
        };
    }

    @DataProvider(name = "Delete Project")
    public static Object[][] DeleteData(){
        return new Object[][]{
                {"new_AKarpuk_01"},
                {"new_AKarpuk_02"},
                {"new_AKarpuk_03"}
        };
    }
}
