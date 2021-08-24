package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.amazonH_PF;


public class amazonSearchStepDefinitions {
    WebDriver driver = null;
    amazonH_PF amazonh_pf = null;

    @Given("amazon webpage is launched")
    public void amazon_webpage_is_launched() {
        String ProjDir = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", ProjDir+"/src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.amazon.in/");
        amazonh_pf = new amazonH_PF(driver);

    }
    @When("user enters a product name")
    public void userEntersAProductName() {


    }

    @And("clicks on search button")
    public void clicksOnSearchButton() {
        amazonh_pf.clickOnSearchBtn();

    }

    @Then("search results should be displayed")
    public void searchResultsShouldBeDisplayed() {
        driver.close();
        System.out.println("Test using Page Factory is successful");
    }



    @When("user enters a {string} name")
    public void userEntersAName(String arg0) {
        amazonh_pf.enterTextInSearchBox(arg0);
    }

}
