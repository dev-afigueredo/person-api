package com.afigueredo.personApi.controller;

import com.afigueredo.personApi.dto.response.MessageResponseDto;
import com.afigueredo.personApi.dto.request.PersonDto;
import com.afigueredo.personApi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDto createPerson(@RequestBody @Valid PersonDto personDto) {
        return personService.createPerson(personDto);
    }

    @GetMapping
    public List<PersonDto> listAll() {
        return personService.listAll();
    }

}
