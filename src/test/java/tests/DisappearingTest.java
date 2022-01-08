package tests;

import baseEntities.BaseTest;
import org.testng.annotations.Test;
import pages.DisappearingPage;

public class DisappearingTest extends BaseTest {

    @Test
    public void disappearingTest(){
        DisappearingPage disappearingPage = new DisappearingPage(driver);

        disappearingPage.isPageOpen();
        disappearingPage.openDisappearingPage();
        disappearingPage.visibilityTest();
    }
}
