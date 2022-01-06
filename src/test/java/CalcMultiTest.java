import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CalcMultiTest extends BaseTest {

    Calculator calc = new Calculator("MultiCalc");

    @Test(dependsOnMethods = "testMulti2", alwaysRun = true)
    public void testMulti1() {
        System.out.println(calc.multi(3, 3));
    }

    @Test
    public void testMulti2() {
        System.out.println(calc.multi(1, 2));
    }
    @Parameters({"login-value","psw-value"})
    @Test
    public void paramTest(@Optional("login") String login,@Optional("11111") String psw){
        System.out.println("Login is: " + login);
        System.out.println("Password is:" + psw);
    }
}