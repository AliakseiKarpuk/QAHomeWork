package tests;

import baseEntities.BaseTest;
import io.qameta.allure.*;
import models.TestCase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

    public Logger logger = LogManager.getLogger();

    @Test
    @Description("Добавление трех тест кейсов с разныими значениями")
    @Story("Добавление Тест кейса")
    public void AddTestCase(){

        TestCase testCase = TestCase.builder()
                .projectName("someName")
                .testCaseName("New TESTCASE")
                .preconditionText("dwdwdwdw")
                .stepText("dsdsds")
                .build();

        AddTestCasesStep addTestCasesStep = new AddTestCasesStep(browsersService);
        addTestCasesStep.addTestCases(testCase);
        OpenProjectPage openProjectPage = new OpenProjectPage(browsersService);

        logger.debug(testCase.toString());
        Assert.assertTrue(openProjectPage.getTestCase(testCase.getTestCaseName()).isDisplayed());
    }

    @Test(dependsOnMethods = "AddTestCase", description = "Обновление тест кейса")
    @Description("Обновление трех тест кейсов с разныими значениями")
    @Story("Обновление Тест кейса")
    public void UpdateTestCase(){

        TestCase testCase = TestCase.builder()
                .projectName("someName")
                .testCaseName("New TESTCASE")
                .newTestCaseName("NEW TEST CASE NAME")
                .preconditionText("dwdwdwdw12321321")
                .stepText("dwd123123213")
                .expectedResultText("dozhd ozhidaetsya12321321")
                .build();

        AddTestCasesStep updateTestCasesStep = new AddTestCasesStep(browsersService);
        updateTestCasesStep.updateTestCase(testCase);
        OpenProjectPage openProjectPage = new OpenProjectPage(browsersService);

        logger.debug(testCase.toString());

        Assert.assertEquals(openProjectPage.successText.getText(),"Successfully updated the test case.");
    }

    @Test(dependsOnMethods = "UpdateTestCase", description = "Удаление тест кейса")
    @Description("Удаление трех тест кейсов")
    @Story("Удаление Тест кейса")
    public void DeleteTestCase(){

        TestCase testCase = TestCase.builder()
                .projectName("someName")
                .testCaseName("NEW TEST CASE NAME")
                .build();

        AddTestCasesStep deleteTestCaseStep = new AddTestCasesStep(browsersService);
        deleteTestCaseStep.deleteTestCase(testCase);

        logger.debug(testCase.toString());

        OpenProjectPage openProjectPage = new OpenProjectPage(browsersService);

        Assert.assertEquals(openProjectPage.successText.getText(),"Successfully flagged the test case as deleted.");
    }
}
