package stepsdefinitions;

import io.cucumber.java.es.Cuando;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.example.pageObject.Constantes;
import org.example.tasks.SongsPOST;

public class StepsPostSongs {
    @Cuando("Daniel consume el metodo POST {string}")
    public void danielConsumeElMetodoPost(String body) {
        Actor qa= Actor.named("qa_Post")
                .whoCan(CallAnApi.at(Constantes.URL_BASE));

        qa.attemptsTo(
                SongsPOST.crearSong(body)
        );

    }

}
