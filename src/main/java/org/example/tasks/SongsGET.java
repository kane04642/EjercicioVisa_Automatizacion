package org.example.tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;
import org.example.pageObject.Constantes;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SongsGET implements Task {

    private final String id;
    private final String l;

    public SongsGET(String id, String l) {
        this.id = id;
        this.l = l;
    }


    public static Performable consultarSong(String id, String l){
        return  instrumented(SongsGET.class, id,l);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource(Constantes.RESOURCE).with(
                        requestSpecification -> requestSpecification
                                .contentType(ContentType.JSON)
                                .header("x-rapidapi-host",Constantes.X_RAPIDAPI_HOST)
                                .header("x-rapidapi-key",Constantes.X_RAPIDAPI_KEY)
                                .queryParam("id", id)
                                .queryParam("l",l)
                )
        );

    }
}
