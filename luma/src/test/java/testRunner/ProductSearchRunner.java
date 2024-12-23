package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {".//features/ProductSearch.feature"},
		glue = "stepsDefinitions",
		plugin = {"pretty", "html:target/ProductSearch.html"}
)
public class ProductSearchRunner {

}
