package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Person {

    private final UUID id;
    private final String name;

    // To send a post req.("name":"James Bond") from Postman(localhost:8080/api/v1/person) to this server
    // we have to define these properties in our Pocho so that when we send this JSON spring knows to take this
    // property and convert it to java class
    public Person(@JsonProperty("id") UUID id,
                  @JsonProperty("name") String name)
    {
        this.id=id;
        this.name=name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
