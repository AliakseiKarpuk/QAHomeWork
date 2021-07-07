package steps;

import baseEntities.BaseStep;
import core.BrowsersService;
import io.qameta.allure.Step;
import models.TestCase;
import pages.AddTestCasesPage;
import pages.DashboardPage;
import pages.OpenProjectPage;
import pages.dialogs.DeleteConfirm;

public class AddTestCasesStep extends BaseStep {


    public AddTestCasesStep(BrowsersService browsersService) {
        super(browsersService);
    }

    @Step("Добавление тест кейса '{testCaseName}' с разными значениями")
    public OpenProjectPage addTestCases(TestCase testCase){
        LoginSteps loginSteps = new LoginSteps(browsersService);
        DashboardPage dashboardPage = loginSteps.loginWithCorrectCredentials("atrostyanko+0401@gmail.com", "QqtRK9elseEfAk6ilYcJ");
        dashboardPage.getProjectWithTestCases(testCase.getProjectName()).click();

        OpenProjectPage openProjectPage = new OpenProjectPage(browsersService,false);
        openProjectPage.addTestCasesButton.click();

        AddTestCasesPage addTestCasesPage = new AddTestCasesPage(browsersService,false);
        addTestCasesPage.title.sendKeys(testCase.getTestCaseName());
        addTestCasesPage.preconditions.sendKeys(testCase.getPreconditionText());
        addTestCasesPage.steps.sendKeys(testCase.getStepText());
        addTestCasesPage.addTestCaseButton.click();
        openProjectPage.getAllTestCases.click();

        return new OpenProjectPage(browsersService,false);

    }

    @Step("Обновление тест кейса '{testCaseName}' с разными значениями")
    public OpenProjectPage updateTestCase(TestCase testCase) {

        LoginSteps loginSteps = new LoginSteps(browsersService);
        DashboardPage dashboardPage = loginSteps.loginWithCorrectCredentials("atrostyanko+0401@gmail.com", "QqtRK9elseEfAk6ilYcJ");
        dashboardPage.getProjectWithTestCases(testCase.getProjectName()).click();

        OpenProjectPage openProjectPage = new OpenProjectPage(browsersService,false);
        openProjectPage.getAllTestCases.click();
        openProjectPage.getTestCase(testCase.getTestCaseName()).click();
        openProjectPage.editButton.click();

        AddTestCasesPage updateTestCase = new AddTestCasesPage(browsersService);
        updateTestCase.title.clear();
        updateTestCase.title.sendKeys(testCase.getNewTestCaseName());
        updateTestCase.preconditions.sendKeys(testCase.getPreconditionText());
        updateTestCase.steps.sendKeys(testCase.getStepText());
        updateTestCase.expectedResult.sendKeys(testCase.getExpectedResultText());
        updateTestCase.addTestCaseButton.click();

        return new OpenProjectPage(browsersService, false);
    }

    @Step("Удаление тест кейса '{testCaseName}'")
    public OpenProjectPage deleteTestCase(TestCase testCase){

        LoginSteps loginSteps = new LoginSteps(browsersService);
        DashboardPage dashboardPage = loginSteps.loginWithCorrectCredentials("atrostyanko+0401@gmail.com", "QqtRK9elseEfAk6ilYcJ");
        dashboardPage.getProjectWithTestCases(testCase.getProjectName()).click();
        OpenProjectPage openProjectPage = new OpenProjectPage(browsersService,false);
        openProjectPage.getAllTestCases.click();
        openProjectPage.getTestCase(testCase.getTestCaseName()).click();
        openProjectPage.editButton.click();
        AddTestCasesPage deleteTestCase = new AddTestCasesPage(browsersService);
        deleteTestCase.deleteTestCaseButton.click();
        DeleteConfirm deleteConfirm = new DeleteConfirm(browsersService);
        deleteConfirm.markAsDelete.click();

        return new OpenProjectPage(browsersService,false);
    }
}