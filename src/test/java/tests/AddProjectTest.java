package tests;

import baseEntities.BaseTest;
import enums.ProjectType;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProjectPage;
import steps.ProjectSteps;
import testData.AddProjectProvider;

public class AddProjectTest extends BaseTest {


    @Test(dataProvider = "Add Project", dataProviderClass = AddProjectProvider.class)
    public void AddProject(String projectName, ProjectType projectType){

        ProjectSteps projectSteps = new ProjectSteps(browsersService);
        ProjectPage projectPage = projectSteps.AddProject(projectName, projectType);

        Assert.assertEquals(projectPage.getSuccessText(),"Successfully added the new project.");
        Assert.assertTrue(projectPage.checkProjectList(projectName));
    }

    @Test(dependsOnMethods = "AddProject", dataProvider = "Update Project", dataProviderClass = AddProjectProvider.class)
    public void UpdateProject(String projectName, ProjectType projectType, String newProjectName){

        ProjectSteps projectSteps = new ProjectSteps(browsersService);
        ProjectPage editProjectPage = projectSteps.UpdateProject(projectName,newProjectName,"54321");

        Assert.assertEquals(editProjectPage.getSuccessText(),"Successfully updated the project.");
        Assert.assertTrue(editProjectPage.checkProjectList(newProjectName));

    }

    @Test(dependsOnMethods = "UpdateProject", dataProvider = "Delete Project", dataProviderClass = AddProjectProvider.class)
    public void DeleteProject(String projectName){
        ProjectSteps projectSteps = new ProjectSteps(browsersService);
        ProjectPage deleteProject = projectSteps.DeleteProject(projectName);

        Assert.assertEquals(deleteProject.getSuccessText(),"Successfully deleted the project.");
        Assert.assertEquals(deleteProject.checkProjectList(projectName),false);
    }
}
