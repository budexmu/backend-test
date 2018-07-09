package io.demet.hello.service;

import io.demet.hello.Model.Person;
import io.demet.hello.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Person getPersonById(int id) {
        Person person = personRepository.findById(id).get();
        return person;
    }

    public synchronized boolean addPerson(Person person) {
        List<Person> list = personRepository.findAllByIdAndUsername(person.getId(), person.getUsername());
        if (list.size() > 0) {
            return false;
        } else {
            personRepository.save(person);
            return true;
        }
    }

    public void upsertPerson(Person person) {
        personRepository.save(person);
    }

    public void deletePerson(int id) {
        personRepository.delete(getPersonById(id));
    }

    @Override
    public List<Person> getAllPersons() {
        List<Person> personList = new ArrayList<>();
        personRepository.findAll().forEach(personList::add);
        return personList;
    }


}
