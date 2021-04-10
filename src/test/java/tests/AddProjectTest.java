package tests;

import baseEntities.BaseTest;
import enums.ProjectType;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddProjectPage;
import pages.ProjectPage;
import steps.ProjectSteps;

public class AddProjectTest extends BaseTest {
    @Test
    public void AddProjectWithSingleSuiteMode(){

        ProjectSteps projectSteps = new ProjectSteps(browsersService);
        ProjectPage projectPage = projectSteps.AddProject("AKarpuk_01", ProjectType.SINGLE_FOR_ALL_CASES);

        Assert.assertEquals(projectPage.getSuccessText(),"Successfully added the new project.");
        Assert.assertTrue(projectPage.checkProjectList("AKarpuk_01"));
    }
    @Test
    public void AddProjectWithSingleBaseLine(){

        ProjectSteps projectSteps = new ProjectSteps(browsersService);
        ProjectPage projectPage = projectSteps.AddProject("AKarpuk_02", ProjectType.SINGLE_WITH_BASELINE);

        Assert.assertEquals(projectPage.getSuccessText(),"Successfully added the new project.");
        Assert.assertTrue(projectPage.checkProjectList("AKarpuk_02"));
    }
    @Test
    public void AddProjectWithMultipleMode(){

        ProjectSteps projectSteps = new ProjectSteps(browsersService);
        ProjectPage projectPage = projectSteps.AddProject("AKarpuk_03", ProjectType.MULTIPLE);

        Assert.assertEquals(projectPage.getSuccessText(),"Successfully added the new project.");
        Assert.assertTrue(projectPage.checkProjectList("AKarpuk_03"));
    }
}
