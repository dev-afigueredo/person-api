package com.afigueredo.personApi.mapper;

import com.afigueredo.personApi.dto.request.PersonDto;
import com.afigueredo.personApi.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
    Person toModel(PersonDto personDto);

    PersonDto toDto(Person person);
}
