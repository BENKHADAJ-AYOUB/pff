package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PanierPage extends PageBase{
    public PanierPage(WebDriver driver) {
        super(driver);
    }
    //WebElements
    //Qte Eelement
    @FindBy(xpath = "//div[@class=\"quantity\"]/input[@type='number']")
    private WebElement qteElement;
    //total element
    @FindBy(xpath = "//td[@class=\"product-subtotal\"]/span[@class=\"woocommerce-Price-amount amount\"]")
    private WebElement totalElement;

    //subtotal element
    @FindBy(xpath = "//td[@data-title=\"Subtotal\"]/span[@class=\"woocommerce-Price-amount amount\"]")
    private WebElement subTotalElement;
    //Update panier

    @FindBy(xpath = "//td[@class=\"actions\"]/input[@value=\"Update Basket\"]")
    private WebElement updatePanierElement;

    //process Checkout btn
    @FindBy(xpath = "//div[@class=\"wc-proceed-to-checkout\"]/a[contains(text(),'Proceed')]")
    private WebElement btnCheckoutElement;

    //Méthods
    //Cliquer sur update basket
    public void cliquerUpdatePanier()
    {
        Clicking(updatePanierElement);
    }
    //Cliquer sur process checkout
    public void cliquerCheckout()
    {
        Clicking(btnCheckoutElement);
    }

}