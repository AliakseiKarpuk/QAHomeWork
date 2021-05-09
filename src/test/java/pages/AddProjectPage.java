package pages;

import baseEntities.BasePage;
import core.BrowsersService;
import enums.ProjectType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import wrappers.Checkbox;

public class AddProjectPage extends BasePage {

    private static String END_POINT = "index.php?/admin/projects/add/1";

    @FindBy(id = "name")
    public WebElement nameInput;
     @FindBy(id = "announcement")
    public WebElement announcementInput;
     @FindBy(id = "show_announcement")
    public Checkbox isShowAnnouncement;
     @FindBy(id = "suite_mode_single")
    public WebElement singleSuiteMode;
     @FindBy(id = "suite_mode_single_baseline")
    public WebElement singleSuiteModeBaseline;
     @FindBy(id = "suite_mode_multi")
    public WebElement multipleSuiteMode;
     @FindBy(id = "accept")
    public WebElement addProjectButton;


    public AddProjectPage(BrowsersService browsersService, boolean openPageByUrl) {
        super(browsersService, openPageByUrl);
    }

    @Override
    protected void openPage() {
        driver.get(baseUrl+END_POINT);
    }

    @Override
    public boolean isPageOpened() {
        try {
            return browsersService.getWaits().waitForVisibility(addProjectButton).isDisplayed();
        } catch (Exception ex) {
            return false;
        }
    }

}
