package stepDefinitions;
import org.testng.annotations.DataProvider;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features",
        glue={"stepDefinitions"},
        monochrome = true,
        publish = true,
        tags="@RegressionFlow",
        plugin={"pretty", "html:target/cucumber-html-report.html", "json:target/cucumber.json", "junit:target/cucumber.xml", "rerun:target/rerun.txt", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})

public class parallelRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios(){
        return super.scenarios();
    }


}
