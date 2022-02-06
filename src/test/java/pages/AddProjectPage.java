package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class AddProjectPage {
    private static String ENDPOINT = "/admin/projects/add/1";

    private static final By PAGE_OPENED_IDENTIFIER = By.cssSelector(".content-header-title.page_title.display-inline-block");

    protected By name_Selector = By.id("name");
    protected By announcement_Selector = By.id("announcement");
    private static String typeRadioButtonSelector = "//*[@name = 'suite_mode' and @value='replace']";
    protected By showAnnouncementTick = By.id("show_announcement");
    protected By createProject_Button = By.id("accept");

    public SelenideElement getNameField() {return $(name_Selector);}

    public SelenideElement getAnnouncementField() {
        return $(announcement_Selector);
    }

    public SelenideElement getCreateProjectButton() {
        return $(createProject_Button);
    }

    public void setType(int type) {$(By.xpath(typeRadioButtonSelector.replace("replace", String.valueOf(type))));}

    public void showAnnouncement() {
        SelenideElement announcementTick = $(showAnnouncementTick);
        if (!announcementTick.isSelected()) {
            announcementTick.click();
        }
    }
}
