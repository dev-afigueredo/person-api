package com.afigueredo.personApi.service;

import com.afigueredo.personApi.dto.request.PersonDto;
import com.afigueredo.personApi.dto.response.MessageResponseDto;
import com.afigueredo.personApi.entity.Person;
import com.afigueredo.personApi.mapper.PersonMapper;
import com.afigueredo.personApi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    private static final PersonMapper personMapper = PersonMapper.INSTANCE;

    public MessageResponseDto createPerson(PersonDto personDto) {
        Person savedPerson = savePerson(personMapper.toModel(personDto));
        return MessageResponseDto
                .builder()
                .message("Created person with ID " + savedPerson.getId())
                .build();
    }

    public Person savePerson(Person person) {
        return personRepository.save(person);
    }
}
