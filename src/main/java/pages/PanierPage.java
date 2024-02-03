package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class PanierPage extends PageBase {
    public PanierPage(WebDriver driver) {
        super(driver);
        //this.driver = driver;
    }
   // WebDriver driver;
    //WebElements
    //Qte Eelement
    @FindBy(xpath = "//div[@class=\"quantity\"]/input[@type='number']")
    public WebElement qteElement;
    //total element
    @FindBy(xpath = "//td[@class=\"product-subtotal\"]/span[@class=\"woocommerce-Price-amount amount\"]")
    public WebElement totalElement;

    //subtotal element
    @FindBy(xpath = "//td[@data-title=\"Subtotal\"]/span[@class=\"woocommerce-Price-amount amount\"]")
    private WebElement subTotalElement;
    //button Update panier

    @FindBy(xpath = "//td[@class=\"actions\"]/input[@value=\"Update Basket\"]")
    private WebElement updatePanierElement;

    //process Checkout btn
    @FindBy(xpath = "//div[@class=\"wc-proceed-to-checkout\"]/a[@class='checkout-button button alt wc-forward']")
    public WebElement btnCheckoutElement;

    //Méthods
    //Cliquer sur update basket
    public void cliquerUpdatePanier() {
        Clicking(updatePanierElement);
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.textToBePresentInElement(totalElement,"₹900.00"));
    }

    //Cliquer sur process checkout
    public void cliquerCheckout() {
        Clicking(btnCheckoutElement);
    }

    //Modifier la quantité
    public void modifierQte() {
        clearInput(qteElement);
        sendText(qteElement, "2");
    }

}
