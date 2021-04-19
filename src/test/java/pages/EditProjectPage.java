package pages;

import baseEntities.BasePage;
import core.BrowsersService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import wrappers.Checkbox;
import wrappers.RadioButton;

public class EditProjectPage extends BasePage {

    protected static final By editNameBy = By.id("name");
    protected static final By editAnnouncementBy = By.id("announcement");
    protected static final By editIsShowAnnouncementBy = By.id("show_announcement");
    protected static final By singleSuiteModeBy = By.id("suite_mode_single");
    protected static final By singleSuiteModeBaselineBy = By.id("suite_mode_single_baseline");
    protected static final By multipleSuiteModeBy = By.id("suite_mode_multi");
    protected static final By isCompleteBy = By.id("is_completed");
    protected static final By saveProjectButtonBy  = By.id("accept");
    protected static final By radioButtonBy = By.cssSelector("[class='table']");

    public EditProjectPage(BrowsersService browsersService, boolean openPageByUrl) {
        super(browsersService, openPageByUrl);
    }

    @Override
    protected void openPage() {
        driver.get(baseUrl);
    }

    @Override
    public boolean isPageOpened() {
        return getEditName().isDisplayed();
    }

    public WebElement getEditName(){ return driver.findElement(editNameBy);}
    public WebElement getEditAnnouncement(){ return driver.findElement(editAnnouncementBy);}
    public Checkbox getEditIsShowAnnouncement(){ return new Checkbox(driver, editIsShowAnnouncementBy);}
    public WebElement getSingleSuiteMode(){ return driver.findElement(singleSuiteModeBy);}
    public WebElement getSingleSuiteModeBaseline(){ return driver.findElement(singleSuiteModeBaselineBy);}
    public WebElement getMultipleSuiteMode(){ return driver.findElement(multipleSuiteModeBy);}
    public Checkbox getIsComplete(){ return new Checkbox(driver, isCompleteBy);}
    public WebElement getSaveProjectButton(){ return driver.findElement(saveProjectButtonBy);}

    public RadioButton projectRadioButton = new RadioButton(driver, radioButtonBy);

}
