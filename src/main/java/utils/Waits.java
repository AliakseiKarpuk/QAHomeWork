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
      return  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='first test case']/following::td[@class='action']")));
    }

}
