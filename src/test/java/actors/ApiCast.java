package actors;

import environments.Environments;
import io.restassured.filter.log.RequestLoggingFilter;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Ability;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.model.util.EnvironmentVariables;

import java.util.Arrays;

public class ApiCast extends Cast{
    public final Environments testEnvironments;

    public ApiCast(EnvironmentVariables environmentVariables) {
        this.testEnvironments = new Environments(environmentVariables);
    }
    @Override
    public Actor actorNamed (String actorName, Ability... abilities){
        Actor theActor;
        SerenityRest.filters(Arrays.asList(new RequestLoggingFilter(),new RequestLoggingFilter()));

        switch (actorName){
            case "actorLocal":
                theActor = super.actorNamed(actorName, CallAnApi.at(testEnvironments.getBaseUrlBases()))
                        .describedAs("Actor para obtener base URL del local host");
                break;
            case "actorCloud":
                theActor = super.actorNamed(actorName, CallAnApi.at(testEnvironments.getBaseUrlBases()))
                        .describedAs("Actor para obtener base URL de Cloud");
                break;

            default:
                theActor= super.actorNamed(actorName, CallAnApi.at(testEnvironments.getBaseUrlBases()))
                        .describedAs("Actor por defecto");
                break;
        }
        return theActor;
    }

}
