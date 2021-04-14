package steps;

import baseEntities.BaseStep;
import core.BrowsersService;
import org.openqa.selenium.Alert;
import org.openqa.selenium.interactions.Actions;
import pages.ContextMenuPage;

public class ContextMenuStep extends BaseStep {
    public ContextMenuStep(BrowsersService browsersService) {
        super(browsersService);
    }

    public void contextMenuStep(){

        ContextMenuPage contextMenuPage = new ContextMenuPage(browsersService,true);

        Actions actions = new Actions(browsersService.getDriver());
        actions.contextClick(contextMenuPage.getBox()).build().perform();

    }
}
