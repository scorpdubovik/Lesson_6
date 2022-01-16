package pages;

import baseEntities.BasePage;
import models.Project;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ViewProjectPage extends BasePage {

    private static final By PAGE_OPENED_IDENTIFIER = By.id("navigation-project");

    protected By editProjectButtonSelector = By.cssSelector(".toolbar-button.toolbar-button-last.content-header-button.button-edit");

    protected By saveProjectButtonSelector = By.id("accept");

    public ViewProjectPage(WebDriver driver) {
        super(driver);
    }

    public ViewProjectPage(WebDriver driver, boolean openPageByUrl) {
        super(driver, openPageByUrl);
    }

    Project project = new Project();

    @Override
    protected void openPage() {
        driver.get(BASE_URL);
        driver.findElement(By.xpath("//*[.= '"+project.getProjectName()+"']")).click();
    }

    @Override
    protected boolean isPageOpened() {
        return waits.waitForVisibility(PAGE_OPENED_IDENTIFIER).isDisplayed();
    }

    public WebElement getEditProjectButton() {return driver.findElement(editProjectButtonSelector);}

    public WebElement getSaveProjectButton() {return driver.findElement(saveProjectButtonSelector);}


    public void editProject(){
        AddProjectPage addProjectPage = new AddProjectPage(driver);
        getEditProjectButton().click();
        addProjectPage.addNewProject(project);
        getEditProjectButton().click();
    }
}

