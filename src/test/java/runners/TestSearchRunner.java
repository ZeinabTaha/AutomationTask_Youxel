package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        tags = "@Search",
        features = "src/test/resources/features",
        glue = {"stepdefinations"},
        plugin = {"pretty", "html:target/SearchFeature_report", "json:target/SearchFeature_report.json"}
)

public class TestSearchRunner extends AbstractTestNGCucumberTests {
}
