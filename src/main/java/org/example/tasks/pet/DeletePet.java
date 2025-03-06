package org.example.tasks.pet;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.interactions.Delete;
import org.example.pageObject.Constans;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class DeletePet implements Task {
    private static final String ACTOR_NAME = "actorCloud";
    private String IdPet;

    public DeletePet(String IdPet) {
        this.IdPet = IdPet;
    }

    public static DeletePet deletePet(String IdPet){
        return  instrumented(DeletePet.class, IdPet);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Actor actorDelete = OnStage.theActor(ACTOR_NAME);
        actorDelete.attemptsTo(
                Delete.from(Constans.RESOURCE_GET_PET+ "/"+IdPet).with(
                        requestSpecification -> requestSpecification
                                .contentType(ContentType.JSON)

                )
        );
        OnStage.theActor(actor.getName()).entersTheScene();

    }
}
