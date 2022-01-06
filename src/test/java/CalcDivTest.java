import data.StaticProvider2;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalcDivTest extends BaseTest{

    Calculator calc = new Calculator("DivCalc");

    @Test(priority = 2, expectedExceptions = ArithmeticException.class)
    public void testAE() {
        System.out.println(calc.div(3,0));
    }

    @Test(priority = 1,description = "Test of division in my Calculator")
    public void testDiv() {
        Assert.assertEquals(calc.div(4,2),2);
    }

    @Test(dataProvider = "dataForDiv", dataProviderClass = StaticProvider2.class)
    public void dataProviderTest(int a, int b, int expectedResult){
        Assert.assertEquals(calc.div(a,b),expectedResult);

    }
}
