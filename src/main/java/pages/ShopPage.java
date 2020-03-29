package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShopPage {
    private WebDriver driver;

    private By books = By.xpath(".//main//li");
    private By addToCartButtons = By.xpath(".//main//li/a[text() = 'Add to cart']");
    private By basket = By.xpath(".//*[@class='fas fa-shopping-bag']");
    private By viewCartLinks = By.xpath(".//main//li/a[text() = 'View cart']");

    private WebDriverWait wait;

    public ShopPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }
    public void clickAddToCartButton(int index){
        WebElement book = driver.findElements(books).get(index - 1);

        wait.until(ExpectedConditions.elementToBeClickable(book));

        Actions hover = new Actions(driver);
        hover.moveToElement(book).perform();

        WebElement addToCartButton = driver.findElements(addToCartButtons).get(index - 1);

        wait.until(ExpectedConditions.visibilityOf(addToCartButton));

        addToCartButton.click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(viewCartLinks));
    }

    public CartPage clickBasket(){
        driver.findElement(basket).click();
        return new CartPage(driver);
    }
}
