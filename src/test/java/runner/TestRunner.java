package runner;
/**
 * Runner file to run all tests using TestNg and generate reports
 */

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = {"src/test/java/features"},
        format = {"json:target/cucumber.json","html:target/site/cucumber-pretty"},
        glue = "stepDefinitions")
public class TestRunner extends AbstractTestNGCucumberTests
{

}
