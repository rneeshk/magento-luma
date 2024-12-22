package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = {".//features/SignUp.feature"},
    glue = "stepsDefinitions",
    plugin = {"pretty", "html:target/SignUp.html"}, // Report generation
    monochrome = true
)
public class SignUpRunner {

}