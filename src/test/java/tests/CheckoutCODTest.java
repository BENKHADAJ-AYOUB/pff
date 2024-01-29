package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.PanierPage;
import pages.ShopPage;

public class CheckoutCODTest extends TestBase{
    HomePage homePage;
    PanierPage panierPage;
    ShopPage shopPage;


    @Test(priority =1)
    public void verifierCheckoutCOD()
    {
        //Homme page
        homePage =new HomePage(driver);
        homePage.cliquerConsentCockies();
        homePage.cliquerSurShop();
        //page shop
        shopPage = new ShopPage(driver);
        //Verifier product Android Quick Start Guide
        Assert.assertTrue(shopPage.titreProduitElement.getText().contains("Android Quick Start Guide"));
        shopPage.cliquerSurAddTobasket();
        homePage.cliquerSurPanier();
    }
}
