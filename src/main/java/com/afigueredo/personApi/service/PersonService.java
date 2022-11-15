package com.afigueredo.personApi.service;

import com.afigueredo.personApi.dto.MessageResponseDto;
import com.afigueredo.personApi.entity.Person;
import com.afigueredo.personApi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    public MessageResponseDto createPerson(Person person) {
        Person savedPerson = savePerson(person);
        return MessageResponseDto
                .builder()
                .message("Created person with ID " + savedPerson.getId())
                .build();
    }

    public Person savePerson(Person person) {
        return personRepository.save(person);
    }
}
