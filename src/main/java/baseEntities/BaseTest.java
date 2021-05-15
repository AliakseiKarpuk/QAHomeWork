package baseEntities;

import core.BrowsersService;
import core.ReadProperties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utils.Waits;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {
    public BrowsersService browsersService;
    protected ReadProperties readProperties;
    protected Waits waits;

    @BeforeTest
    public void setupTest() {
        readProperties = new ReadProperties();
    }

//    @BeforeClass
//    public void setupClass(){
//        browsersService = new BrowsersService();
//        readProperties = new ReadProperties();
//        browsersService.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
//        browsersService.getDriver().get(readProperties.getURL());
//        waits = browsersService.getWaits();
//
//    }

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
// @AfterClass
//    public void tearDownClass() {
//        browsersService.getDriver().quit();
//        browsersService = null;
//    }
}
