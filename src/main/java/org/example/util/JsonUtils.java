package org.example.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.models.pet.BodyPet;

import java.io.IOException;

public class JsonUtils {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static BodyPet deserializeJsonToBodyPet(String jsonResponse) throws IOException {
        return objectMapper.readValue(jsonResponse, BodyPet.class);
    }
}