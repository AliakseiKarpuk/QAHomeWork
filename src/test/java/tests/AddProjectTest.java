package tests;

import baseEntities.BaseTest;
import enums.ProjectType;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddProjectPage;
import steps.ProjectSteps;

public class AddProjectTest extends BaseTest {
    @Test
    public void AddProjectWithSingleSuiteMode(){

        ProjectSteps projectSteps = new ProjectSteps(browsersService);
        AddProjectPage addProjectPage = projectSteps.AddProject("AKarpuk_01", ProjectType.SINGLE_FOR_ALL_CASES);
        Assert.assertEquals(addProjectPage.getSuccessText(),"Successfully added the new project.");

    }
    @Test
    public void AddProjectWithSingleBaseLine(){

        ProjectSteps projectSteps = new ProjectSteps(browsersService);
        AddProjectPage addProjectPage = projectSteps.AddProject("AKarpuk_02",ProjectType.SINGLE_WITH_BASELINE);
        Assert.assertEquals(addProjectPage.getSuccessText(),"Successfully added the new project.");
    }
    @Test
    public void AddProjectWithMultipleMode(){

        ProjectSteps projectSteps = new ProjectSteps(browsersService);
        AddProjectPage addProjectPage = projectSteps.AddProject("AKarpuk_03",ProjectType.MULTIPLE);
        Assert.assertEquals(addProjectPage.getSuccessText(),"Successfully added the new project.");
    }
}
