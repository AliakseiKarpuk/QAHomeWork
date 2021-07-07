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
    public ProjectPage AddProject(Project project) {
        LoginSteps loginSteps = new LoginSteps(browsersService);
        loginSteps.loginWithCorrectCredentials("atrostyanko+0401@gmail.com", "QqtRK9elseEfAk6ilYcJ");
        AddProjectPage addProjectPage = new AddProjectPage(browsersService,true);
        addProjectPage.nameInput.sendKeys(project.getName());
        addProjectPage.announcementInput.sendKeys(project.getAnnouncement());
        addProjectPage.addProjectRadioButton.selectByValue(project.getValue());
        addProjectPage.isShowAnnouncement.click();
        addProjectPage.addProjectButton.click();

        return new ProjectPage(browsersService,false);
    }

    @Step("Обновление проекта '{projectName}'")
    public ProjectPage UpdateProject(Project project) {
        LoginSteps loginSteps = new LoginSteps(browsersService);
        loginSteps.loginWithCorrectCredentials("atrostyanko+0401@gmail.com", "QqtRK9elseEfAk6ilYcJ");
        ProjectPage projectPage = new ProjectPage(browsersService,true);
        projectPage.selectProject(project.getName());
        EditProjectPage editProjectPage = new EditProjectPage(browsersService,false);
        editProjectPage.editName.clear();
        editProjectPage.editName.sendKeys(project.getNewName());
        editProjectPage.editAnnouncement.clear();
        editProjectPage.editAnnouncement.sendKeys(project.getAnnouncement());
        editProjectPage.editIsShowAnnouncement.click();
        editProjectPage.projectRadioButton.selectByValue(project.getValue());
        editProjectPage.isComplete.click();
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
