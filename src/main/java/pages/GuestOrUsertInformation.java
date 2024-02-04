package pages;

import org.openqa.selenium.*;
import com.github.javafaker.Faker;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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
    String zip = "95130";
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
    public WebElement placeOrderBtnElement;
    //checkbox create account

    @FindBy(id = "createaccount")
    private WebElement createaccountElement;

    //checkbox create account
    @FindBy(id = "account_password")
    private WebElement account_passwordElement;
    FluentWait<WebDriver> wait = new FluentWait<>(driver)
            .withTimeout(Duration.ofSeconds(30)) // Définit le temps maximum d'attente
            .pollingEvery(Duration.ofSeconds(1)) // Définit la fréquence de vérification de la condition
            .ignoring(NoSuchElementException.class); // Ignore cette exception pendant l'attente

    //Méthodes
    public void selectCountry(String countryName){
        // Cliquez sur le menu déroulant Select2 pour l'ouvrir
        Clicking(dropdownOpenerCountryElment);
        // Attendez que le champ de recherche soit visible et saisissez le nom du pays
        //new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(searchAtDropdown));
        wait.until(ExpectedConditions.visibilityOf(searchAtDropdown));

        sendText(searchAtDropdown, countryName);
        //Entrer Clavier
        searchAtDropdown.sendKeys(Keys.RETURN);
    }

    //Choisir Cash on delivry
    public void choisirCOD() {
        //new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfElementLocated(By.id("payment_method_cod")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("payment_method_cod")));

        Clicking(radioCODElement);
    }

    //cliquer btn place order
    public void cliquerBtnPlaceOrder() {
        //new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfElementLocated(By.id("place_order")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("place_order")));

        Clicking(placeOrderBtnElement);
    }

    //Cliquer sur checkbox create account
    public void clickCreateAccount()
    {

    }

    //Rmplir le formulaire guest
    public void RemplirFormulaireInfosGuest()  {
        sendText(fisteNameElement, firsteName);
        sendText(lastNameElement, lasteName);
        sendText(mailElement, mail);
        sendText(phoneElement, "0783353619");
        selectCountry("France");
        sendText(adressElement, adress);
        sendText(codePostaleElement, zip);
        sendText(cityElement, city);
    }
    //Rmplir le formulaire User
    public void RemplirFormulaireInfosUser() {
        sendText(fisteNameElement, firsteName);
        sendText(lastNameElement, lasteName);
        sendText(mailElement, mail);
        sendText(phoneElement, "0783353619");
        selectCountry("France");
        sendText(adressElement, adress);
        sendText(codePostaleElement, zip);
        sendText(cityElement, city);
        Clicking(createaccountElement);
        //new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(By.id("account_password")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("account_password")));
        sendText(account_passwordElement,"GlwanShop123");
    }

}
