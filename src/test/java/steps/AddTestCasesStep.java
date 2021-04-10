package steps;

import baseEntities.BaseStep;
import core.BrowsersService;
import pages.AddTestCasesPage;
import pages.DashboardPage;
import pages.OpenProjectPage;

public class AddTestCasesStep extends BaseStep {


    public AddTestCasesStep(BrowsersService browsersService) {
        super(browsersService);
    }

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
        addTestCasesPage.getAddTestCaseButton().click();
        openProjectPage.getAllTestCasesButton().click();

        return new OpenProjectPage(browsersService,false);

    }

//    public OpenProjectPage updateTestCase(String projectName, String testCaseName, String newTestCaseName, String preconditionsText, String stepText, String expectedResultText){
//        LoginSteps loginSteps = new LoginSteps(browsersService);
//        DashboardPage dashboardPage = loginSteps.loginWithCorrectCredentials("atrostyanko+0401@gmail.com", "QqtRK9elseEfAk6ilYcJ");
//        dashboardPage.getProjectWithTestCases(projectName).click();
//        OpenProjectPage openProjectPage = new OpenProjectPage(browsersService,false);
//        openProjectPage.getAllTestCasesButton().click();
//        openProjectPage.getOpenTestCaseButton(testCaseName).click();
//        openProjectPage.getEditButton();
//        AddTestCasesPage addTestCasesPage = new AddTestCasesPage(browsersService,false);
//        addTestCasesPage.getTitleInput().sendKeys(newTestCaseName);
//        addTestCasesPage.getPreconditions().sendKeys(preconditionsText);
//        addTestCasesPage.getSteps().sendKeys(stepText);
//        addTestCasesPage.getExpectedResult().sendKeys(expectedResultText);
//        addTestCasesPage.getAddTestCaseButton().click();
//        openProjectPage.getAllTestCasesButton().click();
//
//        return new OpenProjectPage(browsersService, false);
//
//    }
}