package stepsdefinitions.pet;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import org.apache.http.HttpStatus;
import org.example.questions.StatusResponse;
import org.example.tasks.pet.GetPet;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class StepsGetPets {

    @Dado("Daniel es un usuario con los permisos para consultar los recursos")
    public void danielEsUnUsuarioConLosPermisosParaConsultarLosRecursos() {

    }

    @Cuando("Daniel consulta la mascota por ID {string}")
    public void danielConsultaLaMascotaPorId(String IdPet) {
        OnStage.theActorCalled("actorCloud").describedAs(("Daniel puede consultar"));
        OnStage.theActorInTheSpotlight().attemptsTo(
                GetPet.getPet(IdPet)
        );
    }

    @Entonces("Daniel visualiza respuesta exitosa")
    public void danielVisualizaRespuestaExitosa() {
        OnStage.theActorCalled("actorCloud").describedAs(("Daniel puede consultar"));
        OnStage.theActorInTheSpotlight().should(
                seeThat(new StatusResponse(), equalTo(HttpStatus.SC_OK))
        );


    }


    @Entonces("Daniel visualiza respuesta no encontrado")
    public void danielVisualizaRespuestaNoEncontrado() {
        OnStage.theActorCalled("actorCloud").describedAs(("Daniel puede consultar"));
        OnStage.theActorInTheSpotlight().should(
                seeThat(new StatusResponse(), equalTo(HttpStatus.SC_NOT_FOUND))
        );
    }
}
