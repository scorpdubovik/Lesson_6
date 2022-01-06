import org.testng.Assert;
import org.testng.annotations.Test;

public class CalcSubTest extends BaseTest{

    Calculator calc = new Calculator("SubCalc");

    @Test(invocationCount = 5)
    public void invocationTest() {
        Assert.assertEquals(calc.sub(3, 5), -2);
    }

    @Test(invocationCount = 4, threadPoolSize = 3)
    public void invocationTest1 () {
         Assert.assertEquals(calc.sub(4, 2), 2);
        }

    @Test (groups = {"smoke","sanity", "regression"})
    public void smokeTest() {System.out.println("CalcSub -> smokeTest");}

    @Test (groups = {"sanity", "regression"})
    public void sanityTest() {System.out.println("CalcSub -> sanityTest");}

    @Test (groups = "regression")
    public void regressionTest() {System.out.println("CalcSub -> regressionTest");}
    }
