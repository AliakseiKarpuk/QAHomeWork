package pages;

import baseEntities.BasePage;
import core.BrowsersService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import wrappers.Table;

import java.util.List;

public class ProjectPage extends BasePage {

    private static String END_POINT = "index.php?/admin/projects/overview";

    @FindBy(className = "content-header-title page_title")
    public WebElement addProjectButton;

//    @FindBy(id = "tbody>tr>td>a")
//    public WebElement allProjects;

    @FindBy(id = "top-logo")
    public WebElement logoIsfind;
    @FindBy(css = ".message.message-success")
    public WebElement getSuccessText;

    protected static final By allProjects = By.cssSelector("tbody>tr>td>a");
    protected static final String deleteProjectButtonBy ="//a[text()='remove']/following::div[@class='icon-small-delete']";
    protected static final By tableBy = By.className("grid");


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
            return browsersService.getWaits().waitForVisibility(logoIsfind).isDisplayed();
        }catch (Exception ex){

            return false;
        }
    }

    public WebElement getDeleteProjectButton(String projectName){ return driver.findElement(By.xpath(deleteProjectButtonBy.replace("remove", projectName))); }
    public Table projectTable = new Table(driver, tableBy);

    public boolean checkProjectList(String projectName){
        List<WebElement> list = driver.findElements(allProjects);
        int count = 0;
        for (WebElement option : list){
            if(option.getText().equals(projectName)){
                return true;
            }
        }
        return false;
    }

    public boolean selectProject(String projectName){
        List<WebElement> list = driver.findElements(allProjects);
        for (WebElement option : list){
            if(option.getText().equals(projectName)){
                option.click();
                break;
            }
        }
        return true;
    }

    public boolean deleteSelectProject(String projectName){
        List<WebElement> list = driver.findElements(allProjects);
        for (WebElement option : list){
            if(option.getText().equals(projectName)){
                getDeleteProjectButton(projectName).click();
                break;
            }
        }
        return true;
    }
}
