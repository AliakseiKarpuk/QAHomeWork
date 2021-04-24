package steps;

import baseEntities.BaseStep;
import core.BrowsersService;
import enums.ProjectType;
import models.Project;
import pages.AddProjectPage;
import pages.EditProjectPage;
import pages.ProjectPage;
import pages.dialogs.DeleteConfirm;

public class ProjectSteps extends BaseStep {

    public ProjectSteps(BrowsersService browsersService) {
        super(browsersService);
    }

    public ProjectPage AddProject(String name, ProjectType projectType) {

        LoginSteps loginSteps = new LoginSteps(browsersService);
        loginSteps.loginWithCorrectCredentials("atrostyanko+0401@gmail.com", "QqtRK9elseEfAk6ilYcJ");
        AddProjectPage addProjectPage = new AddProjectPage(browsersService,true);
        addProjectPage.getNameInput().sendKeys(name);
        addProjectPage.getAnnouncementInput().sendKeys("12345");
        addProjectPage.getIsShowAnnouncement().click();
        switch (projectType){
            case MULTIPLE: addProjectPage.getMultipleSuiteMode().click();
            break;
            case SINGLE_FOR_ALL_CASES: addProjectPage.getSingleSuiteMode().click();
            break;
            case SINGLE_WITH_BASELINE: addProjectPage.getSingleSuiteModeBaseline().click();
            break;
        }
        addProjectPage.getAddProjectButton().click();

        return new ProjectPage(browsersService,false);
    }

    public ProjectPage UpdateProject(String projectName, String newProjectName, String newAnnouncement) {

        LoginSteps loginSteps = new LoginSteps(browsersService);
        loginSteps.loginWithCorrectCredentials("atrostyanko+0401@gmail.com", "QqtRK9elseEfAk6ilYcJ");

        ProjectPage projectPage = new ProjectPage(browsersService,true);
        projectPage.selectProject(projectName);
        EditProjectPage editProjectPage = new EditProjectPage(browsersService,false);

       // editProjectPage.dropDownHelp.selectElementInDropDown("Gurock Blog");

        editProjectPage.getEditName().clear();
        editProjectPage.getEditName().sendKeys(newProjectName);
        editProjectPage.getEditAnnouncement().clear();
        editProjectPage.getEditAnnouncement().sendKeys(newAnnouncement);
        editProjectPage.getEditIsShowAnnouncement().turnOn();

        editProjectPage.projectRadioButton.selectByName("Use a single repository for all cases (recommended)");
        //editProjectPage.projectRadioButton.selectByNumber(1);
        //editProjectPage.projectRadioButton.selectByValue(3);

        editProjectPage.getIsComplete().turnOff();
        editProjectPage.getSaveProjectButton().click();
        return new ProjectPage(browsersService,false);
    }

    public ProjectPage DeleteProject(String projectName) {

        LoginSteps loginSteps = new LoginSteps(browsersService);
        loginSteps.loginWithCorrectCredentials("atrostyanko+0401@gmail.com", "QqtRK9elseEfAk6ilYcJ");
        ProjectPage projectPage = new ProjectPage(browsersService,true);
        projectPage.deleteSelectProject(projectName);
        DeleteConfirm deleteConfirm = new DeleteConfirm(browsersService);
        deleteConfirm.confirmDelete().click();
        deleteConfirm.okButton().click();

        return new ProjectPage(browsersService,false);

    }

}
