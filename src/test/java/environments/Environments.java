package environments;

import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.thucydides.model.util.EnvironmentVariables;

public class Environments {

    private final EnvironmentVariables environmentVariables;

    public Environments(EnvironmentVariables environmentVariables) {
        this.environmentVariables = environmentVariables;
    }

    public String getBaseUrlBases(){
        return EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("rest.api.base.url");
    }
}
