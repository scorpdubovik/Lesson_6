package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.Waits;

public class DisappearingPage extends BasePage {
    //Описание элементов страницы
    private By PAGE_OPENED_IDENTIFIER = By.className("heading");
    private By PAGE_OPENED_IDENTIFIER2 = By.tagName("h3");
    String expectedPageOpenIdentifier = "Disappearing Elements";

    private By disappearing_Selector = By.cssSelector("a[href='/disappearing_elements']");
    private By disappearing_Element = By.cssSelector("a[href='/gallery/']");

    //Конструктор страницы
    public DisappearingPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpen() {
        return super.isPageOpen(PAGE_OPENED_IDENTIFIER);
    }

    // Реализация гетерров элементов
    public WebElement getDisappearingPage() {
        return driver.findElement(disappearing_Selector);
    }

    public WebElement getDisappearingElement() {
        return driver.findElement(disappearing_Element);
    }

    public WebElement getPageOpenIdentifier() {
        return driver.findElement(PAGE_OPENED_IDENTIFIER2);
    }

    // Реализация базовых методов
    public void openDisappearingPage() {
        getDisappearingPage().click();
        Assert.assertEquals(getPageOpenIdentifier().getText(), expectedPageOpenIdentifier, "Inputs page didn't open");
    }

    public void visibilityTest() {
        Waits waits = new Waits(driver);
        int numberOfElements = driver.findElements(disappearing_Element).size();
        int refreshCount = 10;

        for (int i = 0; i < refreshCount; i++) {
            if (numberOfElements > 0) {
                Assert.assertTrue(waits.waitForVisibility(disappearing_Element).isDisplayed());
            } else { driver.navigate().refresh();
            }
        }
    }
}
//do {
//        try {
//            getDisappearingElement().isDisplayed();
//        } catch (NoSuchElementException nsex) {
//            nsex.printStackTrace();
//        }
//        if (!getDisappearingElement().isDisplayed()){
//            driver.navigate().refresh();
//} while (!getDisappearingElement().isDisplayed());
//            Assert.assertTrue(waits.waitForVisibility(disappearing_Element).isDisplayed());
