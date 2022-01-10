package tests;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.AllureUtils;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = (WebDriver) result.getTestContext().getAttribute("driver");
        System.out.printf("Тест %s провален", result.getName());
        AllureUtils.takeScreenshot(driver);
    }


}
