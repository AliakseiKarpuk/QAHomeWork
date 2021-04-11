package pages;

import baseEntities.BasePage;
import core.BrowsersService;

public class AllTestCasesPage extends BasePage {


    public AllTestCasesPage(BrowsersService browsersService, boolean openPageByUrl) {
        super(browsersService, openPageByUrl);
    }

    @Override
    protected void openPage() {

    }

    @Override
    public boolean isPageOpened() {
        return false;
    }
}
