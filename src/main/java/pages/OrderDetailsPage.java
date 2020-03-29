package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderDetailsPage {
    private WebDriver driver;
    private By messageAboutReceivedOrder = By.xpath(".//*[@class = 'woocommerce-notice woocommerce-notice--success woocommerce-thankyou-order-received']");
    private By orderDetailsPaymentMethod = By.xpath(".//tr[contains(. , 'Payment method:')]/td");

    FluentWait wait;
    public OrderDetailsPage(WebDriver driver) {
        this.driver = driver;
        wait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(20))
                .ignoring(NoSuchElementException.class);
    }

    public String getMessage(){
        wait.until(ExpectedConditions.presenceOfElementLocated(messageAboutReceivedOrder));
        return driver.findElement(messageAboutReceivedOrder).getText();
    }

    public String getPaymentMethodInOrderDetails(){
        wait.until(ExpectedConditions.presenceOfElementLocated(orderDetailsPaymentMethod));
        return driver.findElement(orderDetailsPaymentMethod).getText();
    }
}
