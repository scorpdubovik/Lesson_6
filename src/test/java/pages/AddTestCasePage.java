package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class AddTestCasePage {
    protected By title_selector = By.id("title");
    protected By template_selector = By.id("template_id_chzn");
    protected By type_selector = By.id("type_id_chzn");
    protected By priority_selector = By.id("priority_id_chzn");
    protected By estimate_selector = By.id("estimate");
    protected By references_selector = By.id("refs");
    protected By automationType_selector = By.id("custom_automation_type_chzn");
    protected By mission_selector = By.id("custom_mission_display");
    protected By goals_selector = By.id("custom_goals_display");
    protected By saveTestCaseButtonSelector = By.id("accept");


    public SelenideElement getTitleField() {
        return $(title_selector);
    }

    public SelenideElement getTemplateField() {
        return $(template_selector);
    }

    public SelenideElement getTypeField() {
        return $(type_selector);
    }

    public SelenideElement getPriorityField() {return $(priority_selector);}

    public SelenideElement getEstimateField() {
        return $(estimate_selector);
    }

    public SelenideElement getReferencesField() {
        return $(references_selector);
    }


    public SelenideElement getAutomationTypeField() {
        return $(automationType_selector);
    }

    public SelenideElement getMissionField() {
        return $(mission_selector);
    }

    public SelenideElement getGoalsField() {
        return $(goals_selector);
    }

    public SelenideElement getSaveTestCaseButton() {return $(saveTestCaseButtonSelector);}

}
