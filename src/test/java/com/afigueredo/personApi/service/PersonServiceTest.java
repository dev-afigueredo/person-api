package com.afigueredo.personApi.service;

import com.afigueredo.personApi.dto.request.PersonDto;
import com.afigueredo.personApi.dto.response.MessageResponseDto;
import com.afigueredo.personApi.entity.Person;
import com.afigueredo.personApi.repository.PersonRepository;
import com.afigueredo.personApi.utils.PersonUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.afigueredo.personApi.utils.PersonUtils.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonService personService;

    @Test
    void testGivenPersonDtoThenReturnSavedMessage() {
        PersonDto personDto = createFakeDTO();
        Person expectedSavedPerson = createFakeEntity();

        when(personRepository.save(any(Person.class))).thenReturn(expectedSavedPerson);

        MessageResponseDto expectedSuccessMessage = createExpectedMessageResponse(expectedSavedPerson.getId(), "Created person with ID ");
        MessageResponseDto successMessage = personService.createPerson(personDto);

        assertEquals(expectedSuccessMessage, successMessage);
    }

    private MessageResponseDto createExpectedMessageResponse(Long id, String textMessage) {
        return MessageResponseDto
                .builder()
                .message(textMessage + id)
                .build();
    }
}