package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBase {
    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    //Web Elements
    //Login
    @FindBy(id = "username")
    private WebElement mailLoginElement;
    @FindBy(id = "password")
    private WebElement passwordLoginElement;
    @FindBy(xpath = "//input[@type='submit' and @name='login']")
    public WebElement btnLoginElement;
    @FindBy(id = "rememberme")
    private WebElement remembermeElement;

    //Register
    @FindBy(id = "reg_email")
    private WebElement mailRegisterElement;
    //private By passwordLogin = By.xpath("//input[@class='password']");
    @FindBy(id = "reg_password")
    private WebElement passwordRegisterElement;
    @FindBy(xpath = "//input[@type='submit' and @name='register']")
    public WebElement btnRegisterElement;


    @FindBy(xpath = "//p[@class='woocommerce-LostPassword lost_password']/a[contains(text(),'Lost your password')]")
    public WebElement mdpOublierElement;
    @FindBy(xpath = "//div[@class='woocommerce-MyAccount-content'] //a[contains(text(),'out')]")
    public WebElement signOutElement;
    //Méthodes
    //Login
    public void seConnecterCompte(String mail, String pswd) {
        sendText(mailLoginElement, mail);
        sendText(passwordLoginElement, pswd);
        Clicking(remembermeElement);
        Clicking(btnLoginElement);
    }

    //Register
    public void creerUnCompte(String mail, String pswd) {
        sendText(mailRegisterElement, mail);
        sendText(passwordRegisterElement, pswd);
        Clicking(btnRegisterElement);
    }
    //Mdp oublier
    public void clickMdpOublier()
    {
        Clicking(mdpOublierElement);
    }
    //signOut
    public void signOut()
    {
        Clicking(signOutElement);
    }


}
