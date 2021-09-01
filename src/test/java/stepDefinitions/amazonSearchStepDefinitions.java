package stepDefinitions;

import base.DriverManager;
import base.ExcelDataReader;
import base.Helper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.amazonH_PF;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.TimeUnit;


public class amazonSearchStepDefinitions {
    WebDriver driver = null;
    amazonH_PF amazonh_pf = null;
    DriverManager drivermanager = new DriverManager();
    ExcelDataReader excelDataReader = new ExcelDataReader();
    Logger logger = Helper.getLogger(amazonSearchStepDefinitions.class);

    @Before(order=1)
    public void cucumberSetup(){
        System.out.println("This is my First Before tag");
        logger.debug("I m inside the before method");
    }


    @After
    public void tearDown(Scenario scenario) throws IOException {
        if(scenario.isFailed()) {
            File sshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            byte[] sscontent = FileUtils.readFileToByteArray(sshot);
            scenario.attach(sscontent, "image/png", "Screenshot");
        }
        logger.debug("I m inside the after method");
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

    @When("user enters a product name from excel at {string}")
    public void userEntersAProductNameFromExcelAt(String arg0) throws IOException {
        //amazonh_pf.enterTextInSearchBox(excelDataReader.getCellData(arg0,"Sheet1",1,1));


    }

    @When("user enters a product name from excel at {string} for {string}")
    public void userEntersAProductNameFromExcelAtFor(String arg0, String arg1) throws IOException {
        List<List<String>> productData = excelDataReader.getSheetDataToList(arg0,"Sheet1");

        ListIterator<List<String>> rowIterator = productData.listIterator();

        while (rowIterator.hasNext()){
            List<String> cellIter = rowIterator.next();
            if(cellIter.get(0).equalsIgnoreCase(arg1)){
                amazonh_pf.enterTextInSearchBox(cellIter.get(1));
                System.out.println(cellIter.get(1));

            }
        }
    }
}
