package org.example.tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;
import org.example.pageObject.Constantes;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SongsPOST implements Task {

    private final String body;

    public SongsPOST(String body) {
        this.body = body;
    }

    public static Performable crearSong( String body){
        return instrumented(SongsPOST.class, body);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to(Constantes.RESOURCE_POST).with(
                        requestSpecification -> requestSpecification
                                .contentType(ContentType.JSON)
                                .header("x-rapidapi-host",Constantes.X_RAPIDAPI_HOST)
                                .header("x-rapidapi-key",Constantes.X_RAPIDAPI_KEY)
                                .body(body)

                )
        );
    }
}
