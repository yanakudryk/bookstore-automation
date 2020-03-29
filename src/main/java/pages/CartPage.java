package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;



import java.time.Duration;



public class CartPage {
    private WebDriver driver;
    private By checkOutButton = By.xpath(".//*[@class='checkout-button button alt wc-forward']");
    private By spinnerUp = By.xpath(".//*[@class='blockUI blockOverlay']");
    private By spinnerDown = By.xpath(".//*[@class='blockUI']");
    private By quantities =  By.xpath(".//*[@class='input-text qty text']");
    private By updateCartButton = By.name("update_cart");
    private WebDriverWait wait;

    public CartPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public void setQuantity(int productNumber, String quantity){
        driver.findElements(quantities).get(productNumber - 1).clear();
        driver.findElements(quantities).get(productNumber - 1).sendKeys(quantity);
    }
    public void clickUpdateCartButton(){
        wait.until(ExpectedConditions.elementToBeClickable(updateCartButton));
        driver.findElement(updateCartButton).click();
        wait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElement(spinnerUp), driver.findElement(spinnerDown)));
    }
    public CheckOutPage clickProceedToCheckOut(){
        WebElement element = driver.findElement(checkOutButton);
        /*
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
         */
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);

        return new CheckOutPage(driver);
    }

}
