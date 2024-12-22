package stepsDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {
	
	WebDriver driver;
	WebDriverWait wait;
    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
	
    String websiteURL = "https://magento.softwaretestingboard.com/";
    By login = By.xpath("//div[@class='panel header']//a[contains(text(),'Sign In')]");
    By email = By.xpath("//input[@id='email']");
    By password = By.xpath("//fieldset[@class='fieldset login']//input[@id='pass']");
    By loginButton = By.xpath("//fieldset[@class='fieldset login']//span[contains(text(),'Sign In')]");
    By welcomeusername = By.cssSelector("div[class='panel header'] span[class='logged-in']");
    By loginfailed = By.xpath("//div[@class='message-error error message']");
    By emailrequired = By.xpath("//div[@id='email-error']");
    By passwordrequired = By.xpath("//div[@id='pass-error']");
    
    
	@Given("User is on the login page")
	public void user_is_on_the_login_page() {
	    driver.get(websiteURL);
	    driver.findElement(login).click();
	}

	@When("User enters valid email")
	public void user_enters_valid_email() {
		driver.findElement(email).clear();
	    driver.findElement(email).sendKeys("testuser25015@example.com");
		
	}

	@When("User enters valid password")
	public void user_enters_valid_password() {
		driver.findElement(password).clear();
	    driver.findElement(password).sendKeys("testuser@25015");
	}

	@When("User clicks the login button")
	public void user_clicks_the_login_button() throws InterruptedException {
	    driver.findElement(loginButton).click();
	    Thread.sleep(5000);
	}

	@Then("User should be redirected to the dashboard")
	public void user_should_be_redirected_to_the_dashboard() {
	    driver.findElement(welcomeusername).getText().contains("Test User");
	}

	@When("User enters incorrect password")
	public void user_enters_incorrect_password() {
		driver.findElement(password).clear();
		driver.findElement(password).sendKeys("testuser@25014");
	}

	@Then("User should see an error message indicating incorrect credentials")
	public void user_should_see_an_error_message_indicating_incorrect_credentials() {
	    driver.findElement(loginfailed).getText().contains("The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.");
	}

	@When("User enters an unregistered email")
	public void user_enters_an_unregistered_email() {
		driver.findElement(email).clear();
	    driver.findElement(email).sendKeys("rk1441933@gmail.com");
	}

	@When("User enters a password")
	public void user_enters_a_password() {
		driver.findElement(password).clear();
		driver.findElement(password).sendKeys("testuser@25015");
	}

	@Then("User should see an error message prompting for username and password required")
	public void user_should_see_an_error_message_prompting_for_username_and_password_required() {
	    driver.findElement(emailrequired).getText().contains("This is a required field.");
	    driver.findElement(passwordrequired).getText().contains("This is a required field.");
	}

	@When("User enters an invalid email")
	public void user_enters_an_invalid_email() {
		driver.findElement(email).clear();
		driver.findElement(email).sendKeys("rk1441933@gmail.com");
	}

	@When("User enters an invalid password")
	public void user_enters_an_invalid_password() {
		driver.findElement(password).clear();
		driver.findElement(password).sendKeys("Password1");
	}

	@When("User enters email with incorrect case")
	public void user_enters_email_with_incorrect_case() {
		driver.findElement(email).clear();
		driver.findElement(email).sendKeys("TestUser25015@example.com");
	}

	@When("User enters password with incorrect case")
	public void user_enters_password_with_incorrect_case() {
		driver.findElement(password).clear();
		driver.findElement(password).sendKeys("TestUser@25015");
	}

	@When("User enters email with SQL injection")
	public void user_enters_email_with_sql_injection() {
		driver.findElement(email).clear();
		driver.findElement(email).sendKeys("'1'='1 \"");
	}
	
	@Then("User should see an error message indicating incorrect email")
	public void user_should_see_an_error_message_indicating_incorrect_email() {
		driver.findElement(emailrequired).getText().contains("Please enter a valid email address ");
	}

	@When("User enters a valid email")
	public void user_enters_a_valid_email() {
		driver.findElement(email).clear();
		driver.findElement(email).sendKeys("testuser25015@example.com");
	}

	@When("User enters password with SQL injection")
	public void user_enters_password_with_sql_injection() {
		driver.findElement(password).clear();
		driver.findElement(password).sendKeys("'1'='1 \"");
	}
}
