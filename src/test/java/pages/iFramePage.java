package pages;

import baseEntities.BasePage;
import core.BrowsersService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class iFramePage extends BasePage {

    private static final String END_POINT = "iframe";
    private static final By iFrameIDBy = By.id("mce_0_ifr");
    private static final By inputTextBy = By.id("tinymce");
    private static final By alignCenterButtonBy = By.cssSelector("button[aria-label='Align center']");
   // private static final By areaPressedBy = By.


    public iFramePage(BrowsersService browsersService, boolean openPageByUrl) {
        super(browsersService, openPageByUrl);
    }

    @Override
    protected void openPage() {
        driver.get(baseUrl + END_POINT);
    }

    @Override
    public boolean isPageOpened() {
        return iFrameID().isDisplayed();
    }

    public WebElement iFrameID(){
        return driver.findElement(iFrameIDBy);
    }
    public WebElement inputText(){
        return driver.findElement(inputTextBy);
    }
    public WebElement alignCenterButton(){
        return driver.findElement(alignCenterButtonBy);
    }
}
