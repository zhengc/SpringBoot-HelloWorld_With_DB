package com.example.helloworld.entity;

import lombok.Data;


/*
The @Data annotation provided by Lombok will generate following methods for you:
    getter
    setter
    toString
    hashCode
    equals
 */
@Data
public class Person {
    private String PersonID;
    private String PersonName;
    private int PersonAge;

    public Person() {

    }

    public Person(String id, String name, int age) {
        this.PersonID = id;
        this.PersonName = name;
        this.PersonAge = age;
    }
}
