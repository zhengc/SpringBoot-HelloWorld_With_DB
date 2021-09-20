package com.example.helloworld.service;

import com.example.helloworld.entity.Person;
import com.example.helloworld.repository.HelloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class HelloService {

    @Autowired
    private HelloRepository repository;

    public Person getPerson(String id) {
        Map<String, Object> personInfo = repository.findPerson(id);
        if (personInfo == null) {
            return new Person("0", "nobody", -1);
        }
        String personID = (String) personInfo.get("id");
        String personName = (String) personInfo.get("name");
        int personAge = (Integer) personInfo.get("age");

        Person p1 = new Person();
        p1.setPersonID(personID);
        p1.setPersonName(personName);
        p1.setPersonAge(personAge);
        return p1;
    }
}
