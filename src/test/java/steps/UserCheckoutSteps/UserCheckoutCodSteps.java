package steps.UserCheckoutSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.*;
import steps.TestBase;

public class UserCheckoutCodSteps {
    HomePage homePage;
    PanierPage panierPage;
    ShopPage shopPage;
    GuestOrUsertInformation userInformations;
    OrderDetailsPage orderDetailsPage;
    static WebDriver driver;

    @Given("que je suis sur le shop pour USER")
    public void que_je_suis_sur_le_shopPourUSER() {
        driver = TestBase.getDriver();
        //Homme page
        homePage = new HomePage(driver);
        homePage.cliquerConsentCockies();
        homePage.cliquerSurShop();
        //page shop
        shopPage = new ShopPage(driver);
        //Verifier product Android Quick Start Guide
        Assert.assertTrue(shopPage.titreProduitElement.getText().contains("Android Quick Start Guide"));
    }

    @Given("que j'ai ajouté des articles à mon panier pour USER")
    public void que_j_ai_ajouté_des_articles_à_mon_panierPourUSER() {
        shopPage.cliquerSurAddTobasket();

    }

    @When("je navigue vers la page du panier pour USER")
    public void je_navigue_vers_la_page_du_panierPourUSER() {
        homePage.cliquerSurPanier();
    }

    @Then("je devrais voir un récapitulatif des articles pour USER")
    public void je_devrais_voir_un_récapitulatif_des_articlesPourUSER() {
        panierPage = new PanierPage(driver);
        //On va test Pour le produit Android Quick Start Guide Avec QTE=1 & Total=450
        //Valeur dans l'input
        String inputValeur = panierPage.qteElement.getAttribute("value");
        Assert.assertTrue(inputValeur.contains("1"));
        System.out.println(inputValeur);
        //total commande
        Assert.assertTrue(panierPage.totalElement.getText().contains("450"));

    }

    @When("je modifie la quantité d'un article pour USER")
    public void je_modifie_la_quantité_d_un_articlePourUSER() {
        panierPage.modifierQte();

    }

    @When("je clique sur le bouton de mise à jour pour USER")
    public void je_clique_sur_le_bouton_de_mise_à_jourPourUSER() throws InterruptedException {
        panierPage.cliquerUpdatePanier();
        Thread.sleep(3000);

    }

    @Then("la quantité et le prix de l'article devrait être mise à jour pour USER")
    public void la_quantité_et_le_prix_de_l_article_devrait_être_mise_à_jourPourUSER() {
        //On va test Pour le produit Android Quick Start Guide Avec QTE=2 & Total=900
        //Valeur dans l'input
        String inputValeur = panierPage.qteElement.getAttribute("value");
        Assert.assertTrue(inputValeur.contains("2"));
        System.out.println(inputValeur);
        //total commande
        Assert.assertTrue(panierPage.totalElement.getText().contains("900"));
    }

    @When("je clique sur le bouton Proceed to Checkout pour USER")
    public void jeCliqueSurLeBoutonProceedToCheckoutPourUSER() {
        panierPage.cliquerCheckout();
    }

    @Then("je devrais être redirigé vers la page Checkout pour remplir le formulaire pour USER")
    public void je_devrais_être_redirigé_vers_la_page_checkout_pour_remplir_le_formulairePourUSER() throws InterruptedException {
        Assert.assertTrue((driver.getCurrentUrl().contains("checkout")));
        userInformations = new GuestOrUsertInformation(driver);
        userInformations.RemplirFormulaireInfosUser();
    }

    @Then("je sélectionne l'option de paiement Cash on Delivery pour USER")
    public void je_sélectionne_l_option_de_paiement_cash_on_deliveryPourUSER() {
        userInformations.choisirCOD();
    }

    @Then("je confirme la commande pour USER")
    public void je_confirme_la_commandePourUSER() {
        userInformations.cliquerBtnPlaceOrder();
    }
    @Then("La page détails commande va safficher et je verifie par le numéro de commande et lurl pour USER")
    public void laPageDetailsCommandeVaSafficherEtJeVerifieParLeNumeroDeCommandeEtLurlPourUSER() {
        orderDetailsPage = new OrderDetailsPage(driver);
        String numeroOrder = orderDetailsPage.odrerNumberElement.getText();
        Assert.assertTrue(driver.getCurrentUrl().contains(numeroOrder));
    }




}
