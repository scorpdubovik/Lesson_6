package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MilestonePage {
    protected By name_selector = By.id("name");
    protected By description_selector = By.id("description_display");
    protected By references_selector = By.id("reference");
    protected By startDate_selector = By.id("start_on");
    protected By endDate_selector = By.id("due_on");
    protected By addMilestoneButtonSelector = By.id("accept");


    public SelenideElement getNameField() {
        return $(name_selector);
    }

    public SelenideElement getDescriptionField() {
        return $(description_selector);
    }

    public SelenideElement getReferencesField() {
        return $(references_selector);
    }

    public SelenideElement getStartDateField() {return $(startDate_selector);}

    public SelenideElement getEndDateField() {
        return $(endDate_selector);
    }

    public SelenideElement getAddMilestoneButton() {return $(addMilestoneButtonSelector);}

}
