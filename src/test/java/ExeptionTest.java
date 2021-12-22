import org.testng.annotations.Test;

import java.util.List;

public class ExeptionTest {
    Calculator calc = new Calculator("ExeptionTest");

    @Test(expectedExceptions = NullPointerException.class)
    public void testNPE(){
        List list = null;
        System.out.println(list.size());
    }
}
