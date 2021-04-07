package pages;

import baseEntities.BasePage;
import core.BrowsersService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProjectPage extends BasePage {

    private static String END_POINT = "index.php?/admin/projects/overview";
    protected static final By successTextBy = By.cssSelector(".message.message-success");
    protected static final By projectSingleTestSuiteNameBy = By.xpath("//a[text()='AKarpuk_01']");
    protected static final By projectSingleWithBaselineNameBy = By.xpath("//a[text()='AKarpuk_02']");
    protected static final By projectMultipleNameBy = By.xpath("//a[text()='AKarpuk_03']");
    protected static final By addProjectButtonBy = By.className("content-header-title page_title");

    public ProjectPage(BrowsersService browsersService, boolean openPageByUrl) {
        super(browsersService, openPageByUrl);
    }

    @Override
    protected void openPage() {
        driver.get(baseUrl + END_POINT);

    }

    @Override
    public boolean isPageOpened() {
        try{
            return driver.findElement(addProjectButtonBy).isDisplayed();
        }catch (Exception ex){

            return false;
        }
    }

    public String successText(){ return driver.findElement(successTextBy).getText();}
    public WebElement singleTestSuiteName(){return driver.findElement(projectSingleTestSuiteNameBy);}
    public WebElement singleWithBaselineName(){return driver.findElement(projectSingleWithBaselineNameBy);}
    public WebElement multipleName(){ return driver.findElement(projectMultipleNameBy);}

}
