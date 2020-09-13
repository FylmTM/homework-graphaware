package com.graphaware.pizzeria.model;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import javax.persistence.AttributeConverter;
import java.util.ArrayList;
import java.util.List;

public class RoleConverter implements AttributeConverter<List<UserRole>, String> {

    private final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @SneakyThrows
    @Override
    public String convertToDatabaseColumn(List<UserRole> roles) {
        return String.valueOf(OBJECT_MAPPER.writeValueAsString(roles));
    }

    @SneakyThrows
    @Override
    public List<UserRole> convertToEntityAttribute(String rolesString) {
        return OBJECT_MAPPER.readValue(rolesString, new TypeReference<List<UserRole>>() {
        });
    }
}
