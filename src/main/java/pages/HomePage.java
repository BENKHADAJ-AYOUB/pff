package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    //Web Elements
    //logo
    @FindBy(xpath = "//a[@title='Automation Practice Site']")
    public WebElement logoElement;
    //cockies
    @FindBy(xpath = "//button[@aria-label='Do not consent']")
    private WebElement consentCockieElement;
    //myaccount
    @FindBy(xpath = "//ul[@id=\"main-nav\"]/li[2]/a[text()=\"My Account\"]")
    private WebElement myAccountElement;
    //Shop element Nav
    @FindBy(xpath = "//li[@id='menu-item-40']/a[text()='Shop']")
    private WebElement shopElement;

    //Panier element
    @FindBy(xpath = "//li[@id='wpmenucartli']/a[@class='wpmenucart-contents' and @title='View your shopping cart']")
    private WebElement panierElement;


    //Méthodes
    //Cliquer sur Myaccount
    public void cliquerSurMyAccount() {
        Clicking(myAccountElement);
    }

    //Cliquer sur shop
    public void cliquerSurShop() {
        Clicking(shopElement);
    }

    //Cliquer sur panier
    public void cliquerSurPanier() {
        Clicking(panierElement);
    }

    //Concent Cockeis
    public void cliquerConsentCockies() {
        Clicking(consentCockieElement);
    }


}
