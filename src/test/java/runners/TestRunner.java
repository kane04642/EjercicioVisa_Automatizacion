package runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = "pretty",
        tags = "@Regresion",
        features = "src/test/resources/features/pet/",
        glue = "" )
public class TestRunner {
}
