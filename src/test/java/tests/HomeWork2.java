package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HomeWork2 {
    static String URL = "https://masterskayapola.ru/kalkulyator/laminata.html";

    @Test
    public void homework_test2(){
        String roomLengthValue = "12";
        String roomWidthValue = "6";
        String lamLengthValue = "1400";
        String lamWidthValue = "180";
        String lamInPackValue = "16";
        String lamPriceValue = "30";
        String dislocationValue = "200";
        String walldistValue = "15";

        String expectedSquare = "71.46 м2.";
        String expectedNumberOfPanels = "288 шт.";
        String expectedNumberOfPackages = "18 шт.";
        String expectedCost = "2177 руб.";
        String expectedRemains = "0 шт.";
        String expectedSegments = "12 шт.";

        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.get(URL);

        WebElement roomLength = driver.findElement(By.name("calc_roomwidth"));
        roomLength.sendKeys(Keys.DELETE, roomLengthValue);

        WebElement roomWidth = driver.findElement(By.name("calc_roomheight"));
        roomWidth.sendKeys(Keys.chord(Keys.DELETE, roomWidthValue));

        WebElement lamLength = driver.findElement(By.name("calc_lamwidth"));
        lamLength.sendKeys(Keys.LEFT_CONTROL+"a",Keys.DELETE);
        lamLength.sendKeys(lamLengthValue);

        WebElement lamWidth = driver.findElement(By.name("calc_lamheight"));
        lamWidth.sendKeys(Keys.LEFT_CONTROL+"a",Keys.DELETE);
        lamWidth.sendKeys(lamWidthValue);

        WebElement lamInPack = driver.findElement(By.name("calc_inpack"));
        lamInPack.sendKeys(Keys.LEFT_CONTROL+"a",Keys.DELETE);
        lamInPack.sendKeys(lamInPackValue);

        WebElement lamPrice = driver.findElement(By.name("calc_price"));
        lamPrice.sendKeys(Keys.LEFT_CONTROL+"a",Keys.DELETE);
        lamPrice.sendKeys(lamPriceValue);

        WebElement directionElement = driver.findElement(By.name("calc_direct"));
        Select directionDropDown = new Select(directionElement);
        directionDropDown.selectByValue("toh");

        WebElement dislocation = driver.findElement(By.name("calc_bias"));
        dislocation.clear();
        dislocation.sendKeys(dislocationValue);

        WebElement walldist = driver.findElement(By.name("calc_walldist"));
        walldist.sendKeys(Keys.LEFT_CONTROL+"a", Keys.DELETE);
        walldist.sendKeys(walldistValue);

        WebElement calculate = driver.findElement(By.cssSelector("input[onclick='lamcalc();']"));
        calculate.click();

        // Проверить результаты
        String actualSquare = driver.findElement(By.id("s_lam")).getText();
        String actualNumberOfPanels = driver.findElement(By.id("l_count")).getText();
        String actualNumberOfPackages = driver.findElement(By.id("l_packs")).getText();
        String actualCost = driver.findElement(By.id("l_price")).getText();
        String actualRemains = driver.findElement(By.id("l_over")).getText();
        String actualSegments = driver.findElement(By.id("l_trash")).getText();

        Assert.assertEquals(actualSquare,expectedSquare,"Площади различные");
        Assert.assertEquals(actualNumberOfPanels,expectedNumberOfPanels,"Количество панелей различное");
        Assert.assertEquals(actualNumberOfPackages, expectedNumberOfPackages,"Количество упаковок различное");
        Assert.assertEquals(actualCost,expectedCost,"Стоимость различная");
        Assert.assertEquals(actualRemains,expectedRemains,"Отстатки различные");
        Assert.assertEquals(actualSegments,expectedSegments,"Количество отрезков различное");

        driver.quit();
    }
}
