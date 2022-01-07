package tests;

import baseEntities.BaseTest;
import org.testng.annotations.Test;
import pages.InputsPage;

public class InputsTest extends BaseTest {
    @Test
    public void inputNumbersTest(){
        InputsPage inputsPage = new InputsPage(driver);

        inputsPage.isPageOpen();
        inputsPage.openInputsPage();
        inputsPage.inputNumbers();

    }
}
