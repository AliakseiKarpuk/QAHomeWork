import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.xml.xpath.XPath;
import java.io.File;
import java.util.List;

public class FirstTests {

//    @Test
//    public void chromeDriverTest() {
//
//        ClassLoader classLoader = getClass().getClassLoader();
//        File file = new File(classLoader.getResource("drivers/chromedriver.exe").getFile());
//        String absolutePath = file.getAbsolutePath();
//
//        System.setProperty("webdriver.chrome.driver", absolutePath);
//
//        ChromeDriver driver = new ChromeDriver();
//        driver.get("https://calc.by/weight-and-calories/body-mass-index-calculator.html");
//
//        WebElement height = driver.findElement(By.id("bmiVar1"));
//        height.sendKeys("183");
//
//        WebElement weight = driver.findElement(By.id("bmiVar2"));
//        weight.sendKeys("58");
//
//        WebElement calcBtn = driver.findElement(By.className("btn-calculate"));
//        calcBtn.click();
//
//        WebElement bmiNumber = driver.findElement(By.id("AnswerBMI"));
//        String bmiNumberText = bmiNumber.getText();
//
//        WebElement status = driver.findElement(By.id("AnswerBMI1"));
//        String statusText = status.getText();
//
//        Assert.assertEquals(bmiNumberText, "17.32");
//        Assert.assertEquals(statusText, "Недостаточной массе тела");
//
//        System.out.println(status.getTagName());
//        System.out.println(status.getAttribute("id"));
//
//        System.out.println(calcBtn.isDisplayed());
//        System.out.println(calcBtn.isEnabled());
//        System.out.println(calcBtn.isSelected());
//
//
//        driver.quit();
//    }

    @Test
    public void smokeTest2() throws InterruptedException {

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("drivers/chromedriver.exe").getFile());
        String absolutePath = file.getAbsolutePath();

        System.setProperty("webdriver.chrome.driver", absolutePath);

        ChromeDriver driver = new ChromeDriver();
        driver.get("https://calc.by/building-calculators/laminate.html");

        WebElement selectWebElement = driver.findElement(By.id("laying_method_laminate"));
        Select layingMethodLaminate = new Select(selectWebElement);
        layingMethodLaminate.selectByValue("2");

        WebElement roomLength = driver.findElement(By.id("ln_room_id"));
        roomLength.clear();
        roomLength.sendKeys("500");

        WebElement roomWidth = driver.findElement(By.id("wd_room_id"));
        roomWidth.clear();
        roomWidth.sendKeys("400");

        WebElement laminateLength = driver.findElement(By.id("ln_lam_id"));
        laminateLength.clear();
        laminateLength.sendKeys("2000");

        WebElement laminateWidth = driver.findElement(By.id("wd_lam_id"));
        laminateWidth.clear();
        laminateWidth.sendKeys("200");

//        WebElement layingDirection = driver.findElement(By.id("direction-laminate-id1"));
//        layingDirection.click();

        List<WebElement> list = driver.findElements(By.name("direction-laminate"));
        for (WebElement option : list){
            if(option.getAttribute("value").equals("1")){
                option.click();
            }
        }

        WebElement calcBtn = driver.findElement(By.xpath("//a[text()='Рассчитать']"));
        calcBtn.click();

        Thread.sleep(1500);

        WebElement numberOfBoards = driver.findElement(By.xpath("//span[text()='53']"));
        Assert.assertEquals(numberOfBoards.getText(), "53");
        WebElement numberOfPacks = driver.findElement(By.xpath("//span[text()='7']"));
        Assert.assertEquals(numberOfPacks.getText(), "7");

        driver.quit();
    }
}
