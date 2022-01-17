package baseEntities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Waits;

public class BaseStep {
    protected WebDriver driver;
    protected Waits waits;

    public BaseStep(WebDriver driver) {
this.driver =driver;
waits = new Waits(driver);
    }
}
