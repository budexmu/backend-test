package io.demet.hello.controller;

import io.demet.hello.model.Person;
import io.demet.hello.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("persons")
public class PersonController {

    private PersonService personService;

    @Autowired
    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable("id") Integer id) {
        Person person = personService.getPersonById(id);
        return new ResponseEntity<Person>(person, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Person>> getAllPersons() {
        List<Person> personList = personService.getAllPersons();
        return new ResponseEntity<>(personList, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Void> addPerson(@RequestBody Person person, UriComponentsBuilder builder) {
        boolean flag = personService.addPerson(person);
        if (flag == false) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
/*        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/person/{id}").buildAndExpand(person.getId()).toUri());*/
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable Integer id) {
        personService.deletePerson(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Person> updatePerson(@RequestBody Person person) {
        personService.upsertPerson(person);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }
}




















