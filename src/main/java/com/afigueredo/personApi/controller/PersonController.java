package com.afigueredo.personApi.controller;

import com.afigueredo.personApi.dto.response.MessageResponseDto;
import com.afigueredo.personApi.dto.request.PersonDto;
import com.afigueredo.personApi.exception.PersonNotFoundException;
import com.afigueredo.personApi.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/people")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonController {

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

    @GetMapping("/{id}")
    public PersonDto findById(@PathVariable Long id) throws PersonNotFoundException {
        return personService.findById(id);
    }

    @PutMapping("/{id}")
    public MessageResponseDto updateById(@PathVariable Long id,@RequestBody @Valid PersonDto personDto) throws PersonNotFoundException {
        return personService.updateById(id, personDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws PersonNotFoundException {
        personService.delete(id);
    }

}
