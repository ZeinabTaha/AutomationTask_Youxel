package stepdefinations;

import io.cucumber.java.After;
import utilities.Setup;
import io.cucumber.java.en.And;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.HomePage;
import pages.SearchResultsPage;


public class SearchStepDef extends Setup {

    HomePage homePage = new HomePage(driver);
    SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
    int resultsCount;

    @When("User searches for a product like {string}")
    public void userSearchesForProduct(String product) throws InterruptedException {
        homePage.searchForProduct(product);
        Thread.sleep(5000);
    }

    @When("User types a partial keyword like {string}")
    public void userTypesPartialKeyword(String product) throws InterruptedException {
        homePage.enterText(homePage.searchTextBox, product);
        Thread.sleep(5000);
    }

    @Then("The search result page is displayed")
    public void searchResultPageIsDisplayed() {
        Assert.assertTrue(searchResultsPage.searchResultsBar.isDisplayed());
    }

    @And("The keyword {string} appears in the search results bar")
    public void productNameAppearsInSearchResultsBar(String productName) {
        Assert.assertEquals(searchResultsPage.searchResultsText.getText().replaceAll("\"", "").trim().toLowerCase(), productName.toLowerCase());
    }


    @Then("The Search suggestions is displayed dynamically with matching products for {string}")
    public void searchSuggestionsDisplayedDynamicallyWithMatchingProducts(String partialProductName) {
        int listSize = homePage.suggestionList.size();
        System.out.println(listSize);
        for (int count = 0; count < listSize; count++) {
            Assert.assertTrue(homePage.suggestionList.get(count).getText().toLowerCase().contains(partialProductName.toLowerCase()));
        }
        System.out.println("All suggestions are relevant");
    }

    @And("User enter the price range as {string} to {string} in price filter")
    public void userEnterThePriceRangeAsToInPriceFilter(String min, String max) throws InterruptedException {
        resultsCount = Integer.parseInt(searchResultsPage.searchResultsCount.getText().split(" ")[0]);
        searchResultsPage.clickOnElement(searchResultsPage.priceLookUp);
        searchResultsPage.selectPriceRange(min, max);
        Thread.sleep(3000);
    }

    @And("User selects {string} from the Brand filter")
    public void userSelectsBrandFromBrandFilter(String brandName) throws InterruptedException {
        Assert.assertNotEquals(Integer.parseInt(searchResultsPage.searchResultsCount.getText().split(" ")[0]), resultsCount);
        resultsCount = Integer.parseInt(searchResultsPage.searchResultsCount.getText().split(" ")[0]);
        searchResultsPage.selectAppleBrand();
        Thread.sleep(3000);
        Assert.assertEquals(searchResultsPage.searchResultsText.getText().replaceAll("\"", "").trim().toLowerCase(), brandName.toLowerCase());
    }

    @Then("The search result page is updated dynamically")
    public void searchResultPageUpdatedDynamically() {
        searchResultsPage.waitToBeInvisible(searchResultsPage.loader);
        Assert.assertNotEquals(Integer.parseInt(searchResultsPage.searchResultsCount.getText().split(" ")[0]), resultsCount);
    }

    @And("All the results' prices are between {string} and {string}")
    public void allResultsAndTheirPriceBetweenTheRange(String min, String max) {
        int priceListSize = searchResultsPage.productsPriceList.size();
        System.out.println(priceListSize);
        int minValue = Integer.parseInt(min);
        int maxValue = Integer.parseInt(max);
        int currentValue;
        for (int count = 0; count < priceListSize; count++) {
            currentValue = Integer.parseInt(searchResultsPage.productsPriceList.get(count).getText().replaceAll(",","").trim());
            if (currentValue >= minValue && currentValue <= maxValue){
                System.out.println("Price " + currentValue + " is within the range.");
            } else {
                System.out.println("Price " + currentValue + " is OUTSIDE the range (" + minValue + " - " + maxValue + ")");
                Assert.fail("Found a price out of range: " + currentValue);
            }
        }
    }

    @And("All the results' names are related to {string}")
    public void allTheResultsNamesAreRelatedTo(String brandName) {
        int nameListSize = searchResultsPage.productsNameList.size();
        System.out.println(nameListSize);
        for (int count = 0; count < nameListSize; count++) {
            Assert.assertTrue(searchResultsPage.productsNameList.get(count).getText().toLowerCase().contains(brandName.toLowerCase()));
        }
    }


    @After
    public void closeDriver() {
        tearDown();
    }


}
