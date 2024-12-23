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

public class ProductDetailsSteps {
	
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
    By productlink = By.xpath("//a[@title='Radiant Tee'][normalize-space()='Radiant Tee']");
    By productname = By.xpath("//span[@class='base']");
    By productdescription = By.xpath("//div[@id='description']");
    By productprice = By.cssSelector("span[id='product-price-1556'] span[class='price']");
    By image = By.xpath("(//img[@alt='Radiant Tee'])[4]");
    By selectmediumsize = By.xpath("//div[@id='option-label-size-143-item-168']");
    By selectcolor = By.xpath("//div[@id='option-label-color-93-item-56']");
    By quantity = By.xpath("//input[@id='qty']");
    By addtocart = By.xpath("//button[@id='product-addtocart-button']");
    By successfuladded = By.xpath("//div[@class='message-success success message']");
    By cart = By.xpath("//a[@class='action showcart']");
    By quantityerror = By.xpath("//div[@id='qty-error']");
    By sizeerror = By.xpath("//div[@class='swatch-attribute size']//div[contains(@id,'super_attribute')]");
    By colorerror = By.xpath("//div[@class='swatch-attribute color']//div[contains(@id,'super_attribute')]");
    By subtotal = By.xpath("//div[@class='subtotal']");
	
	
	@Given("I am on the website homepage")
	public void i_am_on_the_website_homepage() {
	    driver.get(websiteURL);
	}

	@Given("I click on a product thumbnail or link from the product listing page")
	public void i_click_on_a_product_thumbnail_or_link_from_the_product_listing_page() throws InterruptedException {
	    driver.findElement(productlink).click();
	    Thread.sleep(2000);
	}

	@Then("I should see the product name")
	public void i_should_see_the_product_name() {
	    driver.findElement(productname).isDisplayed();
	}

	@Then("I should see the product description")
	public void i_should_see_the_product_description() {
		driver.findElement(productdescription).isDisplayed();
	}

	@Then("I should see the product price")
	public void i_should_see_the_product_price() {
	    driver.findElement(productprice).isDisplayed();
	}

	@Then("I should see the product images")
	public void i_should_see_the_product_images() {
	    driver.findElement(image).isDisplayed();
	}

	@When("I select the size")
	public void i_select_the_size() throws InterruptedException {
	    driver.findElement(selectmediumsize).click();
	    Thread.sleep(1000);
	}

	@When("I choose color")
	public void i_choose_color() throws InterruptedException {
	    driver.findElement(selectcolor).click();
	    Thread.sleep(1000);
	}

	@Then("I should see a success message indicating the product was added to the cart")
	public void i_should_see_a_success_message_indicating_the_product_was_added_to_the_cart() {
		String prodname = driver.findElement(productname).getText();
	    driver.findElement(successfuladded).getText().contains("You added " + prodname + " to your shopping cart.");
	}

	@Then("the cart total should be updated")
	public void the_cart_total_should_be_updated() throws InterruptedException {
	    driver.findElement(cart).click();
	    Thread.sleep(2000);
	    driver.findElement(subtotal).getText().contains("44");
	    
	}

	@When("I enter a negative quantity in the quantity field")
	public void i_enter_a_negative_quantity_in_the_quantity_field() {
	    driver.findElement(quantity).sendKeys("-1");
	}

	@Then("I should see an error message indicating an invalid quantity")
	public void i_should_see_an_error_message_indicating_an_invalid_quantity() {
	    driver.findElement(quantityerror).getText().contains("The maximum you may purchase is 10000.");
	}

	@When("I enter the maximum quantity in the quantity field")
	public void i_enter_the_maximum_quantity_in_the_quantity_field() {
	    driver.findElement(quantity).sendKeys("13200");
	}

	@Then("I should see a message indicating the product was added to the cart")
	public void i_should_see_a_message_indicating_the_product_was_added_to_the_cart() {
		
		String prodname = driver.findElement(productname).getText();
	    driver.findElement(successfuladded).getText().contains("You added " + prodname + " to your shopping cart.");
	}

	@When("I enter a quantity one in the quantity field")
	public void i_enter_a_quantity_one_in_the_quantity_field() {
		driver.findElement(quantity).sendKeys("1");
	}

	@Then("I enter a valid quantity in the quantity field")
	public void i_enter_a_valid_quantity_in_the_quantity_field() {
	    driver.findElement(quantity).sendKeys("10");
	}

	@Then("I click the add to cart button")
	public void i_click_the_add_to_cart_button() throws InterruptedException {
	    driver.findElement(addtocart).click();
	    Thread.sleep(2000);
	}
	
	@Then("I clear quantity input")
	public void I_clear_quantity_input() {
	    driver.findElement(quantity).clear();
	}

	@Then("I should see an required field error.")
	public void i_should_see_an_required_field_error() {
	    driver.findElement(sizeerror).getText().contains("This is a required field.");
	    driver.findElement(colorerror).getText().contains("This is a required field.");
	    driver.findElement(quantityerror).getText().contains("Please enter a valid number in this field.");
	}
}
