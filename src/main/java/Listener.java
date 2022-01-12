import  org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("=======================");
        System.out.println("Screenshot has been captured");
        System.out.println("=======================");
    }
}
