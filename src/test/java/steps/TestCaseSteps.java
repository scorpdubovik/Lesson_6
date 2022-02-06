package steps;

import models.Project;
import models.TestCase;
import org.openqa.selenium.By;
import pages.AddTestCasePage;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static tests.HW_TestCaseTests.addProjectName1;
import static tests.HW_TestCaseTests.addTestCaseName;

public class TestCaseSteps {

    public void addTestCase(Project project, TestCase testCase) {
        open("/index.php?/dashboard");
        $(byText(addProjectName1)).click();
        $(By.id("navigation-suites")).click();
        $(By.id("sidebar-cases-add")).click();

        AddTestCasePage addTestCasePage = new AddTestCasePage();
        addTestCasePage.getTitleField().val(testCase.getTitle());
        addTestCasePage.getEstimateField().val(testCase.getEstimate());
        addTestCasePage.getReferencesField().val(testCase.getReferences());
        addTestCasePage.getSaveTestCaseButton().click();
    }
    public void updateTestCase(Project project, TestCase testCase) {
        open("/index.php?/dashboard");
        $(byText(addProjectName1)).click();
        $(By.id("navigation-suites")).click();
        $(byText(addTestCaseName)).click();
        $(".button-text").click();

        AddTestCasePage addTestCasePage = new AddTestCasePage();
        addTestCasePage.getTitleField().val(testCase.getTitle());
        addTestCasePage.getEstimateField().val(testCase.getEstimate());
        addTestCasePage.getReferencesField().val(testCase.getReferences());
        addTestCasePage.getSaveTestCaseButton().click();
    }
    public void deleteTestCase() {
        open("/index.php?/dashboard");
        $(byText(addProjectName1)).click();
        $(By.id("navigation-suites")).click();
        $(byText(addTestCaseName)).click();
        $(".button-text").click();
        $(By.xpath("//span[@class='button button-negative button-delete']")).click();
        $("a[onclick='this.blur(); App.Cases.confirmDeletion(false, false); return false;']").click();

    }
}
