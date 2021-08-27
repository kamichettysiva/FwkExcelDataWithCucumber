package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class amazonH_PF {

    @FindBy(id="twotabsearchtextbox")
    WebElement txt_seachbox;

    @FindBy(id="nav-search-submit-button")
    WebElement btn_searchbtn;

    WebDriver driver;

    public amazonH_PF(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);

    }

    public void enterTextInSearchBox(String text){
        txt_seachbox.clear();
        txt_seachbox.sendKeys(text);
    }

    public void clickOnSearchBtn(){
        btn_searchbtn.click();
    }

}
