package HomeWork;

import baseEntities.BaseTest;
import com.tms.core.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void loginTest() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/login");

        WebElement userNameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement button = driver.findElement(By.cssSelector(".fa.fa-2x.fa-sign-in"));

        Actions actions = new Actions(driver);
        actions
                .sendKeys(userNameField, ReadProperties.getUsername1())
                .sendKeys(passwordField, ReadProperties.getPassword1())
                .click(button)
                .build()
                .perform();

        Assert.assertTrue(driver.findElement(By.cssSelector(".icon-2x.icon-signout")).isDisplayed());

        Thread.sleep(3000);
    }
}
