package pages;

import baseEntities.BasePage;
import core.BrowsersService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContextMenuPage extends BasePage {

    private static String END_POINT = "context_menu";
    private static final By boxBy = By.id("hot-spot");

    public ContextMenuPage(BrowsersService browsersService, boolean openPageByUrl) {
        super(browsersService, openPageByUrl);
    }


    @Override
    protected void openPage() {
        driver.get(baseUrl + END_POINT);
    }

    @Override
    public boolean isPageOpened() {
        return getBox().isDisplayed();
    }

    public WebElement getBox(){
        return browsersService.getWaits().waitForVisibility(boxBy);
    }
}
