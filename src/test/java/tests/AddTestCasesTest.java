package tests;

import baseEntities.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.OpenProjectPage;
import steps.AddTestCasesStep;
import testData.AddProjectProvider;
import testData.AddTestCaseProvider;

public class AddTestCasesTest extends BaseTest {

    @Test(dataProvider = "Add Test Case", dataProviderClass = AddTestCaseProvider.class)
    public void AddTestCase(String projectName, String testCaseName, String preconditionText, String stepsText, String expectedResultText){

        AddTestCasesStep addTestCasesStep = new AddTestCasesStep(browsersService);
        addTestCasesStep.addTestCases(projectName, testCaseName, preconditionText, stepsText, expectedResultText);
        OpenProjectPage openProjectPage = new OpenProjectPage(browsersService);

        Assert.assertTrue(openProjectPage.getTestCase(testCaseName).isDisplayed());
    }
//
//    @Test(dataProvider = "Update Test Case", dataProviderClass = AddTestCaseProvider.class)
//    public void UpdateTestCase(String projectName, String testCaseName,String newTestCaseName, String preconditionText, String stepsText, String expectedResultText){
//
//        AddTestCasesStep addTestCasesStep = new AddTestCasesStep(browsersService);
//        addTestCasesStep.updateTestCase(projectName, testCaseName, newTestCaseName, preconditionText, stepsText, expectedResultText);
//        OpenProjectPage openProjectPage = new OpenProjectPage(browsersService);
//
//        Assert.assertTrue(openProjectPage.getTestCase(newTestCaseName).isDisplayed());
//    }
}
