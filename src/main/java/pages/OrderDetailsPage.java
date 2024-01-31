package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderDetailsPage extends PageBase {
    public OrderDetailsPage(WebDriver driver) {
        super(driver);
    }

    //Web Elements
    //Order number
    @FindBy(xpath = "//li[@class='order']/strong")
    public WebElement odrerNumberElement;


}
