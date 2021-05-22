package tests.dbTest;

import baseEntities.BaseTest;
import dao.ProjectDaoImpl;
import lombok.SneakyThrows;
import models.Project;
import org.testng.annotations.Test;
import pages.AddProjectPage;
import pages.ProjectPage;
import steps.ProjectSteps;
import testData.AddProjectProvider;
import testData.AddTestCaseProvider;

public class sqlHwTest extends BaseTest {

    @SneakyThrows
    @Test(dataProvider = "Add Project", dataProviderClass = AddProjectProvider.class)
    public void addSqlProjectTest(Project project1) {

            ProjectSteps projectPage = new ProjectSteps(browsersService);
            projectPage.AddProject(project1);

            ProjectDaoImpl projectDao = new ProjectDaoImpl();
            projectDao.getProject(project1.getName());

        }
    }
