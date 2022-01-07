package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class DropdownPage extends BasePage {
    // Описание элементов страницы
    private By PAGE_OPENED_IDENTIFIER = By.className("heading");
    private By PAGE_OPENED_IDENTIFIER2 = By.tagName("h3");
    String expectedPageOpenIdentifier = "Dropdown List";
    //String expectedDropDownOption = "Option 2";


    private By dropdown_Button = By.cssSelector("a[href='/dropdown']");
    private By dropdown_Selector = By.id("dropdown");

    // Конструктор страницы
    public DropdownPage(WebDriver driver) {super(driver);}

    public boolean isPageOpen() {return super.isPageOpen(PAGE_OPENED_IDENTIFIER);}

    // Реализация гетерров элементов
    public WebElement getDropdownButton() {return driver.findElement(dropdown_Button);}

    public WebElement getDropdownField() {return driver.findElement(dropdown_Selector);}

    public WebElement getPageOpenIdentifier() {return driver.findElement(PAGE_OPENED_IDENTIFIER2);}

    // Реализация базовых методов
    public void openInputsPage() {
        getDropdownButton().click();
        Assert.assertEquals(getPageOpenIdentifier().getText(), expectedPageOpenIdentifier,"Dropdown page didn't open");
    }
    public void selectOption() {
        Select optionDropDown = new Select(getDropdownField());
        optionDropDown.selectByValue("2");
       // Assert.assertEquals(getDropdownField()., expectedDropDownOption, "DropDown test failed");
    }
}