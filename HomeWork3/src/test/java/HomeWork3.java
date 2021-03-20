import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;

public class HomeWork3 {

    @Test
    public void cssTests(){

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("drivers/chromedriver.exe").getFile());
        String absolutePath = file.getAbsolutePath();

        System.setProperty("webdriver.chrome.driver", absolutePath);

        ChromeDriver driver = new ChromeDriver();
        driver.get("https://rabota.by/employer");

        WebElement cssClass = driver.findElement(By.cssSelector(".supernova-search-group__input"));
        cssClass.isEnabled();

        WebElement cssDoubleClass = driver.findElement(By.cssSelector(".bloko-input-wrapper.HH-SearchVacancyDropClusters-SearchInput "));
        cssDoubleClass.isEnabled();

        WebElement cssDescendantClass = driver.findElement(By.cssSelector(".supernova-search-group__input .bloko-input-wrapper"));
        cssDescendantClass.isEnabled();

        WebElement cssId = driver.findElement(By.cssSelector("#topmailru-code"));
        cssId.isEnabled();

        WebElement cssElement = driver.findElement(By.cssSelector("div"));
        cssElement.isEnabled();

        WebElement cssElementWithClass = driver.findElement(By.cssSelector("div.supernova-search-group__submit "));
        cssElementWithClass.isEnabled();

        WebElement cssTwoElements = driver.findElement(By.cssSelector("div,button"));
        cssTwoElements.isEnabled();

        WebElement cssElementsInsideElement = driver.findElement(By.cssSelector("div button.bloko-button_primary"));
        cssElementsInsideElement.isEnabled();

        WebElement cssParentElement = driver.findElement(By.cssSelector("div>button>div"));
        cssParentElement.isEnabled();

        WebElement cssPlacedAfter = driver.findElement(By.cssSelector(".supernova-dashboard-hint-text+button"));
        cssPlacedAfter.isEnabled();

        WebElement cssPrecededElement = driver.findElement(By.cssSelector("script~input"));
        cssPrecededElement.isEnabled();

        WebElement cssAllAtribute = driver.findElement(By.cssSelector("[class]"));
        cssAllAtribute.isEnabled();

        WebElement cssAtributeValue = driver.findElement(By.cssSelector("[class='bloko-link-switch bloko-link-switch_dimmed HH-Supernova-Overlay-Toggle']"));
        cssAtributeValue.isEnabled();

        WebElement cssContains = driver.findElement(By.cssSelector("[title~='Беларусь']"));
        cssContains.isEnabled();

        WebElement cssStartWith = driver.findElement(By.cssSelector("[class|='supernova']"));
        cssStartWith.isEnabled();

        WebElement cssBeginWith = driver.findElement(By.cssSelector("span[class^='super']"));
        cssBeginWith.isEnabled();

        WebElement cssEndsWith = driver.findElement(By.cssSelector("div[class$='item']"));
        cssEndsWith.isEnabled();

        WebElement cssContainsSubstring = driver.findElement(By.cssSelector("div[class*='button']"));
        cssContainsSubstring.isEnabled();

        WebElement cssByName = driver.findElement(By.cssSelector("[name='description']"));
        cssByName.isEnabled();

        driver.quit();
    }

    @Test
    public void xPathTest(){

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("drivers/chromedriver.exe").getFile());
        String absolutePath = file.getAbsolutePath();

        System.setProperty("webdriver.chrome.driver", absolutePath);

        ChromeDriver driver = new ChromeDriver();
        driver.get("https://rabota.by/employer");

        WebElement xPathClass = driver.findElement(By.xpath("//*[@class='supernova-search-group__submit ']"));
        xPathClass.isEnabled();

        WebElement xPathDoubleClass = driver.findElement(By.xpath("//*[@class='bloko-button bloko-button_primary bloko-button_stretched bloko-button_large ']"));
        xPathDoubleClass.isEnabled();

        WebElement xPathDescendant = driver.findElement(By.xpath("//div[@class='supernova-search-group supernova-search-group_vertical ']//div[@class='supernova-search-group__input']"));
        xPathDescendant.isEnabled();

        WebElement xPathId = driver.findElement(By.xpath("//*[@id='topmailru-code']"));
        xPathId.isEnabled();

        WebElement xPathElements = driver.findElement(By.xpath("//div"));
        xPathElements.isEnabled();

        WebElement xPathElementWithClass = driver.findElement(By.xpath("//div[@class='supernova-search-group__submit ']"));
        xPathElementWithClass.isEnabled();

        WebElement xPathTwoElements = driver.findElement(By.xpath("//div//button"));
        xPathTwoElements.isEnabled();

        WebElement xPathElementInside = driver.findElement(By.xpath("//div/button[@class='supernova-link-switch HH-Supernova-Menu-Activator ']"));
        xPathElementInside.isEnabled();

        WebElement xPathAfterElement = driver.findElement(By.xpath("//div/button/script"));
        xPathAfterElement.isEnabled();

        WebElement xPathText = driver.findElement(By.xpath("//*[text()='Беларусь']"));
        xPathText.isEnabled();

        WebElement xPathContainsText = driver.findElement(By.xpath("//*[contains(text(),'Найдите')]"));
        xPathContainsText.isEnabled();

        WebElement xPathOr = driver.findElement(By.xpath("//*[@class='bloko-button bloko-button_primary bloko-button_stretched bloko-button_large ' or contains(@class, 'bloko-column bloko-column_s-4 bloko-column_m-4 bloko-column_l-4')]"));
        xPathOr.isEnabled();

        WebElement xPathAncestor = driver.findElement(By.xpath("//*[@class='bloko-button bloko-button_primary bloko-button_stretched bloko-button_large ']/ancestor::div[@class='supernova-dashboard-content']"));
        xPathAncestor.isEnabled();

        WebElement xPathAncestorOrSelf = driver.findElement(By.xpath("//*[@class='bloko-button bloko-button_primary bloko-button_stretched bloko-button_large ']/ancestor-or-self::div"));
        xPathAncestorOrSelf.isEnabled();

        WebElement xPathChild = driver.findElement(By.xpath("//*[@class='supernova-search-group__submit ']/child::button"));
        xPathChild.isEnabled();

        WebElement xPathDescendantAxes = driver.findElement(By.xpath("//*[@class='HH-MainContent HH-Supernova-MainContent']/descendant::button"));
        xPathDescendantAxes.isEnabled();

        WebElement xPathFollowing = driver.findElement(By.xpath("//*[@class='supernova-navi-underline']/following::button"));
        xPathFollowing.isEnabled();

        WebElement xPathParent = driver.findElement(By.xpath("//*[@class='supernova-navi-underline']/parent::div"));
        xPathParent.isEnabled();

        WebElement xPathPreceding = driver.findElement(By.xpath("//*[@class='supernova-navi-underline']/preceding::div[@class='bloko-columns-wrapper']"));
        xPathPreceding.isEnabled();

        WebElement xPathSelf = driver.findElement(By.xpath("//*[@class='supernova-dashboard-content']/self::div"));
        xPathSelf.isEnabled();

        driver.quit();


    }
}
