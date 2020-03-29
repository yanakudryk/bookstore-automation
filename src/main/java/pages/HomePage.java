package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    private By shopLink = By.xpath("//a[text()='Shop']");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }
    public ShopPage clickShopLink(){
        driver.findElement(shopLink).click();
        return new ShopPage(driver);
    }
}
