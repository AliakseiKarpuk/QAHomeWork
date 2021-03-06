package baseEntities;

import core.BrowsersService;
import core.ReadProperties;
import org.testng.annotations.*;
import utils.Waits;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {
    protected BrowsersService browsersService;
    protected ReadProperties readProperties;
    protected Waits waits;

    @BeforeTest
    public void setupTest() {
        readProperties = new ReadProperties();
    }


    @BeforeMethod
    public void setupMethod() {
        browsersService = new BrowsersService();
        readProperties = new ReadProperties();
        browsersService.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
        browsersService.getDriver().get(readProperties.getURL());
        waits = browsersService.getWaits();

    }

    @AfterMethod
    public void tearDownMethod() {
        browsersService.getDriver().quit();
        browsersService = null;
    }
}
