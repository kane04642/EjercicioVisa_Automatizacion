package runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = "pretty",
        tags = "@Consultar_empleados",
        features = "src/test/resources/features/Empleados.feature",
        glue = "" )
public class TestRunner {
}
