package steps;

import baseEntities.BaseStep;
import core.BrowsersService;
import enums.ProjectType;
import models.Project;
import pages.AddProjectPage;
import pages.ProjectPage;

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

    public void UpdateProject() {

    }

    public void DeleteProject(Project project) {

    }
}
