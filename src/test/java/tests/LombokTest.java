package tests;

import baseEntities.BaseTest;
import com.tms.core.ReadProperties;
import models.Project;
import models.User;
import org.testng.annotations.Test;

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