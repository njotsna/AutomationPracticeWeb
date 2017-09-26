package stepDefinitions;

import cucumber.api.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import utilities.BaseUtil;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.text.Utilities;
import java.io.File;
import java.io.IOException;

/**
 * This class contains Before and after test methods
 */

public class Hook extends BaseUtil {

    private BaseUtil baseUtil;
    Scenario scenario;

    public Hook(BaseUtil baseUtil) {
        this.baseUtil = baseUtil;
    }

    @Before
    public void initBrowser(Scenario scenario)
    {
        this.scenario = scenario;
        System.out.println("Executing scenario:" + scenario.getName());
        baseUtil.driver = new ChromeDriver();
        baseUtil.driver.manage().deleteAllCookies();
        baseUtil.driver.manage().window().maximize();

    }

    @After
    public void tearDown() throws IOException {
        scenario.write("Finished Scenario");
        if(scenario.isFailed())
        {
            File screenshotFile = ((TakesScreenshot) baseUtil.driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile,
                    new File("./target/Screenshots/AutomationPracticeTest/"
                            + scenario.getName()+"_"+System.currentTimeMillis() + ".png"));
        }

        baseUtil.driver.manage().deleteAllCookies();
        baseUtil.driver.quit();
    }

}
