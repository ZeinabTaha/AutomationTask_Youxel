package stepdefinations;

import io.cucumber.java.en.Given;
import utilities.Setup;

public class PreStepDef extends Setup{

    @Given("User Opens {string} and the website {string}")
    public void userOpensTheWebsite(String browser, String url){
        setUpBrowser(browser);
        navigateToURL(url);
    }
}
