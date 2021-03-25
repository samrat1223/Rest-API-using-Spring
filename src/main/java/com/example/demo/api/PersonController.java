package com.example.demo.api;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


//Making this class RestController to handle PUT, POST,DELETE methods
@RequestMapping("api/v1/person")
@RestController
public class PersonController {

    private final PersonService personService;

    //SpringBoot injects actual service to this constructor
    @Autowired
    public PersonController(PersonService personService){
        this.personService = personService ;
    }

    //Making this POST method
    //We are taking the req. body and shovel that inside this Person
    @PostMapping
    public void addPerson(@RequestBody Person person){
        personService.addPerson(person);
    }

    //This method acts as a get request
    @GetMapping
    public List<Person> getAllPeople(){
        return  personService.getAllPeople();
    }

    //GET method to get back the user
    @GetMapping(path="{id}")
    public Person getPersonById(@PathVariable("id") UUID id){
        return personService.getPersonById(id)
                .orElse(null);
    }

    @DeleteMapping(path="{id}")
    public void deletePersonById(@PathVariable("id") UUID id){
        personService.deletePerson(id);
    }

    @PutMapping(path="{id}")
    public  void updatePerson(@PathVariable("id") UUID id ,@RequestBody Person personToUpdate){
        personService.updatePerson(id,personToUpdate);
    }
}
