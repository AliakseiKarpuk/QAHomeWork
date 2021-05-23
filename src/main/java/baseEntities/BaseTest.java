package baseEntities;

import core.BrowsersService;
import core.ReadProperties;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.protocol.HTTP;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utils.Listener;
import utils.Waits;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;

@Listeners(Listener.class)
public abstract class BaseTest {
    public BrowsersService browsersService;
    protected ReadProperties readProperties;
    protected Waits waits;


    @BeforeTest
    public void setupTest() {
        readProperties = new ReadProperties();
        RestAssured.baseURI = ReadProperties.getURL();
        RestAssured.requestSpecification = given()
                .header(HTTP.CONTENT_TYPE, ContentType.JSON)
                .auth().preemptive().basic(ReadProperties.getUsername(), ReadProperties.getPassword());
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
