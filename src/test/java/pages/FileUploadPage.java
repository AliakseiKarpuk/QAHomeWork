package pages;

import baseEntities.BasePage;
import core.BrowsersService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FileUploadPage extends BasePage {

    private static String END_POINT = "upload";
    private static final By uploadButtonBy = By.xpath("//input[@type='file']");
    private static final By startUploadButtonBy =  By.id("file-submit");
    private static final By fileNameBy = By.id("uploaded-files");

    public FileUploadPage(BrowsersService browsersService, boolean openPageByUrl) {
        super(browsersService, openPageByUrl);
    }

    @Override
    protected void openPage() {
driver.get(baseUrl+END_POINT);
    }

    @Override
    public boolean isPageOpened() {
        return getUploadButton().isDisplayed();
    }

    public WebElement getUploadButton(){
        return driver.findElement(uploadButtonBy);
    }

    public WebElement getStarUploadButton(){
        return driver.findElement(startUploadButtonBy);
    }

    public String getFileName(){
        return driver.findElement(fileNameBy).getText();
    }
}
