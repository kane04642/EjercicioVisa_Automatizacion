package stepsdefinitions;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.apache.http.HttpStatus;
import org.example.pageObject.Constantes;
import org.example.questions.StatusGET;
import org.example.tasks.EmpleadosGET;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class StepsEmpleados {

    @Dado("Daniel es un usuario con los permisos para consultar los recursos")
    public void daniel_es_un_usuario_con_los_permisos_para_consultar_los_recursos() {

    }

    @Cuando("Daniel consume el metodo GET")
    public void daniel_consume_el_metodo_get() {
        Actor qa= Actor.named("qa")
                .whoCan(CallAnApi.at(Constantes.URL_BASE));

        qa.attemptsTo(
                EmpleadosGET.consultarEmpleados()
        );
    }

    @Entonces("Daniel visualiza respuesta exitosa")
    public void daniel_visualiza_respuesta_exitosa() {
        Actor qa= Actor.named("qa");
        qa.should(
                seeThat(new StatusGET(), equalTo(HttpStatus.SC_OK))
        );
    }


}
