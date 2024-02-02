package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(

        plugin = {"pretty", "html:target/cucumber", "json:target/cucumber.json","junit:target/cucumber.xml"},
        features = "src/test/java/features",
        glue = {"steps"},
        tags = "@tag1 or @tag3 or @tag4"


)
public class TestRunner extends AbstractTestNGCucumberTests {


}
