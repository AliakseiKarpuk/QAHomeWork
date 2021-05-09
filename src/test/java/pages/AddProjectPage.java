package pages;

import baseEntities.BasePage;
import core.BrowsersService;
import enums.ProjectType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import wrappers.Checkbox;
import wrappers.RadioButton;

public class AddProjectPage extends BasePage {

    private static String END_POINT = "index.php?/admin/projects/add/1";

    @FindBy(id = "name")
    public WebElement nameInput;
    @FindBy(id = "announcement")
    public WebElement announcementInput;
    @FindBy(id = "show_announcement")
    public WebElement isShowAnnouncement;
    @FindBy(id = "accept")
    public WebElement addProjectButton;

    private static final By addProjectRadioButtonBy = By.name("suite_mode");

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
    public RadioButton addProjectRadioButton = new RadioButton(driver, addProjectRadioButtonBy );
}
