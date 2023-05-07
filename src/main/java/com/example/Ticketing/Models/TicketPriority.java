package com.example.Ticketing.Models;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public enum TicketPriority {
    LOW,
    MEDIUM,
    HIGH;

    public static class Serializer extends JsonSerializer<TicketPriority> {
        @Override
        public void serialize(TicketPriority value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeString(value.name().toLowerCase());
        }
    }

    public static class Deserializer extends JsonDeserializer<TicketPriority> {
        @Override
        public TicketPriority deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
            return TicketPriority.valueOf(p.getValueAsString().toUpperCase());
        }
    }
}


