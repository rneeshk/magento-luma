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
    By differentconfirmpassword = By.xpath("//input[@id='password-confirmation']");
    
    
    @Given("User is on the homepage and logged in")
    public void user_is_on_the_homepage_and_logged_in() throws InterruptedException {
    	driver.get(websiteURL);
        driver.findElement(loginpage).click();
        driver.findElement(email).sendKeys("testuser25015@example.com");
        driver.findElement(password).sendKeys("testuser@25015");
        driver.findElement(loginbutton).click();
        Thread.sleep(2000);
    }

    @Then("verify User should be logged in successfully")
    public void verify_user_should_be_logged_in_successfully() throws InterruptedException {
    	driver.findElement(username).getText().contains("Test User");
        driver.findElement(dropdown).click();
        Thread.sleep(2000);
        driver.findElement(myaccount).click();
        Thread.sleep(2000);
    }

    @When("User clicks on the change password button")
    public void user_clicks_on_the_change_password_button() throws InterruptedException {
        driver.findElement(changepasswordbtn).click();
        Thread.sleep(2000);
    }

    @When("User enters the current password")
    public void user_enters_the_current_password() {
    	driver.findElement(currentpassword).sendKeys("testuser@25015");
    }

    @When("User enters a new password")
    public void user_enters_a_new_password() {
    	driver.findElement(newpassword).sendKeys("testuser@25015");
    }

    @When("User enters the confirmation password")
    public void user_enters_the_confirmation_password() {
    	driver.findElement(newpasswordconfirm).sendKeys("testuser@25015");
    }

    @When("User clicks the Save button")
    public void user_clicks_the_save_button() throws InterruptedException {
        driver.findElement(savebutton).click();
        Thread.sleep(2000);
    }

    @Then("User should see a success message")
    public void user_should_see_a_success_message() {
    	driver.findElement(informationchangesuccess).getText().contains("You saved the account information.");
    }

    @When("User clicks on the edit button")
    public void user_clicks_on_the_edit_button() throws InterruptedException {
        driver.findElement(editbutton).click();
        Thread.sleep(2000);
    }

    @When("User checks the change email checkbox")
    public void user_checks_the_change_email_checkbox() throws InterruptedException {
        driver.findElement(emailboxcheck).click();
        Thread.sleep(2000);
    }

    @When("User clears the Email field")
    public void user_clears_the_email_field() {
        driver.findElement(email).clear();
    }

    @When("User enters email")
    public void user_enters_email() {
    	driver.findElement(email).sendKeys("testuser25015@example.com");
    }

    @When("User clicks on the manage address button")
    public void user_clicks_on_the_manage_address_button() throws InterruptedException {
        driver.findElement(manageaddress).click();
        Thread.sleep(2000);
    }

    @When("User clicks the Save Address button")
    public void user_clicks_the_save_address_button() throws InterruptedException {
        driver.findElement(saveaddress).click();
        Thread.sleep(2000);
    }

    @Then("User should see a required message for the required fields")
    public void user_should_see_a_required_message_for_the_required_fields() {
    	driver.findElement(telephoneerror).getText().contains("This is a required field.");
    	driver.findElement(streeterror).getText().contains("This is a required field.");
    	driver.findElement(cityerror).getText().contains("This is a required field.");
    	driver.findElement(regionerror).getText().contains("Please select an option.");
    	driver.findElement(ziperror).getText().contains("This is a required field.");
    }

    @When("User enters a different confirmation password")
    public void user_enters_a_different_confirmation_password() {
        driver.findElement(differentconfirmpassword).sendKeys("Different@12");
    }

    @Then("User should see an error message related to password mismatch")
    public void user_should_see_an_error_message_related_to_password_mismatch() {
        driver.findElement(confirmpassworderror).getText().contains("Please enter the same value again.");
    }
}
