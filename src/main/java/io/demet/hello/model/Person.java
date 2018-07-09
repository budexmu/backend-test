package io.demet.hello.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String surname;
    private String username;
    private String telNo;


    public Person() {
    }

    public Person(int id, String name, String surname, String username) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.username = username;
    }

}
