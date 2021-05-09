package tests.uitests;

import baseEntities.BaseTest;
import enums.ProjectType;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddProjectPage;
import pages.ProjectPage;
import steps.ProjectSteps;
import testData.AddProjectProvider;

public class AddProjectTest extends BaseTest {


    @Test(dataProvider = "Add Project", dataProviderClass = AddProjectProvider.class, description = "Добавление проекта")
    @Description("Добавление 3 проектов с разными именами и видами проекта")
    public void AddProject(String name, String announcement, String value){

        ProjectSteps projectSteps = new ProjectSteps(browsersService);
        ProjectPage addProjectPage = projectSteps.AddProjectStep(name, announcement, value);

       Assert.assertEquals(addProjectPage.getSuccessText.getText(),"Successfully added the new project.");
       Assert.assertTrue(addProjectPage.checkProjectList(name));
    }

    @Test(dependsOnMethods = "AddProject", dataProvider = "Update Project", dataProviderClass = AddProjectProvider.class, description = "Обновление проекта")
    public void UpdateProject(String projectName, String newProjectName){

        ProjectSteps projectSteps = new ProjectSteps(browsersService);
        ProjectPage editProjectPage = projectSteps.UpdateProject(projectName,newProjectName,"54321");

        Assert.assertEquals(editProjectPage.getSuccessText.getText(),"Successfully updated the project.");
        Assert.assertTrue(editProjectPage.checkProjectList(newProjectName));

    }

    @Test(dependsOnMethods = "UpdateProject", dataProvider = "Delete Project", dataProviderClass = AddProjectProvider.class, description = "Удалеине проекта")
    public void DeleteProject(String projectName){
        ProjectSteps projectSteps = new ProjectSteps(browsersService);
        ProjectPage deleteProject = projectSteps.DeleteProject(projectName);

        Assert.assertEquals(deleteProject.getSuccessText.getText(),"Successfully deleted the project.");
        Assert.assertEquals(deleteProject.checkProjectList(projectName),false);
    }
}
