package utilitis;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;

public class Listeners extends CommonOps implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        System.out.println("------------- Starting Execution ------------");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("------------- Ending Execution ------------");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("------------- Skipping Test: "+ result.getName() +" ------------");

    }

    @Override
    public void onTestSuccess(ITestResult result) {

        System.out.println("------------- Test "+result.getName() +" passed ------------");

        if(!getData("PlatformName").equalsIgnoreCase("api")){
            // Stop Recording
            try {
                MonteScreenRecorder.stopRecord();
            } catch (Exception e) {
                e.printStackTrace();
            }

            // Delete Recording
            File file = new File("./Test-Recordings/" + result.getName() + ".avi");
            if (file.delete()) {
                System.out.println("File Delete Successfully");
            } else {
                System.out.println("Failed to Delete File");
            }
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("------------- Test "+result.getName() +" failed ------------");
        if(!getData("PlatformName").equalsIgnoreCase("api")){

            // Stop Recording
            try {
                MonteScreenRecorder.stopRecord();
            } catch (Exception e) {
                e.printStackTrace();
            }

            // Do Screen Shot
            saveScreenshot();
        }
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("------------- Test "+result.getName() +" Started ------------");
    }

    @Attachment(value = "Page screenshot", type="image/png")
    public static byte[] saveScreenshot() {
        if (!getData("PlatformName").equalsIgnoreCase("mobile"))
            return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        else
            return ((TakesScreenshot) mobileDriver).getScreenshotAs(OutputType.BYTES);

    }
}
