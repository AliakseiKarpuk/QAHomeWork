package tests;

import baseEntities.BaseTest;
import enums.ProjectType;
import models.Project;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddProjectPage;
import pages.DashboardPage;
import pages.LoginPage;
import steps.LoginSteps;
import steps.ProjectSteps;

public class SmokeTest1 extends BaseTest {

    @Test
    public void LoginTest() {
/*
        1. Запустить драйвер
        2. Перейти на сайт
        3. Ввести логин
        4. Ввести пароль
        5. Нажать Login
        6. Dashboard page отобразился
*/
        LoginSteps loginSteps = new LoginSteps(browsersService);
        loginSteps.loginWithCorrectCredentials("atrostyanko+0401@gmail.com", "QqtRK9elseEfAk6ilYcJ");

        Assert.assertEquals(browsersService.getDriver().getTitle(), "All Projects - TestRail");
    }

    @Test
    public void LoginTestWithIncorrectCredentials() {
/*
        1. Запустить драйвер
        2. Перейти на сайт
        3. Ввести логин
        4. Ввести пароль
        5. Нажать Login
        6. Dashboard page отобразился
*/
        LoginSteps loginSteps = new LoginSteps(browsersService);
        LoginPage loginPage = loginSteps.loginWithIncorrectCredentials("test@gmail.com", "qweqwe");

        Assert.assertEquals(loginPage.getErrorText(),
                "Email/Login or Password is incorrect. Please try again.");
    }

    @Test
    public void AddNewProjectTes() {
        LoginSteps loginSteps = new LoginSteps(browsersService);
        DashboardPage dashboardPage = loginSteps
                .loginWithCorrectCredentials("atrostyanko+0401@gmail.com", "QqtRK9elseEfAk6ilYcJ");

        dashboardPage.getSidebarProjectsAddButton().click();

        Project project = new Project();
        project.setName("Test Project AT");
        project.setAnnouncement("Test Project Definition");
        project.setShowAnnouncement(true);
        project.setType(ProjectType.MULTIPLE);

        ProjectSteps projectSteps = new ProjectSteps(browsersService);
        projectSteps.AddProject(project);
    }

    @Test
    public void AddProjectWithSingleSuiteMode(){
        LoginSteps loginSteps = new LoginSteps(browsersService);
        AddProjectPage addProjectPage = loginSteps.loginWithIncorrectCredential("atrostyanko+0401@gmail.com", "QqtRK9elseEfAk6ilYcJ");

        addProjectPage.getNameInput().sendKeys("AKarpuk_01");
        addProjectPage.getAnnouncementInput().sendKeys("12132");
        addProjectPage.getIsShowAnnouncement().click();
        addProjectPage.getSingleSuiteMode().click();
        addProjectPage.getAddProjectButton().click();

        Assert.assertEquals(addProjectPage.getAssertForSingleSuitemode(),"AKarpuk_01");

    }

    @Test
    public void AddProjectWithSingleSuiteModeBaseline(){
        LoginSteps loginSteps = new LoginSteps(browsersService);
        AddProjectPage addProjectPage = loginSteps.loginWithIncorrectCredential("atrostyanko+0401@gmail.com", "QqtRK9elseEfAk6ilYcJ");

        addProjectPage.getNameInput().sendKeys("AKarpuk_02");
        addProjectPage.getAnnouncementInput().sendKeys("12132");
        addProjectPage.getSingleSuiteModeBaseline().click();
        addProjectPage.getAddProjectButton().click();

        Assert.assertEquals(addProjectPage.getAssertForSingleSuitemodeBaseline(),"AKarpuk_02");

    }

    @Test
    public void AddProjectWithMultipleSuiteMode(){
        LoginSteps loginSteps = new LoginSteps(browsersService);
        AddProjectPage addProjectPage = loginSteps.loginWithIncorrectCredential("atrostyanko+0401@gmail.com", "QqtRK9elseEfAk6ilYcJ");

        addProjectPage.getNameInput().sendKeys("AKarpuk_03");
        addProjectPage.getMultipleSuiteMode().click();
        addProjectPage.getAddProjectButton().click();

        Assert.assertEquals(addProjectPage.getAssertForMultipleSuitemode(),"AKarpuk_03");

    }
}
