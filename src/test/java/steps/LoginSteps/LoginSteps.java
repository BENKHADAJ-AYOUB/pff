package steps.LoginSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.MyAccountPage;
import steps.TestBase;
import org.testng.asserts.SoftAssert;

public class LoginSteps {
    HomePage homePage;
    MyAccountPage myAccountPage;
    static WebDriver driver;
    SoftAssert softAssert;

    public LoginSteps() {
        driver = TestBase.getDriver();
        softAssert = new SoftAssert();
    }

    @Given("que je suis sur la page My Account pour login")
    public void que_je_suis_sur_la_page_my_account_pour_login() {

        homePage = new HomePage(driver);
        homePage.cliquerConsentCockies();
        homePage.cliquerSurMyAccount();
        softAssert.assertTrue(driver.getCurrentUrl().contains("my-account"));
    }

    @When("je saisis mon login et mon mot de passe")
    public void jeSaisisMonLoginEtMonMotDePasse() {
        myAccountPage = new MyAccountPage(driver);
        myAccountPage.remplirFormulaireLogin("doca1@gmail.com", "DocaPoste123@");
    }

    @When("je clique sur le bouton LOGIN")
    public void je_clique_sur_le_bouCheckton_login() {
        myAccountPage.clickerSurBtnLogin();
        softAssert.assertTrue(myAccountPage.signOutElement.getText().contains("out"));

    }

    @Then("le Dashboard doit s'afficher pour login avec signOut")
    public void le_dashboard_doit_s_afficher_pour_login_avec_sign_out() {
        myAccountPage.signOut();
        softAssert.assertTrue(driver.getCurrentUrl().contains("my-account"));
    }



}
