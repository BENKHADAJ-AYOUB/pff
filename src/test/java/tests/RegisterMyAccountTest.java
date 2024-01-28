package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.MyAccountPage;

public class RegisterMyAccountTest extends TestBase {
    HomePage homePage;
    MyAccountPage myAccountPage;

    @Test(priority = 1)
    public void verifierLinkMyAccount() {
        homePage = new HomePage(driver);
        myAccountPage = new MyAccountPage(driver);
        homePage.cliquerSurMyAccount();
        Assert.assertTrue(driver.getCurrentUrl().contains("my-account"));
    }

    @Test(priority = 2)
    public void verifierRegisterValid() {
        homePage = new HomePage(driver);
        myAccountPage = new MyAccountPage(driver);
        myAccountPage.creerUnCompte("doca@gmail.com", "DocaPoste123@");
        Assert.assertTrue(myAccountPage.signOutElement.getText().contains("out"));
        myAccountPage.signOut();
        Assert.assertTrue(driver.getCurrentUrl().contains("my-account"));

    }
}
