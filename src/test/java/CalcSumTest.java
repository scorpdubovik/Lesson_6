import org.testng.Assert;
import org.testng.annotations.Test;

public class CalcSumTest extends BaseTest {

    Calculator calc = new Calculator("SumCalc");

    @Test(enabled = false)
    public void testSum() {
        System.out.println(calc.sum(3, 4));
    }

    private int attempt = 1;

    @Test(retryAnalyzer = Retry.class)
    public void flakyTest() {
        if (attempt == 3) {
            Assert.assertTrue(true);
        }else {
            attempt++;
            System.out.println(attempt);
            throw new NullPointerException();
        }
    }
}