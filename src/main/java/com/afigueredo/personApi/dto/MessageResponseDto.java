package com.afigueredo.personApi.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MessageResponseDto {

    private String message;

}
