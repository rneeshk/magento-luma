package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = {".//features/Login.feature"},
    glue = "stepsDefinitions",
    plugin = {"pretty", "html:target/Login.html"}, // Report generation
    monochrome = true
)
public class LoginRunner {

}
