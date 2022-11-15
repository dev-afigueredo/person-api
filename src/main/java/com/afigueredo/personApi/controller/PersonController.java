package com.afigueredo.personApi.controller;

import com.afigueredo.personApi.dto.MessageResponseDto;
import com.afigueredo.personApi.entity.Person;
import com.afigueredo.personApi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDto createPerson(@RequestBody Person person) {
        return personService.createPerson(person);
    }

}
