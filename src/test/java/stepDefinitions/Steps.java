package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import pages.*;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class Steps {
    private WebDriver driver;
    protected HomePage homePage;
    protected ShopPage shopPage;
    protected CartPage cartPage;
    protected CheckOutPage checkOutPage;
    private OrderDetailsPage orderDetailsPage;

    @Given("Open Chrome and go to home page")
    public void open_Chrome_and_go_to_home_page() {
        driver = driverInit();
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get("http://www.automation.ho.ua");
        homePage = new HomePage(driver);
    }

    @And("Click Shop link")
    public void click_Shop_link() {
        shopPage = homePage.clickShopLink();
    }
    @When("Add {int} book to cart")
    public void add_book_to_cart(int int1) {
       shopPage.clickAddToCartButton(int1);
    }
    @And("Click on Basket")
    public void click_on_Basket() {
        cartPage = shopPage.clickBasket();
    }
    @And("Set quantity for {int} -st product equals to {string} and update order")
    public void set_quantity_for_st_product_equals_to(int arg0, String arg1) {
        cartPage.setQuantity(arg0, arg1);
        cartPage.clickUpdateCartButton();
    }

    @And("Click Proceed to checkout button")
    public void click_Proceed_To_Check_Out() {
        checkOutPage = cartPage.clickProceedToCheckOut();
    }
    @And("Fill billing details as new user")
    public void fill_billing_details_as_new_user() {
        checkOutPage.fillAllMandatoryFieldsInBillingDetailsWithRandomValues();
    }
    @And("Select {string} option as payment type")
    public void select_option_as_payment_type(String string) {
        checkOutPage.selectPaymentMethod(string);
    }
    @And("Click Place order button")
    public void click_Place_order_button() {
        orderDetailsPage = checkOutPage.clickPlaceOrderButton();
    }
    @Then("Message {string} is displayed")
    public void message_is_displayed(String string) {
        assertEquals("Incorrect messsage is displayed", string, orderDetailsPage.getMessage());
    }
    @And("Payment method {string} is displayed in Order Details")
    public void payment_method_is_displayed_in_Order_Details(String string) {
        assertEquals("Incorrect Payment Method is displayed", string, orderDetailsPage.getPaymentMethodInOrderDetails());
    }
    @And("Close browser")
    public void closeBrowser() {
        driver.quit();
    }

    private ChromeOptions getChromeOptions(){
        ChromeOptions options = new ChromeOptions();
        //options.setHeadless(true);
        return options;
    }

    private WebDriver driverInit(){
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver(getChromeOptions());
    }
}
