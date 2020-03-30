package registration;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.MyAccountPage;
import pages.SuccessRegistrationPage;

import static com.codeborne.selenide.Selenide.open;

public class RegistrationTests {
    @Test
    public void testRegistrationPositive(){
        open("http://www.automation.ho.ua/");
        HomePage homePage = new HomePage();
        MyAccountPage myAccountPage = homePage.clickMyAccount();
        SuccessRegistrationPage successRegistrationPage =
                myAccountPage.performRegistration(
                        "qa_testuser999@email.com", "1234asdQQ!!!098");
        successRegistrationPage.isTextAfterRegistration("Hello");

    }
}
