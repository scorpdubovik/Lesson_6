package data;

import org.testng.annotations.DataProvider;

public class StaticProvider2 {

    @DataProvider (name = "dataForDiv")
    public static Object[][] dataForDivFunction(){
        return new Object[][] {
                {15, 3, 5},
                {-25, 5, -5},
                 {15, 0, 0}
        };
    }
}
