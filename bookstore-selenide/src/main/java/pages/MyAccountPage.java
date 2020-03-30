package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selectors.*;
public class MyAccountPage {
    private SelenideElement emailField = $(byId("reg_email"));
    private SelenideElement passwordField = $(byId("reg_password"));
    private SelenideElement registerButton = $(byName("register"));

    public void inputEmail(String email){
        emailField.val(email);
    }
    public void inputPassword(String password){
        passwordField.val(password);
    }
    public void clickRegister(){
        registerButton.click();
    }
    public SuccessRegistrationPage performRegistration(String email, String password){
        inputEmail(email);
        inputPassword(password);
        clickRegister();
        return new SuccessRegistrationPage();
    }
}
