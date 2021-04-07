package pages;

import baseEntities.BasePage;
import core.BrowsersService;
import enums.ProjectType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AddProjectPage extends BasePage {

    private static String END_POINT = "index.php?/admin/projects/add/1";
    protected static final By nameInputBy = By.id("name");
    protected static final By announcementInputBy = By.id("announcement");
    protected static final By isShowAnnouncementBy = By.id("show_announcement");
    protected static final By singleSuiteModeBy = By.id("suite_mode_single");
    protected static final By singleSuiteModeBaselineBy = By.id("suite_mode_single_baseline");
    protected static final By multipleSuiteModeBy = By.id("suite_mode_multi");
    protected static final By addProjectButtonBy  = By.id("accept");
    protected static final By successTextBy = By.cssSelector(".message.message-success");

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
            return getAddProjectButton().isDisplayed();
        } catch (Exception ex) {
            return false;
        }
    }

    public WebElement getNameInput(){
        return driver.findElement(nameInputBy);
    }
    public WebElement getAnnouncementInput(){
        return driver.findElement(announcementInputBy);
    }
    public WebElement getIsShowAnnouncement(){
        return driver.findElement(isShowAnnouncementBy);
    }
    public WebElement getSingleSuiteMode(){
        return driver.findElement(singleSuiteModeBy);
    }
    public WebElement getSingleSuiteModeBaseline(){
        return driver.findElement(singleSuiteModeBaselineBy);
    }
    public WebElement getMultipleSuiteMode(){
        return driver.findElement(multipleSuiteModeBy);
    }
    public WebElement getAddProjectButton(){
        return driver.findElement(addProjectButtonBy);
    }
    public String getSuccessText(){ return driver.findElement(successTextBy).getText();}
}
