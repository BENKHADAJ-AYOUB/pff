package tests;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.MyAccountPage;

public class RegisterMyAccountTest extends TestBase {
    HomePage homePage;
    MyAccountPage myAccountPage;
    Faker fake = new Faker();
    String mail = fake.internet().emailAddress();
    String pswd = fake.internet().password();

    @Test(priority = 1)
    public void verifierLinkMyAccount() {
        homePage = new HomePage(driver);
        homePage.cliquerConsentCockies();
        myAccountPage = new MyAccountPage(driver);
        homePage.cliquerSurMyAccount();
        Assert.assertTrue(driver.getCurrentUrl().contains("my-account"));
    }

    @Test(priority = 2)
    public void verifierRegisterValid() {
        myAccountPage.remplirFormulaireRegister(mail, pswd);
        myAccountPage.clickerSurBtnRegister();
        Assert.assertTrue(myAccountPage.signOutElement.getText().contains("out"));
        myAccountPage.signOut();
        Assert.assertTrue(driver.getCurrentUrl().contains("my-account"));

    }
}
