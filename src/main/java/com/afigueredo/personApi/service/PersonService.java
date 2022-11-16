package com.afigueredo.personApi.service;

import com.afigueredo.personApi.dto.request.PersonDto;
import com.afigueredo.personApi.dto.response.MessageResponseDto;
import com.afigueredo.personApi.entity.Person;
import com.afigueredo.personApi.exception.PersonNotFoundException;
import com.afigueredo.personApi.mapper.PersonMapper;
import com.afigueredo.personApi.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService {

    PersonRepository personRepository;

    private static final PersonMapper personMapper = PersonMapper.INSTANCE;

    public MessageResponseDto createPerson(PersonDto personDto) {
        Person personToSave = personMapper.toModel(personDto);

        Person savedPerson = personRepository.save(personToSave);
        return createMessageResponse(savedPerson.getId(), "Created person with ID ");
    }

    public List<PersonDto> listAll() {
        List<Person> allPeople = personRepository.findAll();
        return allPeople.stream()
                .map(personMapper::toDto)
                .collect(Collectors.toList());
    }

    public PersonDto findById(Long id) throws PersonNotFoundException {
        Person person = verifyIfExists(id);

        return personMapper.toDto(person);
    }

    public void delete(Long id) throws PersonNotFoundException {
        verifyIfExists(id);

        personRepository.deleteById(id);
    }

    public MessageResponseDto updateById(Long id, PersonDto personDto) throws PersonNotFoundException {
        verifyIfExists(id);
        Person personToUpdate = personMapper.toModel(personDto);

        Person updatedPerson = personRepository.save(personToUpdate);
        return createMessageResponse(updatedPerson.getId(), "Updated person with ID ");
    }

    private Person verifyIfExists(Long id) throws PersonNotFoundException {
        return personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
    }

    private MessageResponseDto createMessageResponse(Long id, String s) {
        return MessageResponseDto
                .builder()
                .message(s + id)
                .build();
    }
}
