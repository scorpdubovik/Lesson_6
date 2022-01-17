package tests;

import baseEntities.BaseTest;
import com.tms.core.ReadProperties;
import models.Project;
import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import utils.Randomization;
import utils.Retry;

public class LombokTest extends BaseTest {
    Project addProject;
    Project updateProject;

    @Test
    public void loginTest() {
        User user = new User();
                user.setEmail(ReadProperties.getUsername());
                user.setPassword(ReadProperties.getPassword());

        System.out.println(user.toString());
    }
}