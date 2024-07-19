package pltester;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class SampleTestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult ITestResult){
        System.out.println("I'm starting test");
    }

    public void onTestFailure(ITestResult ITestResult){

        WebDriver driver = DriverFactory.getDriver();
        int randomNumber = (int) (Math.random()*1000);
        TakesScreenshot screenshot1 = (TakesScreenshot) driver;
        File before = screenshot1.getScreenshotAs(OutputType.FILE);
        String fileName = "failedTest" + randomNumber + ".png";
        try {
            FileHandler.copy(before, new File("src/test/resources/" + fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
