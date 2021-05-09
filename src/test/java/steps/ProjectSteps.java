package steps;

import baseEntities.BaseStep;
import core.BrowsersService;
import enums.ProjectType;
import io.qameta.allure.Step;
import models.Project;
import pages.AddProjectPage;
import pages.EditProjectPage;
import pages.ProjectPage;
import pages.dialogs.DeleteConfirm;

public class ProjectSteps extends BaseStep {

    public ProjectSteps(BrowsersService browsersService) {
        super(browsersService);
    }

    @Step("Добавление проекта с разыми значениями ")
    public ProjectPage AddProject(String name, ProjectType projectType) {

        LoginSteps loginSteps = new LoginSteps(browsersService);
        loginSteps.loginWithCorrectCredentials("atrostyanko+0401@gmail.com", "QqtRK9elseEfAk6ilYcJ");

        AddProjectPage addProjectPage = new AddProjectPage(browsersService,true);
        addProjectPage.nameInput.sendKeys(name);
        addProjectPage.announcementInput.sendKeys("12345");
        addProjectPage.isShowAnnouncement.turnOn();
        addProjectPage.addProjectButton.click();

        return new ProjectPage(browsersService,false);
    }

    @Step("Обновление проекта '{projectName}'")
    public ProjectPage UpdateProject(String projectName, String newProjectName, String newAnnouncement) {

        LoginSteps loginSteps = new LoginSteps(browsersService);
        loginSteps.loginWithCorrectCredentials("atrostyanko+0401@gmail.com", "QqtRK9elseEfAk6ilYcJ");

        ProjectPage projectPage = new ProjectPage(browsersService,true);
        projectPage.selectProject(projectName);

        EditProjectPage editProjectPage = new EditProjectPage(browsersService,false);
        editProjectPage.editName.clear();
        editProjectPage.editName.sendKeys(newProjectName);
        editProjectPage.editAnnouncement.clear();
        editProjectPage.editAnnouncement.sendKeys(newAnnouncement);
        editProjectPage.editIsShowAnnouncement.turnOn();
        editProjectPage.projectRadioButton.selectByValue("1");
        editProjectPage.isComplete.turnOff();
        editProjectPage.saveProjectButton.click();

        return new ProjectPage(browsersService,false);
    }

    @Step("Удаление проекта '{projectName}'")
    public ProjectPage DeleteProject(String projectName) {

        LoginSteps loginSteps = new LoginSteps(browsersService);
        loginSteps.loginWithCorrectCredentials("atrostyanko+0401@gmail.com", "QqtRK9elseEfAk6ilYcJ");
        ProjectPage projectPage = new ProjectPage(browsersService,true);
        projectPage.deleteSelectProject(projectName);
        DeleteConfirm deleteConfirm = new DeleteConfirm(browsersService);
        deleteConfirm.confirmDelete.click();
        deleteConfirm.okButton.click();

        return new ProjectPage(browsersService,false);

    }

}
