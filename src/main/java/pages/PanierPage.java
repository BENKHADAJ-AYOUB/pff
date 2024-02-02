package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class PanierPage extends PageBase {
    public PanierPage(WebDriver driver) {
        super(driver);
    }

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
        //WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(20));
        //wait.until(ExpectedConditions.visibilityOf(totalElement));
    }

    //Cliquer sur process checkout
    public void cliquerCheckout() {
       // new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"wc-proceed-to-checkout\"]/a[@class='checkout-button button alt wc-forward']")));
        //new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(btnCheckoutElement));

        Clicking(btnCheckoutElement);
    }

    //Modifier la quantité
    public void modifierQte() {
        clearInput(qteElement);
        sendText(qteElement, "2");
    }

}
