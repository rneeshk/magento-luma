package stepsDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SignUpSteps {

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
    By signupbutton = By.xpath("//div[@class='panel header']//a[normalize-space()='Create an Account']");
    By createAccountBtn = By.xpath("//button[@title='Create an Account']//span[contains(text(),'Create an Account')]");
    By firstname = By.xpath("//input[@id='firstname']");
    By lastname = By.xpath("//input[@id='lastname']");
    By email = By.xpath("//input[@id='email_address']");
    By password = By.xpath("//input[@id='password']");
    By confirmpassword = By.xpath("//input[@id='password-confirmation']");
    By passwordstrength = By.xpath("//div[@id='password-strength-meter']");
    By createAccount = By.xpath("//button[@title='Create an Account']");
    By signupsuccessful = By.xpath("//div[@class='message-success success message']");
    By firstnameerror = By.xpath("//div[@id='firstname-error']");
    By lastnameerror = By.xpath("//div[@id='lastname-error']");
    By emailerror = By.xpath("//div[@id='email_address-error']");
    By passworderror = By.xpath("//div[@id='password-error']");
    By confirmpassworderror = By.xpath("//div[@id='password-confirmation-error']");
    By messageerror = By.xpath("//div[@class='message-error error message']");
    By emailalreadyexist = By.xpath("//div[@class='message-error error message']");
    
    @Given("the user is on the sign-up page")
    public void the_user_is_on_the_sign_up_page() {
    	driver.get(websiteURL);
        driver.findElement(signupbutton).click();
    }

    @When("the user enters first name")
    public void the_user_enters_first_name() {
    	driver.findElement(firstname).sendKeys("Test");
    }

    @When("the user enters last name")
    public void the_user_enters_last_name() {
    	driver.findElement(lastname).sendKeys("User");
    }

    @When("the user enters email")
    public void the_user_enters_email() {
    	driver.findElement(email).sendKeys("testuser25015@example.com");
    }

    @When("the user enters password")
    public void the_user_enters_password() {
    	driver.findElement(password).sendKeys("testuser@25015");

    }



    @When("the user enters confirm password")
    public void the_user_enters_confirm_password() {
    	driver.findElement(confirmpassword).sendKeys("testuser@25015");
    }

    @When("clicks the Create an Account button")
    public void clicks_the_create_an_account_button() throws InterruptedException {
    	driver.findElement(createAccountBtn).click();
    	Thread.sleep(5000);
    }

    @Then("the user should see a successful sign up message")
    public void the_user_should_see_a_successful_sign_up_message() {
    	driver.findElement(signupsuccessful).getText().contains("Thank you for registering");
    }

    @When("the user enters data of maximum allowed length for the first name field")
    public void the_user_enters_data_of_maximum_allowed_length_for_the_first_name_field() {
    	String longString = "a".repeat(255);
    	driver.findElement(firstname).sendKeys(longString);
    }

    @When("the user enters data of maximum allowed length for the last name field")
    public void the_user_enters_data_of_maximum_allowed_length_for_the_last_name_field() {
    	String longString = "a".repeat(255);
    	driver.findElement(lastname).sendKeys(longString);
    }

    @When("the user enters data of maximum allowed length for the email field")
    public void the_user_enters_data_of_maximum_allowed_length_for_the_email_field() {
    	String longEmail = "luma." + "home".repeat(10) + "@" + "example".repeat(5) + "." + "com";
    	driver.findElement(email).sendKeys(longEmail);
    }

    @When("the user enters data of maximum allowed length for the password field")
    public void the_user_enters_data_of_maximum_allowed_length_for_the_password_field() {
    	String longPassword = "P@1".repeat(30);
    	driver.findElement(password).sendKeys(longPassword);
    }

    @When("the user enters data of maximum allowed length for the confirm password field")
    public void the_user_enters_data_of_maximum_allowed_length_for_the_confirm_password_field() {
    	String longPassword = "P@1".repeat(30);
    	driver.findElement(confirmpassword).sendKeys(longPassword);
    }
    
    @Then("the user should see an required message below all fields")
    public void the_user_should_see_an_required_message_below_all_fields() {
    	driver.findElement(firstnameerror).getText().contains("This is a required field.");
    	driver.findElement(lastnameerror).getText().contains("This is a required field.");
    	driver.findElement(emailerror).getText().contains("This is a required field.");
    	driver.findElement(passworderror).getText().contains("This is a required field.");
    	driver.findElement(confirmpassworderror).getText().contains("This is a required field.");
    }

    @When("the user enters firstname")
    public void the_user_enters_firstname() {
    	driver.findElement(firstname).sendKeys("Test");
    }

    @When("the user enters lastname")
    public void the_user_enters_lastname() {
    	driver.findElement(lastname).sendKeys("User");
    }

    @When("the user enters invalid email")
    public void the_user_enters_invalid_email() {
    	driver.findElement(email).sendKeys("testuser@.com");
    }

    @Then("the user should see an error message indicating invalid email format")
    public void the_user_should_see_an_error_message_indicating_invalid_email_format() {
    	driver.findElement(emailerror).getText().contains("Please enter a valid email address");
    }

    @When("the user enters different confirm password")
    public void the_user_enters_different_confirm_password() {
    	driver.findElement(confirmpassword).sendKeys("different@12");
    }

    @Then("the user should see an error message indicating password and confirm password mismatch")
    public void the_user_should_see_an_error_message_indicating_password_and_confirm_password_mismatch() {
        driver.findElement(confirmpassworderror).getText().contains("Please enter the same value again.");
    }

    @When("the user enters without special characters password")
    public void the_user_enters_without_special_characters_password() {
    	driver.findElement(password).sendKeys("password1");
    }

    @When("the user enters without special characters confirm password")
    public void the_user_enters_without_special_characters_confirm_password() {
    	driver.findElement(confirmpassword).sendKeys("password1");
    }

    @Then("the user should see an error message indicating password without special characters")
    public void the_user_should_see_an_error_message_indicating_password_without_special_characters() {
        driver.findElement(passworderror).getText().contains("Special Characters");
    }

    @When("the user enters too short password")
    public void the_user_enters_too_short_password() {
        driver.findElement(password).sendKeys("p");
    }

    @When("the user enters too short confirm password")
    public void the_user_enters_too_short_confirm_password() {
        driver.findElement(confirmpassword).sendKeys("p");
    }

    @Then("the user should see an error message indicating password is weak")
    public void the_user_should_see_an_error_message_indicating_password_is_weak() {
    	driver.findElement(passwordstrength).getText().contains("Weak");
        driver.findElement(passworderror).getText().contains("Minimum length of this field must be equal or greater than 8");
    }

    @When("the user enters existing email")
    public void the_user_enters_existing_email() {
    	driver.findElement(email).sendKeys("testuser31998@example.com");
    }

    @Then("the user should see an error message indicating existing email address")
    public void the_user_should_see_an_error_message_indicating_existing_email_address() {
    	driver.findElement(emailalreadyexist).getText().contains("There is already an account with this email address");
    }

    @When("the user enters data of minimum allowed length for the First Name field")
    public void the_user_enters_data_of_minimum_allowed_length_for_the_first_name_field() {
    	driver.findElement(firstname).sendKeys("f");
    }
}