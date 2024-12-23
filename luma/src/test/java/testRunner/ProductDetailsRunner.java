package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {".//features/ProductDetails.feature"},
	    glue = "stepsDefinitions",
	    plugin = {"pretty", "html:ProductDetails/Login.html"}
)

public class ProductDetailsRunner {

}
