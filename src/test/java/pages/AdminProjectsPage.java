package pages;

import baseEntities.BasePage;
import models.Project;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdminProjectsPage extends BasePage {
    private static String ENDPOINT = "/admin/projects/overview";

    private static final By PAGE_OPENED_IDENTIFIER = By.cssSelector(".content-header-title.page_title.display-inline-block");

    //protected By delProjectButtonSelector = By.cssSelector("a[onclick*='"+project.getProjectName()+"']");

    public AdminProjectsPage(WebDriver driver) {
        super(driver);
    }

    public AdminProjectsPage(WebDriver driver, boolean openPageByUrl) {
        super(driver, openPageByUrl);
    }

    @Override
    protected void openPage() {
        driver.get(BASE_URL + ENDPOINT);
    }

    @Override
    protected boolean isPageOpened() {
        return waits.waitForVisibility(PAGE_OPENED_IDENTIFIER).isDisplayed();
    }

    //public WebElement getDelProjectButton() {return driver.findElement(delProjectButtonSelector);}

    public void deleteProject(Project project){
        driver.findElement(By.cssSelector("a[onclick*='"+project.getProjectName()+"'] .icon-small-delete")).click();
        driver.findElement(By.xpath("//span[@class='dialog-confirm-busy']/following-sibling::input")).click();
        driver.findElement(By.xpath("//a[@class='button button-left button-positive button-disabled button-hidden button-no-margin-right dialog-action-secondary']/preceding-sibling::a")).click();
    }
}

