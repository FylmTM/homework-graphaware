package com.graphaware.pizzeria.model;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import javax.persistence.AttributeConverter;
import java.util.List;

public class ToppingConverter implements AttributeConverter<List<String>, String> {

    private final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @SneakyThrows
    @Override
    public String convertToDatabaseColumn(List<String> toppings) {
        return String.valueOf(OBJECT_MAPPER.writeValueAsString(toppings));
    }

    @SneakyThrows
    @Override
    public List<String> convertToEntityAttribute(String rolesString) {
        return OBJECT_MAPPER.readValue(rolesString, new TypeReference<List<String>>() {
        });
    }
}
