package stepDefinitions;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
        glue={"stepDefinitions"},
        monochrome = true,
        publish = true,
        tags="@RegressionFlow",
        plugin={"pretty", "html:target/cucumber-html-report.html", "json:target/cucumber.json", "junit:target/cucumber.xml", "rerun:target/rerun.txt","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
public class runner {
}





