package stepDefinitions;

import base.DriverManager;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.amazonH_PF;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class amazonSearchStepDefinitions {
    WebDriver driver = null;
    amazonH_PF amazonh_pf = null;
    DriverManager drivermanager = new DriverManager();

    @Before(order=1)
    public void cucumberSetup(){
        System.out.println("This is my First Before tag");
    }

    @After
    public void tearDown(Scenario scenario) throws IOException {
        if(scenario.isFailed()) {
            File sshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            byte[] sscontent = FileUtils.readFileToByteArray(sshot);
            scenario.attach(sscontent, "image/png", "Screenshot");
        }
        driver.close();
        System.out.println("This is @After");
    }

    @Given("amazon webpage is launched")
    public void amazon_webpage_is_launched() {

        driver.get("https://www.amazon.in/");
        amazonh_pf = new amazonH_PF(driver);

    }
    @When("user enters a product name")
    public void userEntersAProductName(DataTable productName) {
        amazonh_pf.enterTextInSearchBox(productName.cell(0,0));
        System.out.println(productName.cell(0,0));
        System.out.println(productName.cell(1,1));

    }

    @And("clicks on search button")
    public void clicksOnSearchButton() {
        amazonh_pf.clickOnSearchBtn();

    }

    @Then("search results should be displayed")
    public void searchResultsShouldBeDisplayed() {
        System.out.println("Test using Page Factory is successful");
    }



    @When("user enters a {string} name")
    public void userEntersAName(String arg0) {
        amazonh_pf.enterTextInSearchBox(arg0);
    }

    @Given("amazon webpage is launched in {string}")
    public void amazonWebpageIsLaunchedIn(String browsername) {
        driver = drivermanager.getBrowserDriver(browsername);
        driver.get("https://www.amazon.in/");
        amazonh_pf = new amazonH_PF(driver);
    }
}
