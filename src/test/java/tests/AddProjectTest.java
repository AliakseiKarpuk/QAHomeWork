package tests;

import baseEntities.BaseTest;
import enums.ProjectType;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProjectPage;
import steps.ProjectSteps;
import testData.AddProjectProvider;

@Epic("Main Epic")
@Feature("Add Project")
@Severity(SeverityLevel.CRITICAL)
public class AddProjectTest extends BaseTest {


    @Test(dataProvider = "Add Project", dataProviderClass = AddProjectProvider.class, description = "Добавление проекта")
    @Description("Добавление трех проектов с разныими значениями")
    @Story("Добавление Проекта")
    public void AddProject(String projectName, ProjectType projectType){

        ProjectSteps projectSteps = new ProjectSteps(browsersService);
        ProjectPage projectPage = projectSteps.AddProject(projectName, projectType);

        Assert.assertEquals(projectPage.getSuccessText(),"Successfully added the new project.");
        Assert.assertTrue(projectPage.checkProjectList(projectName));
    }

    @Test(dependsOnMethods = "AddProject", dataProvider = "Update Project", dataProviderClass = AddProjectProvider.class, description = "Обновление проекта")
    @Description("Обновление трех проектов с другими значениями")
    @Story("Обновление Проекта")
    public void UpdateProject(String projectName, ProjectType projectType, String newProjectName){

        ProjectSteps projectSteps = new ProjectSteps(browsersService);
        ProjectPage editProjectPage = projectSteps.UpdateProject(projectName,newProjectName,"54321");

        Assert.assertEquals(editProjectPage.getSuccessText(),"Successfully updated the project.");
        Assert.assertTrue(editProjectPage.checkProjectList(newProjectName));

    }

    @Test(dependsOnMethods = "UpdateProject", dataProvider = "Delete Project", dataProviderClass = AddProjectProvider.class, description = "Удаление проекта")
    @Description("Удаление трех проектов")
    @Story("Удаление Проекта")
    public void DeleteProject(String projectName){
        ProjectSteps projectSteps = new ProjectSteps(browsersService);
        ProjectPage deleteProject = projectSteps.DeleteProject(projectName);

        Assert.assertEquals(deleteProject.getSuccessText(),"Successfully deleted the project.");
        Assert.assertEquals(deleteProject.checkProjectList(projectName),false);
    }
}
