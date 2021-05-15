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

    @Step("Добавление тест кейса '{testCaseName}' с разными значениями")
    public OpenProjectPage addTestCases(String projectName, String testCaseName, String preconditionsText, String stepText, String expectedResultText){
        LoginSteps loginSteps = new LoginSteps(browsersService);
        DashboardPage dashboardPage = loginSteps.loginWithCorrectCredentials("atrostyanko+0401@gmail.com", "QqtRK9elseEfAk6ilYcJ");
        dashboardPage.getProjectWithTestCases(projectName).click();
        OpenProjectPage openProjectPage = new OpenProjectPage(browsersService,false);
        openProjectPage.getAddTestCasesButton().click();
        AddTestCasesPage addTestCasesPage = new AddTestCasesPage(browsersService,false);
        addTestCasesPage.getTitleInput().sendKeys(testCaseName);
        addTestCasesPage.getPreconditions().sendKeys(preconditionsText);
        addTestCasesPage.getSteps().sendKeys(stepText);
        addTestCasesPage.getExpectedResult().sendKeys(expectedResultText);
        addTestCasesPage.getAcceptCaseButton().click();
        openProjectPage.getAllTestCasesButton().click();

        return new OpenProjectPage(browsersService,false);

    }

    @Step("Обновление тест кейса '{testCaseName}' с разными значениями")
    public OpenProjectPage updateTestCase(String projectName, String testCaseName, String newTestCaseName, String preconditionsText, String stepText, String expectedResultText) {

        LoginSteps loginSteps = new LoginSteps(browsersService);
        DashboardPage dashboardPage = loginSteps.loginWithCorrectCredentials("atrostyanko+0401@gmail.com", "QqtRK9elseEfAk6ilYcJ");
        dashboardPage.getProjectWithTestCases(projectName).click();
        OpenProjectPage openProjectPage = new OpenProjectPage(browsersService,false);
        openProjectPage.getAllTestCasesButton().click();
        openProjectPage.getTestCase(testCaseName).click();
        openProjectPage.getEditButton().click();
        AddTestCasesPage updateTestCase = new AddTestCasesPage(browsersService);
        updateTestCase.getTitleInput().clear();
        updateTestCase.getTitleInput().sendKeys(newTestCaseName);
        updateTestCase.getPreconditions().sendKeys(preconditionsText);
        updateTestCase.getSteps().sendKeys(stepText);
        updateTestCase.getExpectedResult().sendKeys(expectedResultText);
        updateTestCase.getAcceptCaseButton().click();

        return new OpenProjectPage(browsersService, false);
    }

    @Step("Удаление тест кейса '{testCaseName}'")
    public OpenProjectPage deleteTestCase(String projectName, String testCaseName){

        LoginSteps loginSteps = new LoginSteps(browsersService);
        DashboardPage dashboardPage = loginSteps.loginWithCorrectCredentials("atrostyanko+0401@gmail.com", "QqtRK9elseEfAk6ilYcJ");
        dashboardPage.getProjectWithTestCases(projectName).click();
        OpenProjectPage openProjectPage = new OpenProjectPage(browsersService,false);
        openProjectPage.getAllTestCasesButton().click();
        openProjectPage.getTestCase(testCaseName).click();
        openProjectPage.getEditButton().click();
        AddTestCasesPage deleteTestCase = new AddTestCasesPage(browsersService);
        deleteTestCase.getDeleteTestCaseButton().click();
        DeleteConfirm deleteConfirm = new DeleteConfirm(browsersService);
        deleteConfirm.markAsDeleteButton().click();

        return new OpenProjectPage(browsersService,false);
    }
}