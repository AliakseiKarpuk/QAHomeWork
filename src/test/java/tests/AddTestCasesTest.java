package tests;

import baseEntities.BaseTest;
import io.qameta.allure.*;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.OpenProjectPage;
import steps.AddTestCasesStep;
import testData.AddProjectProvider;
import testData.AddTestCaseProvider;

@Epic("Main Epic")
@Feature("Add Testcase")
@Severity(SeverityLevel.CRITICAL)
public class AddTestCasesTest extends BaseTest {

    @Test(dataProvider = "Add Test Case", dataProviderClass = AddTestCaseProvider.class, description = "Добавление тест кейса")
    @Description("Добавление трех тест кейсов с разныими значениями")
    @Story("Добавление Тест кейса")
    public void AddTestCase(String projectName, String testCaseName, String preconditionText, String stepsText, String expectedResultText){

        AddTestCasesStep addTestCasesStep = new AddTestCasesStep(browsersService);
        addTestCasesStep.addTestCases(projectName, testCaseName, preconditionText, stepsText, expectedResultText);
        OpenProjectPage openProjectPage = new OpenProjectPage(browsersService);

        Assert.assertTrue(openProjectPage.getTestCase(testCaseName).isDisplayed());
    }

    @Test(dataProvider = "Update Test Case", dataProviderClass = AddTestCaseProvider.class, dependsOnMethods = "AddTestCase", description = "Обновление тест кейса")
    @Description("Обновление трех тест кейсов с разныими значениями")
    @Story("Обновление Тест кейса")
    public void UpdateTestCase(String projectName, String testCaseName, String newTestCaseName, String preconditionText, String stepsText, String expectedResultText){

        AddTestCasesStep updateTestCasesStep = new AddTestCasesStep(browsersService);
        updateTestCasesStep.updateTestCase(projectName, testCaseName, newTestCaseName, preconditionText, stepsText, expectedResultText);
        OpenProjectPage openProjectPage = new OpenProjectPage(browsersService);

        Assert.assertEquals(openProjectPage.getSuccessText().getText(),"Successfully updated the test case.");
    }

    @Test(dataProvider = "Delete Test Case", dataProviderClass = AddTestCaseProvider.class, dependsOnMethods = "UpdateTestCase", description = "Удаление тест кейса")
    @Description("Удаление трех тест кейсов")
    @Story("Удаление Тест кейса")
    public void DeleteTestCase(String projectName, String testCaseName){

        AddTestCasesStep deleteTestCaseStep = new AddTestCasesStep(browsersService);
        deleteTestCaseStep.deleteTestCase(projectName, testCaseName);
        OpenProjectPage openProjectPage = new OpenProjectPage(browsersService);

        Assert.assertEquals(openProjectPage.getSuccessText().getText(),"Successfully flagged the test case as deleted.");
    }
}
