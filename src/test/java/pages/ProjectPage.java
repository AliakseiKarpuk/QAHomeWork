package pages;

import baseEntities.BasePage;
import core.BrowsersService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProjectPage extends BasePage {

    private static String END_POINT = "index.php?/admin/projects/overview";

    protected static final By addProjectButtonBy = By.className("content-header-title page_title");
//    protected static final By allProjects = By.xpath("//tbody/child::tr");
    protected static final By allProjects = By.cssSelector("tbody>tr>td>a");
    protected static final By logoIsfibdBy = By.id("top-logo");
    protected static final By getSuccessTextBy = By.cssSelector(".message.message-success");

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
            return logoIsFind().isDisplayed();
        }catch (Exception ex){

            return false;
        }
    }

    public WebElement logoIsFind(){ return driver.findElement(logoIsfibdBy);}
    public String getSuccessText(){ return driver.findElement(getSuccessTextBy).getText();}

    public boolean checkProjectList(String projectName){
        List<WebElement> list = driver.findElements(allProjects);
        for (WebElement option : list){
            if(option.getText().equals(projectName)){
                return true;
            }
        }
        return false;
    }
}
