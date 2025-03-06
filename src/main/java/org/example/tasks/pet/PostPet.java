package org.example.tasks.pet;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.interactions.Post;
import org.example.models.pet.BodyPet;
import org.example.pageObject.Constans;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PostPet implements Task {

    private static final String ACTOR_NAME = "actorCloud";
    private BodyPet bodyPet;

    public PostPet(BodyPet bodyPet){
        this.bodyPet=bodyPet;
    }

    public static Performable createPet(BodyPet bodyPet){
        return instrumented(PostPet.class, bodyPet);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Actor actorCreate = OnStage.theActor(ACTOR_NAME);
        actorCreate.attemptsTo(
                Post.to(Constans.RESOURCE_GET_PET).with(
                        requestSpecification -> requestSpecification
                                .contentType(ContentType.JSON)
                                .body(bodyPet)
                )
        );

    }
}
