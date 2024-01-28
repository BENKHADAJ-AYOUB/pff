package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MotDePasseOublierPage extends PageBase{
    public MotDePasseOublierPage(WebDriver driver) {
        super(driver);
    }
    //Web Elements

    @FindBy(id = "user_login")
    private WebElement mailElement;
    @FindBy(xpath = "//input[@class='woocommerce-Button button' and @value='Reset Password']")
    public WebElement btnRestMdpElement;

}
