package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GuestOrUsertInformation extends PageBase {
    public GuestOrUsertInformation(WebDriver driver) {
        super(driver);
    }

    //9a permet d'avoir des valeurs pour chaque element
    Faker fake = new Faker();
    String firsteName = fake.name().firstName();
    String lasteName = fake.name().lastName();
    String mail = fake.internet().emailAddress();
    String adress = fake.address().streetAddress();
    String zip = fake.address().zipCode();
    String city = fake.address().city();

    //WebElmenets
    //Firste Name
    @FindBy(id = "billing_first_name")
    private WebElement fisteNameElement;
    //Laste name
    @FindBy(id = "billing_last_name")
    private WebElement lastNameElement;
    //Mail

    @FindBy(id = "billing_email")
    private WebElement mailElement;
    //Phone number
    @FindBy(id = "billing_phone")
    private WebElement phoneElement;
    //Adress
    @FindBy(id = "billing_address_1")
    private WebElement adressElement;
    //Code postale
    @FindBy(id = "billing_postcode")
    private WebElement codePostaleElement;
    //City
    @FindBy(id = "billing_city")
    private WebElement cityElement;
    //Nom produit
    @FindBy(xpath = "//td[@class='product-name']")
    private WebElement nameProductElement;
    //total
    @FindBy(xpath = "//td[@class='product-total']/span[@class='woocommerce-Price-amount amount']")
    private WebElement totalElement;
    //Country
    @FindBy(id = "s2id_billing_country")
    private WebElement dropdownOpenerCountryElment;

    //recherche à l'interieur du dropdown
    @FindBy(xpath = "//input[@id='s2id_autogen1_search']")

    private WebElement searchAtDropdown;

    //Cash on delivry element
    @FindBy(id = "payment_method_cod")
    private WebElement radioCODElement;
    //Place order Element
    @FindBy(id = "place_order")
    private WebElement placeOrderBtnElement;
    //checkbox create account

    @FindBy(id = "createaccount")
    private WebElement createaccountElement;

    //checkbox create account
    @FindBy(id = "account_password")
    private WebElement account_passwordElement;


    //Méthodes
    public void selectCountry(String countryName) throws InterruptedException {
        // Cliquez sur le menu déroulant Select2 pour l'ouvrir
        Clicking(dropdownOpenerCountryElment);
        // Attendez que le champ de recherche soit visible et saisissez le nom du pays
        Thread.sleep(3000);
        sendText(searchAtDropdown, countryName);
        //Entrer Clavier
        searchAtDropdown.sendKeys(Keys.RETURN);
    }

    //Choisir Cash on delivry
    public void choisirCOD() {
        Clicking(radioCODElement);
    }

    //cliquer btn place order
    public void cliquerBtnPlaceOrder() {
        Clicking(placeOrderBtnElement);
    }

    //Cliquer sur checkbox create account
    public void clickCreateAccount()
    {

    }

    //Rmplir le formulaire guest
    public void RemplirFormulaireInfosGuest() throws InterruptedException {
        sendText(fisteNameElement, firsteName);
        sendText(lastNameElement, lasteName);
        sendText(mailElement, mail);
        sendText(phoneElement, "0783353619");
        selectCountry("France");
        sendText(adressElement, adress);
        sendText(codePostaleElement, zip);
        sendText(cityElement, city);
        //Thread.sleep(3000);
    }
    //Rmplir le formulaire User
    public void RemplirFormulaireInfosUser() throws InterruptedException {
        sendText(fisteNameElement, firsteName);
        sendText(lastNameElement, lasteName);
        sendText(mailElement, mail);
        sendText(phoneElement, "0783353619");
        selectCountry("France");
        sendText(adressElement, adress);
        sendText(codePostaleElement, zip);
        sendText(cityElement, city);
        Clicking(createaccountElement);
        Thread.sleep(3000);
        sendText(account_passwordElement,"GlwanShop123");
    }

}
