package runner;

import io.cucumber.java.AfterAll;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;


@CucumberOptions(

        plugin = {"pretty", "html:target/cucumber", "json:target/cucumber.json","junit:target/cucumber.xml"},
        features = "src/test/java/features",
        glue = {"steps"},
        tags = "@tchach"// or @tag3 or @tag4


)
public class TestRunner extends AbstractTestNGCucumberTests {


}
