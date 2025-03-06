package org.example.tasks.pet;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.interactions.Get;
import org.example.pageObject.Constans;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GetPet implements Task {

    private static final String ACTOR_NAME = "actorCloud";
    private String IdPet;

    public GetPet(String IdPet){
        this.IdPet = IdPet;
    }

    public static GetPet getPet(String IdPet){
        return  instrumented(GetPet.class, IdPet);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Actor actorConsultar = OnStage.theActor(ACTOR_NAME);
        actorConsultar.attemptsTo(
                Get.resource(Constans.RESOURCE_GET_PET+ "/"+IdPet).with(
                        requestSpecification -> requestSpecification
                                .contentType(ContentType.JSON)

                )
        );
        OnStage.theActor(actor.getName()).entersTheScene();

    }
}
