package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class HomePage {
    private SelenideElement myAccount = $(byText("My Account"));

    public MyAccountPage clickMyAccount(){
        myAccount.click();
        return new MyAccountPage();
    }
}
