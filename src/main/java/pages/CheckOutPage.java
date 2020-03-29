package pages;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Random;

import java.util.List;

public class CheckOutPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By billingFirstNameField = By.id("billing_first_name");
    private By billingLastNameField = By.id("billing_last_name");
    private By billingCompanyFieldOptional = By.id("billing_company");
    private By billingCountryDropDown = By.id("billing_country");
    private By billingStreet = By.id("billing_address_1");
    private By dillingApartmentOptional = By.id("billing_address_2");
    private By billingCity = By.id("billing_city");
    private By billingState = By.id("billing_state");
    private By billingPostcode = By.id("billing_postcode");
    private By billingPhone = By.id("billing_phone");
    private By billingEmail = By.id("billing_email");
    private By accountPassword = By.id("account_password");
    private By paymentMethodsRadioButtons = By.xpath(".//ul[@class = 'wc_payment_methods payment_methods methods']/li/input");
    private By getPaymentMethodsLabels = By.xpath(".//ul[@class = 'wc_payment_methods payment_methods methods']/li/label");
    private By placeOrderButton = By.id("place_order");

    public CheckOutPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public void fillAllMandatoryFieldsInBillingDetailsWithRandomValues(){
        driver.findElement(billingFirstNameField).sendKeys(RandomStringUtils.random(1, true, false).toUpperCase()
                + RandomStringUtils.random(5, true, false));
        driver.findElement(billingLastNameField).sendKeys(RandomStringUtils.random(1, true, false).toUpperCase()
                + RandomStringUtils.random(8, true, false));
        Select countryDropDown = new Select(driver.findElement(billingCountryDropDown));
        countryDropDown.selectByIndex(4);
        /**
         *   Random random = new Random();
         *   countryDropDown.selectByIndex(random.nextInt(250));
         *   Total amount of countries = 249
         */
        driver.findElement(billingStreet).sendKeys(RandomStringUtils.random(15, true, true));
        driver.findElement(billingCity).sendKeys(RandomStringUtils.random(1, true, false).toUpperCase()
                + RandomStringUtils.random(4, true, false));
        if(driver.findElement(billingState).isDisplayed()){
            driver.findElement(billingState).sendKeys(RandomStringUtils.random(1, true, false).toUpperCase()
                    + RandomStringUtils.random(4, true, false));
        }
        driver.findElement(billingPostcode).sendKeys(RandomStringUtils.random(5, false, true));
        driver.findElement(billingPhone).sendKeys(RandomStringUtils.random(11, false, true));
        driver.findElement(billingEmail).sendKeys(RandomStringUtils.random(6, true, false)
                + "@" + RandomStringUtils.random(4, true, false)
                + "." + RandomStringUtils.random(3, true, false));
        driver.findElement(accountPassword).sendKeys("123asdQQ098!!");
    }

    public void selectPaymentMethod(String paymentMethod){
        List<WebElement> paymentMethodsLabelsList = driver.findElements(getPaymentMethodsLabels);
        for (int i = 0; i < paymentMethodsLabelsList.size(); i++) {
            if(paymentMethodsLabelsList.get(i).getText().contains(paymentMethod)){
                driver.findElements(paymentMethodsRadioButtons).get(i).click();
            }
        }
    }

    public OrderDetailsPage clickPlaceOrderButton(){
        driver.findElement(placeOrderButton).click();
        return new OrderDetailsPage(driver);
    }

}
