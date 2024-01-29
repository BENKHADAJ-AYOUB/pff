package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.MyAccountPage;

public class LoginMyAccountTest extends TestBase{
    HomePage homePage;
    MyAccountPage myAccountPage;

    @Test(priority = 1)
    public void verifierLinkMyAccount() {
        homePage = new HomePage(driver);
        homePage.cliquerConsentCockies();
        homePage.cliquerSurMyAccount();
        Assert.assertTrue(driver.getCurrentUrl().contains("my-account"));
    }

    @Test(priority = 2)
    public void verifierLoginValid() {
        myAccountPage = new MyAccountPage(driver);
        myAccountPage.remplirFormulaireLogin("doca@gmail.com", "DocaPoste123@");
        myAccountPage.clickerSurBtnLogin();
        Assert.assertTrue(myAccountPage.signOutElement.getText().contains("out"));
        myAccountPage.signOut();
        Assert.assertTrue(driver.getCurrentUrl().contains("my-account"));

    }
}
