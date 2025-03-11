package org.example.questions;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.rest.questions.LastResponse;
import net.serenitybdd.screenplay.Actor;
import org.example.models.pet.BodyPet;
import org.example.util.JsonUtils;

import java.io.IOException;

public class ValidatePetData implements Question<Boolean> {

    private final String id;
    private final String name;
    private final String nameCategory;
    private final String status;

    public ValidatePetData(String id, String name, String nameCategory, String status) {
        this.id = id;
        this.name = name;
        this.nameCategory = nameCategory;
        this.status = status;
    }

    public static ValidatePetData with(String id, String name, String nameCategory, String status) {
        return new ValidatePetData(id, name, nameCategory, status);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        // Obtener la respuesta JSON
        String jsonResponse = actor.asksFor(LastResponse.received()).body().asString();

        // Deserializar el JSON a un objeto BodyPet
        BodyPet bodyPet = null;
        try {
            bodyPet = JsonUtils.deserializeJsonToBodyPet(jsonResponse);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return bodyPet.getId() == Integer.parseInt(id)
                && bodyPet.getName().equals(name)
                && bodyPet.getStatus().equals(status)
                && bodyPet.getCategory().getName().equals(nameCategory);
    }
}