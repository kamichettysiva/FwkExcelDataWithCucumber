package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.amazonH_PF;

import java.util.concurrent.TimeUnit;


public class amazonSearchStepDefinitions {
    WebDriver driver = null;
    amazonH_PF amazonh_pf = null;

    @Before(order=1, value="@RegressionFlow")
    public void cucumberSetup(){
        String ProjDir = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", ProjDir+"/src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        System.out.println("This is my First Before tag");

    }

    @Before("@SanityFlow")
    public void dSetup2(){
        /*String ProjDir = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", ProjDir+"/src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);*/
        System.out.println("This is my Second Before tag");

    }

    @After
    public void tearDown(){
        driver.close();
        System.out.println("This is @After");
    }

    @BeforeStep
    public void beforeStep(){
        System.out.println("This is @Before Step");
    }

    @AfterStep
    public void afterStep(){
        System.out.println("This is @After Step");
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

}
