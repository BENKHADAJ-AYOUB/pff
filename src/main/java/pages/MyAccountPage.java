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
    //mail
    @FindBy(id = "username")
    private WebElement mailLoginElement;
    //password
    @FindBy(id = "password")
    private WebElement passwordLoginElement;
    //button connexion
    @FindBy(xpath = "//input[@type='submit' and @name='login']")
    public WebElement btnLoginElement;
    //Remember me
    @FindBy(id = "rememberme")
    private WebElement remembermeElement;

    //Register
    //mail register
    @FindBy(id = "reg_email")
    private WebElement mailRegisterElement;
    //password register
    @FindBy(id = "reg_password")
    private WebElement passwordRegisterElement;
    //Button register
    @FindBy(xpath = "//input[@type='submit' and @name='register']")
    public WebElement btnRegisterElement;
    //sign out
    @FindBy(xpath = "//div[@class='woocommerce-MyAccount-content'] //a[contains(text(),'out')]")
    public WebElement signOutElement;

    //Méthodes
    //Login
    public void remplirFormulaireLogin(String mail, String pswd) {
        sendText(mailLoginElement, mail);
        sendText(passwordLoginElement, pswd);
        Clicking(remembermeElement);
    }

    //Click btn login
    public void clickerSurBtnLogin() {
        Clicking(btnLoginElement);
    }

    //Register
    //rempli formulaire register
    public void remplirFormulaireRegister(String mail, String pswd) {
        sendText(mailRegisterElement, mail);
        sendText(passwordRegisterElement, pswd);

    }

    //Click btn register
    public void clickerSurBtnRegister() {
        Clicking(btnRegisterElement);
    }


    //signOut
    public void signOut() {
        Clicking(signOutElement);
    }


}
