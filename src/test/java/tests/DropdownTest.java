package tests;

import baseEntities.BaseTest;
import org.testng.annotations.Test;
import pages.DropdownPage;

public class DropdownTest extends BaseTest {
    @Test
    public void dropDownTest(){
        DropdownPage dropdownPage = new DropdownPage(driver);
        dropdownPage.isPageOpen();
        dropdownPage.openInputsPage();
        dropdownPage.selectOption();

    }
}
