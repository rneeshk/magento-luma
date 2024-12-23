package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(
		features = {".//features/AccountInfoUpdate.feature"},
		glue = "stepsDefinitions",
		plugin = {"pretty", "html:target/AccountInfoUpdate.html"}
)
public class AccountInfoUpdateRunner {

}
