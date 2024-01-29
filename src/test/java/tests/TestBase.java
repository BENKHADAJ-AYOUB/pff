package tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utilities.Helper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class TestBase extends AbstractTestNGCucumberTests {
    protected static WebDriver driver;
    public static String downloadPath = System.getProperty("user.dir") + "\\Downloads";

    public static ChromeOptions chromeOption() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications"); // Facultatif : pour désactiver les notifications de site
        options.addArguments("--disable-cookies"); // Bloquer les cookies
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default.content_settings.popups", 0);
        chromePrefs.put("download.default_directory", downloadPath);
        options.setExperimentalOption("prefs", chromePrefs);
        options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        //ad extensio
   /*     options.addArguments("load-extension=C:\\Users\\benkh\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 1\\Extensions\\gighmmpiobklfepjocnamgkkbiglidom\\5.17.2_0");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);*/

        return options;
    }


    @BeforeSuite
    @Parameters({"browser"})
    public void setUp(@Optional("chrome") String browserName) throws InterruptedException { //ça reste optionnel et chrome par défaut
        switch (browserName) {
            case "chrome":
                driver = new ChromeDriver(chromeOption());

                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            case "headless-chrome":
                ChromeOptions option = new ChromeOptions();
                option.addArguments("--headless");
                driver = new ChromeDriver(option);
                break;
        }
        String parentWindow = driver.getWindowHandle();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        driver.get("https://practice.automationtesting.in/");
        // Revenez à la fenêtre parente
        //driver.switchTo().window(parentWindow);

    }


   /* @AfterSuite
    public void stopDriver() {
        driver.quit();
    }*/

    // take screenshot when the test case fail and ad it in the scrennshot folder
    @AfterMethod
    public void screnShotOnfailure(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            System.out.println("FAILURE");
            System.out.println("Take ScrenShots ...");
            Helper.captureScreenshot(driver, result.getName());
        }
    }


}
