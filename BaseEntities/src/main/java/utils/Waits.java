package utils;

import core.BrowsersService;
import core.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Waits {

    private WebDriverWait wait;

    public Waits(WebDriver driver, int timeout) {
        wait = new WebDriverWait(driver, timeout);
    }

    public Waits(WebDriver driver){
        wait = new WebDriverWait(driver, new ReadProperties().getTimeout());
    }

    public WebElement waitForVisibility(By by){
      return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public WebElement waitForVisibility(WebElement webElement){
      return wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public boolean waitForInvisibility(By by){
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }
    public boolean waitForInvisibility(WebElement webElement){
        return wait.until(ExpectedConditions.invisibilityOf(webElement));
    }

}
