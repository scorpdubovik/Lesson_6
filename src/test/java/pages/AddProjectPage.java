package pages;

import baseEntities.BasePage;
import models.Project;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddProjectPage extends BasePage {
    private static String ENDPOINT = "/admin/projects/add/1";

    private static final By PAGE_OPENED_IDENTIFIER = By.cssSelector(".content-header-title.page_title.display-inline-block");

    protected By name_Selector = By.id("name");
    protected By announcement_Selector = By.id("announcement");
    protected By radioButton1_Selector = By.id("suite_mode_single");
    protected By radioButton2_Selector = By.id("suite_mode_single_baseline");
    protected By radioButton3_Selector = By.id("suite_mode_multi");
    protected By createProject_Button = By.id("accept");

    public AddProjectPage(WebDriver driver) {super(driver);}

    public AddProjectPage(WebDriver driver, boolean openPageByUrl) {super(driver, openPageByUrl);}

    @Override
    protected void openPage() {driver.get(BASE_URL + ENDPOINT);}

    @Override
    protected boolean isPageOpened() {return waits.waitForVisibility(PAGE_OPENED_IDENTIFIER).isDisplayed();}

    public WebElement getNameField() {return driver.findElement(name_Selector);}

    public WebElement getAnnouncementField() { return driver.findElement(announcement_Selector);}

    public WebElement getRadioButton1() {return driver.findElement(radioButton1_Selector);}
    public WebElement getRadioButton2() {return driver.findElement(radioButton2_Selector);}
    public WebElement getRadioButton3() {return driver.findElement(radioButton3_Selector);}

    public WebElement getCreateProjectButton() {return driver.findElement(createProject_Button);}

    public void addNewProject(Project project){
        getNameField().sendKeys(project.getProjectName());
        getAnnouncementField().sendKeys(project.getAnnouncement());

        switch (project.getRadioButton_Selector()){

            case "single":
                getRadioButton1().click();
                break;

            case "singleWithBaseline":
                getRadioButton2().click();
                break;

            case "multi":
                getRadioButton3().click();
                break;

            default:
                System.out.println("No project type has been selected");
                break;

        }
        getCreateProjectButton().click();
    }
}
