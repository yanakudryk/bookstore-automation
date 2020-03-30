package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selectors.*;

public class SuccessRegistrationPage {
    private SelenideElement textAfterSuccessRegistration = $(byXpath("//*[@class='woocommerce-MyAccount-content']/p[1]"));

    public void isTextAfterRegistration(String expectedText){
        textAfterSuccessRegistration.shouldHave(text(expectedText));
    }
}
