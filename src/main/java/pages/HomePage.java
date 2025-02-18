package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "searchBar")
    public WebElement searchTextBox;

    @FindBy(className = "suggestion-link")
    public List<WebElement> suggestionList;

    public void searchForProduct(String text){
        enterText(searchTextBox, text);
        pressEnterBTN(searchTextBox);
    }
}
