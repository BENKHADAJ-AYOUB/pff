package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        //tags="@tag1",
        plugin = {"pretty", "html:target/cucumber", "json:target/cucumber.json","junit:target/cucumber.xml"},
        features = "src/test/java/features",
        glue = {"steps"}

)
public class TestRunner extends AbstractTestNGCucumberTests {


}
