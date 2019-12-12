package com.example.demo.dao;

import com.example.demo.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDAO {

    /*
    Inside of our DAO we're going to define the operations allowed or the actual contract for anyone that wishes
    to implement this interface
     */

    int insertPerson(UUID id, Person person);

    default int insertPerson(Person person) {
        UUID id = UUID.randomUUID(); //User ID# will be randomly generated
        return insertPerson(id, person);
    }

    List<Person> selectAllPeople();

    Optional<Person> selectPersonById(UUID id);

    int deletePersonId(UUID id);

    int updatePersonId(UUID id, Person person);


}
