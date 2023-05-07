package com.example.Ticketing.Models;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public enum Status {
    OPEN,
    IN_PROGRESS,
    RESOLVED,
    CLOSED;

    public static class Serializer extends JsonSerializer<Status> {
        @Override
        public void serialize(Status value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeString(value.name().toLowerCase());
        }
    }

    public static class Deserializer extends JsonDeserializer<Status> {
        @Override
        public Status deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
            return Status.valueOf(p.getValueAsString().toUpperCase());
        }
    }
}
