package steps.UpdateDeletePanierSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.*;
import steps.TestBase;

public class UpdateDeletePanierStesp {
    HomePage homePage;
    PanierPage panierPage;
    ShopPage shopPage;
    GuestOrUsertInformation userInformations;
    OrderDetailsPage orderDetailsPage;
    WebDriver driver;

    public UpdateDeletePanierStesp() {
        driver = TestBase.getDriver();
    }

    @Given("que je suis sur le shop pour updateDelete")
    public void que_je_suis_sur_le_shop_pour_update_delete() {
        //Homme page
        homePage = new HomePage(driver);
        homePage.cliquerConsentCockies();
        homePage.cliquerSurShop();
        //page shop
        shopPage = new ShopPage(driver);
        //Verifier product Android Quick Start Guide
        Assert.assertTrue(shopPage.titreProduitElement.getText().contains("Android Quick Start Guide"));
    }
    @Given("que j'ai ajouté des articles à mon panier pour updateDelete")
    public void que_j_ai_ajouté_des_articles_à_mon_panier_pour_update_delete() {
        shopPage.cliquerSurAddTobasket();
    }
    @When("je navigue vers la page du panier pour updateDelete")
    public void je_navigue_vers_la_page_du_panier_pour_update_delete() {
        homePage.cliquerSurPanier();
    }
    @Then("je devrais voir un récapitulatif des articles pour updateDelete")
    public void je_devrais_voir_un_récapitulatif_des_articles_pour_update_delete() {
        panierPage = new PanierPage(driver);
        //On va test Pour le produit Android Quick Start Guide Avec QTE=1 & Total=450
        //Valeur dans l'input
        String inputValeur = panierPage.qteElement.getAttribute("value");
        Assert.assertTrue(inputValeur.contains("1"));
        System.out.println(inputValeur);
        //total commande
        Assert.assertTrue(panierPage.totalElement.getText().contains("450"));
    }
    @When("je modifie la quantité d'un article pour updateDelete")
    public void je_modifie_la_quantité_d_un_article_pour_update_delete() {
        panierPage.modifierQte();
    }
    @When("je clique sur le bouton de mise à jour pour updateDelete")
    public void je_clique_sur_le_bouton_de_mise_à_jour_pour_update_delete() {
        panierPage.cliquerUpdatePanier();
    }
    @Then("la quantité et le prix de l'article devrait être mise à jour pour updateDelete")
    public void la_quantité_et_le_prix_de_l_article_devrait_être_mise_à_jour_pour_update_delete() {
        //On va test Pour le produit Android Quick Start Guide Avec QTE=2 & Total=900
        //Valeur dans l'input
        String inputValeur = panierPage.qteElement.getAttribute("value");
        Assert.assertTrue(inputValeur.contains("2"));
        System.out.println(inputValeur);
        //total commande
        Assert.assertTrue(panierPage.totalElement.getText().contains("900"));
    }
    @When("je clique sur l'icon X remove pour updateDelete")
    public void je_clique_sur_l_icon_x_remove_pour_update_delete() {
        panierPage.removeProduct();
    }
    @Then("le message Your basket is currently empty est afficher  pour updateDelete")
    public void le_message_your_basket_is_currently_empty_est_afficher_pour_update_delete() {
        Assert.assertTrue(panierPage.emptyBasketElement.getText().contains("empty"));
    }

}
