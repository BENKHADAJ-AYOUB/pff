package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase{
    public HomePage(WebDriver driver) {
        super(driver);
    }
    //Web Elements
    @FindBy(xpath = "//a[@title='Automation Practice Site']")
    public WebElement logoElement;
    @FindBy(xpath = "//p[@class='fc-button-label' and text()='Consent']")
    private WebElement consentCockieElement;
    @FindBy(xpath = "//ul[@id=\"main-nav\"]/li[2]/a[text()=\"My Account\"]")
    private WebElement myAccountElement;





    //Méthodes
    //Cliquer sur Myaccount
    public void cliquerSurMyAccount()
    {
        Clicking(consentCockieElement);
        Clicking(myAccountElement);
    }


}
