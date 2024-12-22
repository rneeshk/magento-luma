package stepsDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AccountInfoUpdateSteps {
	
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
    By loginpage = By.xpath("//div[@class='panel header']//a[contains(text(),'Sign In')]");
    By email = By.xpath("//input[@id='email']");
    By password = By.xpath("//fieldset[@class='fieldset login']//input[@id='pass']");
    By loginbutton = By.xpath("//fieldset[@class='fieldset login']//span[contains(text(),'Sign In')]");
    By username = By.cssSelector("div[class='panel header'] span[class='logged-in']");
    By dropdown = By.xpath("//div[@class='panel header']//button[@type='button']");
    By myaccount = By.xpath("//div[@aria-hidden='false']//a[normalize-space()='My Account']");
    By editbutton = By.xpath("//div[@class='box box-information']//a[@class='action edit']");
    By changepasswordbtn = By.xpath("//a[normalize-space()='Change Password']");
    By currentpassword = By.xpath("//input[@id='current-password']");
    By newpassword = By.xpath("//input[@id='password']");
    By newpasswordconfirm = By.xpath("//input[@id='password-confirmation']");
    By savebutton = By.xpath("//button[@title='Save']");
    By informationchangesuccess = By.xpath("//div[@class='message-success success message']");
    By emailboxcheck = By.xpath("//input[@id='change-email']");
    By manageaddress = By.xpath("//span[normalize-space()='Manage Addresses']");
    By saveaddress = By.xpath("//button[@title='Save Address']");
    By telephoneerror = By.xpath("//div[@id='telephone-error']");
    By streeterror = By.xpath("//div[@id='street_1-error']");
    By cityerror = By.xpath("//div[@id='city-error']");
    By regionerror = By.xpath("//div[@id='region_id-error']");
    By ziperror = By.xpath("//div[@id='zip-error']");
    By emailerror = By.xpath("//div[@id='email-error']");
    By confirmpassworderror = By.xpath("//div[@id='password-confirmation-error']");
    By emailalreadyexist = By.xpath("//div[@class='message-error error message']");
    
    
    
    @Given("User is on the Magento website")
    public void user_is_on_the_magento_website() {
        driver.get(websiteURL);
    }

    @Given("User navigates to the Sign In page")
    public void user_navigates_to_the_sign_in_page() {
        driver.findElement(loginpage).click();
    }

    @When("User enters the valid email")
    public void user_enters_the_valid_email() {
        driver.findElement(email).sendKeys("testuser25015@example.com");
    }
    
    @When("User enters the valid password")
    public void user_the_enters_valid_password() {
    	driver.findElement(password).sendKeys("testuser@25015");
    }
    
    @When("User clicks the Sign In button")
    public void user_clicks_the_sign_in_button() throws InterruptedException {
        driver.findElement(loginbutton).click();
        Thread.sleep(3000);
    }

    @Then("User should be logged in successfully")
    public void user_should_be_logged_in_successfully() {
        driver.findElement(username).getText().contains("Test User");
    }

    @Then("User navigates to the My Account page")
    public void user_navigates_to_the_my_account_page() {
        driver.findElement(dropdown).click();
        driver.findElement(myaccount).click();
    }

    @When("User click on change password button")
    public void user_click_on_change_password_button() {
        driver.findElement(changepasswordbtn).click();
    }

    @When("User enters current password")
    public void user_enters_current_password() {
        driver.findElement(currentpassword).sendKeys("testuser@25015");
    }

    @When("User enters new password")
    public void user_enters_new_password() {
    	driver.findElement(newpassword).sendKeys("testuser@25015");
    }

    @When("User enters confirmation password")
    public void user_enters_confirmation_password() {
        
    }

    @When("User clicks the Save button")
    public void user_clicks_the_save_button() {
        driver.findElement(savebutton).click();
    }

    @Then("User should see a success message")
    public void user_should_see_a_success_message() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("User click on edit button")
    public void user_click_on_edit_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("User check the change email checkbox")
    public void user_check_the_change_email_checkbox() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("User clears the Email field")
    public void user_clears_the_email_field() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("User enters new valid email")
    public void user_enters_new_valid_email() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("User click manage address button")
    public void user_click_manage_address_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("User clicks the Save Address button")
    public void user_clicks_the_save_address_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("User should see an reqired message for the required fields.")
    public void user_should_see_an_reqired_message_for_the_required_fields() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("User enters invalid email")
    public void user_enters_invalid_email() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("User should see an error message for enter invalid email")
    public void user_should_see_an_error_message_for_enter_invalid_email() {
    	driver.findElement(emailerror).getText().contains("Please enter a valid email address.");
    }

    @When("User enters different confirmation password")
    public void user_enters_different_confirmation_password() {
    	driver.findElement(newpassword).sendKeys("Different@12");
    }

    @Then("User should see an error message related to password mismatch")
    public void user_should_see_an_error_message_related_to_password_mismatch() {
    	driver.findElement(confirmpassworderror).getText().contains("Please enter the same value again.");
    }

    @When("User enters existing email")
    public void user_enters_existing_email() {
        driver.findElement(email).sendKeys("testuser25014@example.com");
    }

    @Then("User should see an error message indicating the email is already in use")
    public void user_should_see_an_error_message_indicating_the_email_is_already_in_use() {
        driver.findElement(emailalreadyexist).getText().contains("The password doesn't match this account. Verify the password and try again.");
    }
}
