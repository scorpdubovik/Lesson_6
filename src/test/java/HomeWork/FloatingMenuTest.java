package HomeWork;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FloatingMenuTest extends BaseTest {

    @Test
    public void floatingJSTest() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/floating_menu#home");
        WebElement text = driver.findElement(By.cssSelector("div[style = 'text-align: center;']"));

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        Assert.assertTrue(text.isDisplayed());
        Thread.sleep(3000);
    }
}
