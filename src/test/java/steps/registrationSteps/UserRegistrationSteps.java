package steps.registrationSteps;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.HomePage;
import pages.MyAccountPage;
import steps.TestBase;

public class UserRegistrationSteps {
    HomePage homePage;
    MyAccountPage myAccountPage;
    Faker fake = new Faker();
    String mail = fake.internet().emailAddress();
    String pswd = "TestDoca123@";
    WebDriver driver;

    public UserRegistrationSteps() {
        driver = TestBase.getDriver();
    }

    @Given("que je suis sur la page My Account")
    public void que_je_suis_sur_la_page_my_account() {

        homePage = new HomePage(driver);
        homePage.cliquerConsentCockies();
        myAccountPage = new MyAccountPage(driver);
        homePage.cliquerSurMyAccount();
        Assert.assertTrue(driver.getCurrentUrl().contains("my-account"));
    }

    @When("je remplis le formulaire de création de compte")
    public void je_remplis_le_formulaire_de_création_de_compte() {

        myAccountPage.remplirFormulaireRegister(mail, pswd);
    }

    @When("je clique sur le bouton REGISTER")
    public void je_clique_sur_le_bouton_register() {
        myAccountPage.clickerSurBtnRegister();
        Assert.assertTrue(myAccountPage.signOutElement.getText().contains("out"));
    }

    @Then("le dashboard compte client est afficher avec signOut")
    public void le_dashboard_compte_client_est_afficher_avec_sign_out() {
        myAccountPage.signOut();
        Assert.assertTrue(driver.getCurrentUrl().contains("my-account"));
    }

}
