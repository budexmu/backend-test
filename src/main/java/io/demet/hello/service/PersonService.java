package io.demet.hello.service;

import io.demet.hello.Model.Person;

import java.util.List;

public interface PersonService {
    List<Person> getAllPersons();

    boolean addPerson(Person person);

    void upsertPerson(Person person);

    void deletePerson(int id);

    Person getPersonById(int id);
}
