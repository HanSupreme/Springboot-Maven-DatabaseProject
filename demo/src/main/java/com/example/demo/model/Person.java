package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class Person {

    /*
    We're going to create a UUID - Universally Unique Identifier.

    What is a UUID?

    UUIDs are used as IDs (to identify) unique objects or records.
    An easy way to generate UUIDs in Java is to use the java.util.UUID class.
    Different variants and variant-versions exist for UUID objects.
     */

    private final UUID id;

    @NotBlank
    private final String name;

    public Person(@JsonProperty("id") UUID id,
                  @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
