package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.MyAccountPage;

public class HomePageTest extends TestBase{
    HomePage homePage;
    String urlHome = "https://practice.automationtesting.in/";
    MyAccountPage myAccountPage;
    @Test(priority = 1)
    public void verifierLogo()
    {
        homePage =new HomePage(driver);
        homePage.cliquerConsentCockies();
        myAccountPage = new MyAccountPage(driver);
        Assert.assertTrue(homePage.logoElement.getAttribute("href").contains(urlHome));
    }
    @Test(priority = 2)
    public void verifierLinkMyAccount()
    {
        homePage.cliquerSurMyAccount();
        Assert.assertTrue(driver.getCurrentUrl().contains("my-account"));
    }

}
