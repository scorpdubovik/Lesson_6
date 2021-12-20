import org.testng.annotations.*;

public class BaseTest {

    @BeforeTest
    public void beforeTest(){System.out.printf("BeforeTest");}

    @BeforeSuite
    public void beforeSuite(){System.out.printf("BeforeSuite");}

    @BeforeGroups
    public void beforeGroups(){System.out.printf("BeforeGroups");}

    @BeforeClass
    public void beforeClass(){System.out.printf("BeforeClass");}

    @BeforeMethod
    public void beforeMethod(){System.out.printf("BeforeMethod");}

    //After Annotations
    @AfterTest
    public void beforeTest1(){System.out.printf("BeforeTest");}

    @AfterSuite
    public void beforeSuite1(){System.out.printf("BeforeSuite");}

    @AfterGroups
    public void beforeGroups1(){System.out.printf("BeforeGroups");}

    @AfterClass
    public void beforeClass1(){System.out.printf("BeforeClass");}

    @AfterMethod
    public void beforeMethod1(){System.out.printf("BeforeMethod");}


}
