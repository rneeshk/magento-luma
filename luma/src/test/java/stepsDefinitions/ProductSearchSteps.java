package stepsDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductSearchSteps {

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
	By searchbar = By.xpath("//input[@id='search']");
	By searchresult = By.xpath("//span[@class='base']");
	By relatedsearchbox = By.xpath("//dl[@class='block']");
	By messagenotice = By.xpath("//div[@class='message notice']");
	
	@Given("User is on the website homepage")
	public void user_is_on_the_website_homepage() {
	    driver.get(websiteURL);
	}

	@When("User enters a valid keyword in the search bar")
	public void user_enters_a_valid_keyword_in_the_search_bar() {
	    driver.findElement(searchbar).sendKeys("Tops");
	}

	@When("User presses enter")
	public void user_presses_enter() {
		driver.findElement(searchbar).sendKeys(Keys.ENTER);
	}

	@Then("Search results containing relevant products are displayed")
	public void search_results_containing_relevant_products_are_displayed() {
	    driver.findElement(searchresult).getText().contains("Tops");
	}

	@When("User enters a partial keyword in the search bar")
	public void user_enters_a_partial_keyword_in_the_search_bar() {
		driver.findElement(searchbar).sendKeys("Shi");
	}

	@Then("Search results containing items related to the partial keyword are displayed")
	public void search_results_containing_items_related_to_the_partial_keyword_are_displayed() {
		driver.findElement(searchresult).getText().contains("Shi");
	}

	@Then("Related search terms are suggested")
	public void related_search_terms_are_suggested() {
	    driver.findElement(relatedsearchbox).getText().contains("shirt");
	}

	@When("User enters special characters in the search bar")
	public void user_enters_special_characters_in_the_search_bar() {
	    driver.findElement(searchbar).sendKeys("@#$%^&*()");
	}

	@Then("No relevant search results are displayed")
	public void no_relevant_search_results_are_displayed() {
	    driver.findElement(searchresult).getText().contains("@#$%^&*()");
	}

	@Then("An appropriate message indicating no results is displayed")
	public void an_appropriate_message_indicating_no_results_is_displayed() {
	    driver.findElement(messagenotice).getText().contains("Your search returned no results.");
	}

	@When("User enters a non-existent product in the search bar")
	public void user_enters_a_non_existent_product_in_the_search_bar() {
		driver.findElement(searchbar).sendKeys("@NonExistentProduct123");
	}

	@Given("User enters a search string with maximum characters in the search bar")
	public void user_enters_a_search_string_with_characters_in_the_search_bar() {
	    String longtext = "a".repeat(255);
	    driver.findElement(searchbar).sendKeys(longtext);
	}

	@When("User enters a search query with a single character in the search bar")
	public void user_enters_a_search_query_with_a_single_character_in_the_search_bar() {
		driver.findElement(searchbar).sendKeys("s");
	}

	@Then("Search results containing relevant items are displayed")
	public void search_results_containing_relevant_items_are_displayed() {
		driver.findElement(searchresult).getText().contains("s");
	}

	@Then("An appropriate message indicating the minimum length requirement is displayed")
	public void an_appropriate_message_indicating_the_minimum_length_requirement_is_displayed() {
	    driver.findElement(messagenotice).getText().contains("Minimum Search query length is 3");
	}
}
