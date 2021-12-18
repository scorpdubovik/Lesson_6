package pages;

import baseEntities.BasePage;
import com.tms.core.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPage extends BasePage {
    // Описание элементов страницы
    private By PAGE_OPENED_IDENTIFIER = By.id("navigation-dashboard");

    private String projectName = ReadProperties.getProjectName();
    private By project_Selector = By.xpath("//*[.= '" + projectName + "']");

    // Конструктор страницы
    public DashboardPage(WebDriver driver) {
        super(driver);
    }

        public boolean isPageOpened(){
            return super.isPageOpen(PAGE_OPENED_IDENTIFIER);
        }

    // Реализация гетерров элементов
    public WebElement getProject(){
        return driver.findElement(project_Selector);
    }
    // Реализация базовых методов
    public void openProject(){
        getProject().click();
    }
    }

