package org.example.tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;
import org.example.pageObject.Constantes;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class EmpleadosGET implements Task {

    public static Performable consultarEmpleados(){
        return  instrumented(EmpleadosGET.class);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource(Constantes.RESOURCE).with(
                        requestSpecification -> requestSpecification
                                .contentType(ContentType.JSON)
                )
        );

    }
}
