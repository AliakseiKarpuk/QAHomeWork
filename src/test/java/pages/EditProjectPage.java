package pages;

import baseEntities.BasePage;
import core.BrowsersService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import wrappers.Checkbox;
import wrappers.DropDown;
import wrappers.RadioButton;

public class EditProjectPage extends BasePage {

    @FindBy(id = "name")
    public WebElement editName;
     @FindBy(id = "announcement")
    public WebElement editAnnouncement;
     @FindBy(id = "show_announcement")
    public Checkbox editIsShowAnnouncement;
     @FindBy(id = "is_completed")
    public Checkbox isComplete;
     @FindBy(id = "accept")
    public WebElement saveProjectButton;

    protected static final By radioButtonBy = By.name("suite_mode");
    protected static final By helpDropDownBy = By.id("navigation-menu");

    public EditProjectPage(BrowsersService browsersService, boolean openPageByUrl) {
        super(browsersService, openPageByUrl);
    }

    @Override
    protected void openPage() {
        driver.get(baseUrl);
    }

    @Override
    public boolean isPageOpened() {
        return browsersService.getWaits().waitForVisibility(saveProjectButton).isDisplayed();
    }

    public RadioButton projectRadioButton = new RadioButton(driver, radioButtonBy);
    public DropDown dropDownHelp = new DropDown(driver, helpDropDownBy);

}
