package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultsPage extends BasePage{

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class = 'sc-318c58f2-3 hYPBYb']")
    public WebElement searchResultsBar;

    @FindBy(xpath = "//div[@class = 'sc-318c58f2-5 ibFDYY']")
    public WebElement searchResultsText;

    @FindBy(xpath = "//div[@class = 'sc-318c58f2-4 dAloRv']")
    public WebElement searchResultsCount;

    @FindBy(xpath = "//div[@class = 'sc-433dbb72-25 elDiNI']")
    public List<WebElement> productsNameList;

    @FindBy(xpath = "//strong[@class= 'amount']")
    public List<WebElement> productsPriceList;

    @FindBy(xpath = "//*[@id='__next']/div/section/div/div/div[1]/div/div[3]/div/div[1]/div/div")
    private WebElement brandLookUp;

    @FindBy(xpath = "(//span[@style = 'display: flex; align-items: center;'])[2]")
    private WebElement appleBrandOption;

    @FindBy(xpath = "//*[@id='__next']/div/section/div/div/div[1]/div/div[4]/div/div[1]")
    public WebElement priceLookUp;

    @FindBy(xpath = "//input[@name = 'min']")
    private WebElement minPriceField;

    @FindBy(xpath = "//input[@name = 'max']")
    private WebElement maxPriceField;

    @FindBy(xpath = "//button[@class = 'between']")
    private WebElement goPriceBTN;

    public void selectPriceRange(String min, String max) {
        clearText(minPriceField);
        enterText(minPriceField, min);
        clearText(maxPriceField);
        enterText(maxPriceField, max);
        clickOnElement(goPriceBTN);
    }

    public void selectAppleBrand(){
        clickOnElement(brandLookUp);
        clickOnElement(appleBrandOption);
    }

}
