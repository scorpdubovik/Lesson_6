package baseEntities;

import com.tms.core.ReadProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.Locale;

public class BaseTest {
protected WebDriver driver;

    @BeforeMethod
    public void setUp(){
        switch (ReadProperties.getbrowserType().toLowerCase(Locale.ROOT)) {
            case "chrome" :
                WebDriverManager.getInstance(DriverManagerType.CHROME).setup();

                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--disable-gpu");
                chromeOptions.addArguments("--silent");
                chromeOptions.setHeadless(ReadProperties.getHeadless());
                //chromeOptions.addArguments("--start-maximized");

                driver = new ChromeDriver(chromeOptions);
                break;

                case "firefox" :
                WebDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
                driver = new FirefoxDriver();
                break;

            default:
                System.out.println("This type of browser is not supported");
                break;
        }

        driver.manage().window().maximize();
        //driver.get(ReadProperties.getUrl());
        driver.get(ReadProperties.getUrl2());

    }

    @AfterMethod
    public void tearDown(){
    driver.quit();

    }
}
