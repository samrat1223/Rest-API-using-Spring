package com.example.demo.dao;

import com.example.demo.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDao {

    //This method used to add a user with id to database
    int insertPerson(UUID id , Person person);

    //This method used to add a user without id to database and generates a random id
    default int insertPerson(Person person){
        UUID id =   UUID.randomUUID();
        return insertPerson(id,person);
    }

    List<Person> selectAllPeople();

    Optional<Person> selectPersonById(UUID id);

    int deletePersonById(UUID id);

    int updatePersonById(UUID id , Person person);
}
