package pages;

import baseEntities.BasePage;
import core.BrowsersService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class iFrameOnlinerPage extends BasePage {

    private static final By searchInputBy = By.className("fast-search__input");
    private static final By iFrameSearchBy = By.className("modal-iframe");
    private static final By firstProductNameBy = By.className("product__title-link");
    private static final By searchInFrameBy = By.className("search__input");
    private static final By confirmBy = By.className("catalog-masthead__title");
    private static final By selectFirstProductBy = By.className("product__title-link");
    private static final By seenElementBy = By.className("footer-style__link");


    public iFrameOnlinerPage(BrowsersService browsersService, boolean openPageByUrl) {
        super(browsersService, openPageByUrl);
    }

    @Override
    protected void openPage() {
        driver.get("https://www.onliner.by/");
    }

    @Override
    public boolean isPageOpened() {
        return fastSearchInput().isDisplayed();
    }

    public WebElement fastSearchInput(){
      return  browsersService.getWaits().waitForVisibility(searchInputBy);
    }

    public WebElement iFrameSearch(){
        return browsersService.getWaits().waitForVisibility(iFrameSearchBy);
    }

    public String firstProductName(){
        return browsersService.getWaits().waitForVisibility(firstProductNameBy).getText();
    }

    public WebElement searchInFrame(){
        return browsersService.getWaits().waitForVisibility(searchInFrameBy);
    }

    public String confirm(){
        return browsersService.getWaits().waitForVisibility(confirmBy).getText();
    }

    public WebElement selectFirstProduct(){
        return browsersService.getWaits().waitForVisibility(selectFirstProductBy);
    }

    public WebElement seenElement(){
        return browsersService.getWaits().waitForVisibility(seenElementBy);
    }
}
