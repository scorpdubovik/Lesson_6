package utils;

import com.tms.core.ReadProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public final class Waits {
    private WebDriver driver;
    private WebDriver wait;

    public Waits(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, ReadProperties.getTimeOut());
    }
    public Waits(WebDriver driver, int timeOut) {
        this.driver = driver;
        wait = new WebDriverWait(driver, timeOut);
    }

    public void waitForVisibility(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.until(ExpectedConditions.visibilityOf(element));
        }
    }
