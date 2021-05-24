package steps;

import baseEntities.BaseStep;
import core.BrowsersService;
import io.qameta.allure.Step;
import pages.AddTestCasesPage;
import pages.DashboardPage;
import pages.OpenProjectPage;
import pages.dialogs.DeleteConfirm;

public class AddTestCasesStep extends BaseStep {


    public AddTestCasesStep(BrowsersService browsersService) {
        super(browsersService);
    }

    @Step("Добавление тест кейса с разными параметрами")
    public OpenProjectPage addTestCases(String projectName, String testCaseName, String preconditionsText, String stepText, String expectedResultText){
        LoginSteps loginSteps = new LoginSteps(browsersService);
        DashboardPage dashboardPage = loginSteps.loginWithCorrectCredentials("atrostyanko+0401@gmail.com", "QqtRK9elseEfAk6ilYcJ");
        dashboardPage.getProjectWithTestCases(projectName).click();

        OpenProjectPage openProjectPage = new OpenProjectPage(browsersService,false);
        openProjectPage.addTestCasesButton.click();

        AddTestCasesPage addTestCasesPage = new AddTestCasesPage(browsersService,false);
        addTestCasesPage.title.sendKeys(testCaseName);
        addTestCasesPage.preconditions.sendKeys(preconditionsText);
        addTestCasesPage.steps.sendKeys(stepText);
        addTestCasesPage.expectedResult.sendKeys(expectedResultText);
        addTestCasesPage.addTestCaseButton.click();
        openProjectPage.getAllTestCases.click();

        return new OpenProjectPage(browsersService,false);

    }

    @Step("Обновление тест кейса {testCaseName} с разными параметрами")
    public OpenProjectPage updateTestCase(String projectName, String testCaseName, String newTestCaseName, String preconditionsText, String stepText, String expectedResultText) {

        LoginSteps loginSteps = new LoginSteps(browsersService);
        DashboardPage dashboardPage = loginSteps.loginWithCorrectCredentials("atrostyanko+0401@gmail.com", "QqtRK9elseEfAk6ilYcJ");
        dashboardPage.getProjectWithTestCases(projectName).click();

        OpenProjectPage openProjectPage = new OpenProjectPage(browsersService,false);
        openProjectPage.allTestCases.click();
        openProjectPage.getTestCase(testCaseName).click();
        openProjectPage.editButton.click();

        AddTestCasesPage updateTestCase = new AddTestCasesPage(browsersService);
        updateTestCase.title.clear();
        updateTestCase.title.sendKeys(newTestCaseName);
        updateTestCase.preconditions.sendKeys(preconditionsText);
        updateTestCase.steps.sendKeys(stepText);
        updateTestCase.expectedResult.sendKeys(expectedResultText);
        updateTestCase.addTestCaseButton.click();

        return new OpenProjectPage(browsersService, false);
    }

    @Step("Удаление тест кейса {testCaseName} с разными параметрами")
    public OpenProjectPage deleteTestCase(String projectName, String testCaseName){

        LoginSteps loginSteps = new LoginSteps(browsersService);
        DashboardPage dashboardPage = loginSteps.loginWithCorrectCredentials("atrostyanko+0401@gmail.com", "QqtRK9elseEfAk6ilYcJ");
        dashboardPage.getProjectWithTestCases(projectName).click();

        OpenProjectPage openProjectPage = new OpenProjectPage(browsersService,false);
        openProjectPage.allTestCases.click();
        openProjectPage.getTestCase(testCaseName).click();
        openProjectPage.editButton.click();

        AddTestCasesPage deleteTestCase = new AddTestCasesPage(browsersService);
        deleteTestCase.deleteTestCaseButton.click();

        DeleteConfirm deleteConfirm = new DeleteConfirm(browsersService);
        deleteConfirm.markAsDelete.click();

        return new OpenProjectPage(browsersService,false);
    }
}