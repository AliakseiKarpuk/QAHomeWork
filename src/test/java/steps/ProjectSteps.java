package steps;

import baseEntities.BaseStep;
import core.BrowsersService;
import io.qameta.allure.Step;
import pages.*;
import pages.dialogs.DeleteConfirm;

public class ProjectSteps extends BaseStep {

    private LoginSteps  loginSteps;
    private AddProjectPage addProjectPage;

    public ProjectSteps(BrowsersService browsersService) {
        super(browsersService);
        loginSteps = new LoginSteps(browsersService);
    }

    @Step("Добавление проекта с разынми параметрами {name} , {announcement} , {value}")
    public ProjectPage AddProjectStep(String name, String announcement, String value) {
       ProjectSteps projectPage = loginSteps
                .loginWithCorrectCredential("atrostyanko+0401@gmail.com", "QqtRK9elseEfAk6ilYcJ");
       projectPage
                .inputName(name)
                .announcementInput(announcement)
                .getSuiteMode(value)
                .isShowAnnouncement()
                .clickAddProjectbutton();

//        AddProjectPage addProjectPage = new AddProjectPage(browsersService,true);
//        addProjectPage.nameInput.sendKeys(name);
//        addProjectPage.announcementInput.sendKeys("12345");
//        addProjectPage.isShowAnnouncement.click();
//        addProjectPage.addProjectRadioButton.selectByValue("1");
//        addProjectPage.addProjectButton.click();

        return new ProjectPage(browsersService, false);
    }

    @Step("Обновление проекта {projectName}")
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
        editProjectPage.editIsShowAnnouncement.click();

        editProjectPage.projectRadioButton.selectByValue("1");
        editProjectPage.isComplete.click();
        editProjectPage.saveProjectButton.click();
        return new ProjectPage(browsersService,false);
    }

    @Step("Удаление проекта {projectName}")
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

    private ProjectSteps inputName(String name){

        addProjectPage.nameInput.sendKeys(name);

       return this;
    }

    private ProjectSteps announcementInput(String announcement){

        addProjectPage.announcementInput.sendKeys(announcement);

        return this;
    }

    private ProjectSteps isShowAnnouncement(){
        addProjectPage.isShowAnnouncement.click();
        return this;
    }

    private ProjectSteps getSuiteMode(String value){
        addProjectPage.addProjectRadioButton.selectByValue(value);
        return this;
    }

    private ProjectSteps getSuiteMode(int number){
        addProjectPage.addProjectRadioButton.selectByNumber(number);
        return this;
    }

    private ProjectSteps getSuiteModeByName(String optionName){
        addProjectPage.addProjectRadioButton.selectByOpiton(optionName);
        return this;
    }

    private ProjectSteps clickAddProjectbutton(){
        addProjectPage.addProjectButton.click();
        return this;
    }

}
