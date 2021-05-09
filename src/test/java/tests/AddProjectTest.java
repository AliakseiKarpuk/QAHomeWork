package tests;

import baseEntities.BaseTest;
import enums.ProjectType;
import io.qameta.allure.*;
import models.Project;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProjectPage;
import steps.ProjectSteps;
import testData.AddProjectProvider;

@Epic("Main Epic")
@Feature("Add Project")
@Severity(SeverityLevel.CRITICAL)
public class AddProjectTest extends BaseTest {

    public Logger logger = LogManager.getLogger();


    @Test
    @Description("Добавление трех проектов с разныими значениями")
    @Story("Добавление Проекта")
    public void AddProject(){

        ProjectSteps projectSteps = new ProjectSteps(browsersService);

        Project project = Project.builder()
                .name("someName")
                .announcement("someannoun")
                .value("1")
                .build();
        ProjectPage projectPage = projectSteps.AddProject(project);

        logger.debug(project.toString());

        Assert.assertEquals(projectPage.getSuccessText(),"Successfully added the new project.");
        Assert.assertTrue(projectPage.checkProjectList(project.getName()));
    }

    @Test
    @Description("Обновление трех проектов с другими значениями")
    @Story("Обновление Проекта")
    public void UpdateProject(){

        ProjectSteps projectSteps = new ProjectSteps(browsersService);

        Project project = Project.builder()
                .name("someName")
                .newName("anotherName")
                .announcement("someannoun")
                .value("2")
                .build();
        ProjectPage editProjectPage = projectSteps.UpdateProject(project);

        logger.debug(project.toString());

        Assert.assertEquals(editProjectPage.getSuccessText(),"Successfully updated the project.");
        Assert.assertTrue(editProjectPage.checkProjectList(project.getNewName()));

    }

    @Test
    @Description("Удаление трех проектов")
    @Story("Удаление Проекта")
    public void DeleteProject(String projectName){
        ProjectSteps projectSteps = new ProjectSteps(browsersService);
        ProjectPage deleteProject = projectSteps.DeleteProject(projectName);
        logger.debug(projectName);

        Assert.assertEquals(deleteProject.getSuccessText(),"Successfully deleted the project.");
        Assert.assertEquals(deleteProject.checkProjectList(projectName),false);
    }
}
