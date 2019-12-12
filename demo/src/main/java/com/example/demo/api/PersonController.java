package com.example.demo.api;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public void addPerson(@Valid @NonNull @RequestBody Person person) { //our Post request
        personService.addPerson(person);

        //We want to take the Request Body and shovel it in to Person person
    }

    @GetMapping
    public List<Person> getAllPeople() {
        return personService.getAllPeople();

        //This method will be served as a Get request
    }

    @GetMapping(path = "{id}")
    public Person getPersonById(@PathVariable("id") UUID id) {
        return personService.getPersonById(id)
                .orElse(null);

        //Can return back custom message such as "Person not found" but for now will leave as null
    }

    @DeleteMapping(path = "({id})")
    public void deletePersonById(@PathVariable("id") UUID id) {
        personService.deletePerson(id);
    }

    @PutMapping(path = "({id})")
    public void updatePerson(@PathVariable("id") UUID id, @Valid @NonNull @RequestBody Person personUpdate) {
        personService.updatePerson(id, personUpdate);
    }
}
