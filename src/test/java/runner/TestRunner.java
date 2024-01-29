package runner;

import io.cucumber.testng.CucumberOptions;

import tests.TestBase;


@CucumberOptions(
        //tags="@tag2",
        plugin = {"pretty", "html:target/cucumber", "json:target/cucumber.json","junit:target/cucumber.xml"},
        features = "src/test/java/features/Login",
        glue = {"steps/Login"}

)
public class TestRunner extends TestBase {


}
