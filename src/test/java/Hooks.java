import actors.ApiCast;
import io.cucumber.java.Before;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.actors.OnStage;
import net.thucydides.model.util.EnvironmentVariables;

public class Hooks {
    private EnvironmentVariables environmentVariables;
    @Before(order = 0)
    public void settingStage(){
        SerenityRest.enableLoggingOfRequestAndResponseIfValidationFails();
        SerenityRest.useRelaxedHTTPSValidation();
        OnStage.setTheStage(new ApiCast(environmentVariables));
    }
}
