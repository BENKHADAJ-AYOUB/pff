package steps;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;

import org.testng.ITestResult;
import org.testng.annotations.*;
import utilities.Helper;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class TestBase {
     static WebDriver driver;
    //Pour telecharger des fichier par exemple Order pdf
    public static String downloadPath = System.getProperty("user.dir") + "\\Downloads";

    public static ChromeOptions chromeOption() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications"); // Facultatif : pour désactiver les notifications de site
        options.addArguments("--disable-cookies"); // Bloquer les cookies
        options.addArguments("--disable-popup-blocking"); // Désactiver le blocage des pop-ups
        options.addArguments("--disable-save-password-bubble"); // Désactiver le pop-up de sauvegarde de mot de passe
        options.addArguments("--disable-notifications"); // Désactiver les notifications
        options.addArguments("--disable-extensions"); // Désactiver les extensions
        options.addArguments("--disable-geolocation"); // Désactiver la géolocalisation
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
    public static WebDriver getDriver() {
        return driver;
    }
    //set up s
    @Before
    public void setUp(Scenario scenario)  { //ça reste optionnel et chrome par défaut

        String browserName = "chrome"; // Valeur par défaut
        if (scenario.getSourceTagNames().contains("@Firefox")) {
            browserName = "firefox";
        } else if (scenario.getSourceTagNames().contains("@Chrome")) {
            browserName = "chrome";
        }
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
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
       driver.get("https://practice.automationtesting.in/");


    }

    //quiteer le driver
    @After
    public void stopDriver() {
        driver.quit();



    }

    // take screenshot when the test case fail and ad it in the scrennshot folder
    @AfterStep
    public void screnShotOnfailure(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            System.out.println("FAILURE");
            System.out.println("Take ScrenShots ...");
            Helper.captureScreenshot(driver, scenario.getName());
        }
    }


}
