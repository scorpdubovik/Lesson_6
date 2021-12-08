package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HomeWork {
    static String URL = "https://kermi-fko.ru/raschety/Calc-Rehau-Solelec.aspx";

    @Test
    public void homework_test1(){
        String floorWidthValue = "6";
        String floorLengthValue = "9";
        String heatLossValue = "63";

        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.get(URL);

    }
}
