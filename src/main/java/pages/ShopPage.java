package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShopPage extends PageBase {
    public ShopPage(WebDriver driver) {
        super(driver);
    }
    //WebElement

    //on test avec le produit Android Quick Start Guide
    //Nom produit
    @FindBy(xpath = "    //a[@class=\"woocommerce-LoopProduct-link\"]/h3[text()='Android Quick Start Guide']\n")
    public WebElement titreProduitElement;
    //ajouter au pannier element
    @FindBy(xpath = "//a[@data-product_id=169]")
    private WebElement addToBasketElement;

    //Méthodes
    //Add to basket méthode
    public void cliquerSurAddTobasket() {
        Clicking(addToBasketElement);
    }
}
