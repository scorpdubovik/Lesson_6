package pages;

import baseEntities.BasePage;
import com.tms.core.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddProjectPage extends BasePage {
    // Описание элементов страницы
    private By PAGE_OPENED_IDENTIFIER = By.id("sidebar-projects-add");

    private By addProject_Selector = By.id("sidebar-projects-add");
    private By name_Selector = By.id("name");
    private By announcement_Selector = By.id("announcement");
    private By radioButton_Selector = By.id("suite_mode_single_baseline");
    private By createProject_Selector = By.id("accept");

    // Конструктор страницы
    public AddProjectPage(WebDriver driver){super(driver);}

    public boolean isPageOpened(){
        return super.isPageOpen(PAGE_OPENED_IDENTIFIER);
    }

     // Реализация гетерров элементов
    public WebElement getAddProject(){
        return driver.findElement(addProject_Selector);
    }
    public WebElement getNameField(){
        return driver.findElement(name_Selector);
    }
    public WebElement getAnnouncementField(){
        return driver.findElement(announcement_Selector);
    }
    public WebElement getRadioButton(){
        return driver.findElement(radioButton_Selector);
    }
    public WebElement getCreateProject(){
        return driver.findElement(createProject_Selector);
    }
    // Реализация базовых методов
    public void addProject(){
        getAddProject().click();
    }
      public void createProject(String newProjectName, String announcement){
          getNameField().sendKeys(ReadProperties.getNewProjectName());
          getAnnouncementField().sendKeys(ReadProperties.getAnnouncement());
          getRadioButton().click();
          getCreateProject().click();

      }
}
