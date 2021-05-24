package tests.dbTest;

import baseEntities.BaseTest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dao.ProjectDaoImpl;
import helper.ProjectHelper;
import lombok.SneakyThrows;
import models.Project;
import org.testng.Assert;
import org.testng.annotations.Test;
import steps.ProjectSteps;
import testData.AddProjectProvider;

public class sqlHwTest extends BaseTest {

    @SneakyThrows
    @Test(dataProvider = "Add Project", dataProviderClass = AddProjectProvider.class)
    public void addSqlProjectTest(Project project1) {

        ProjectSteps projectPage = new ProjectSteps(browsersService);
        projectPage.AddProject(project1);


        ProjectDaoImpl projectDao = new ProjectDaoImpl();
        Project ex = projectDao.getProject(project1.getName());

        ProjectHelper projectHelper = new ProjectHelper();
        Project ac = projectHelper.getProject(projectHelper.getProjectId(project1));

        Assert.assertEquals(ac, ex);
    }
}
