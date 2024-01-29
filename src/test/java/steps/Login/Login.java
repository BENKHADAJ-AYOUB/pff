package steps.Login;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.HomePage;
import pages.MyAccountPage;
import tests.TestBase;

public class Login extends TestBase {
    HomePage homePage;
    MyAccountPage myAccountPage;
    @Given("que je suis sur la page My Account pour login")
    public void que_je_suis_sur_la_page_my_account_pour_login() {
        homePage = new HomePage(driver);
        homePage.cliquerConsentCockies();
        homePage.cliquerSurMyAccount();
        Assert.assertTrue(driver.getCurrentUrl().contains("my-account"));
    }
    @When("je saisis mon login et mon mot de passe")
    public void jeSaisisMonLoginEtMonMotDePasse() {
        myAccountPage=new MyAccountPage(driver);
        myAccountPage.remplirFormulaireLogin("doca@gmail.com", "DocaPoste123@");
    }

    @When("je clique sur le bouton LOGIN")
    public void je_clique_sur_le_bouton_login() {
        myAccountPage.clickerSurBtnLogin();

    }
    @Then("le Dashboard doit s'afficher pour login avec signOut")
    public void le_dashboard_doit_s_afficher_pour_login_avec_sign_out() {
        Assert.assertTrue(myAccountPage.signOutElement.getText().contains("out"));
        myAccountPage.signOut();
        Assert.assertTrue(driver.getCurrentUrl().contains("my-account"));
    }


}
