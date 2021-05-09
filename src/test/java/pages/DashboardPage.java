package pages;

import baseEntities.BasePage;
import core.BrowsersService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage {
    private static String END_POINT = "index.php?/dashboard";

    @FindBy(id = "sidebar-projects-add")
    public WebElement sidebarProjectsAddButton;

    protected static final String projectWithTestCases = "//a[text()='remove']";

    public DashboardPage(BrowsersService browsersService, boolean openPageByUrl) {
        super(browsersService, openPageByUrl);
    }

    @Override
    protected void openPage() {
        driver.get(baseUrl + END_POINT);
    }

    @Override
    public boolean isPageOpened() {
        try {
            return browsersService.getWaits().waitForVisibility(sidebarProjectsAddButton).isDisplayed();
        } catch (Exception ex) {
            return false;
        }

    }
    public WebElement getProjectWithTestCases(String projectName){
        return driver.findElement(By.xpath(projectWithTestCases.replace("remove", projectName)));
    }
}
