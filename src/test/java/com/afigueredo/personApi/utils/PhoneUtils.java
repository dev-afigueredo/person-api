package com.afigueredo.personApi.utils;

import com.afigueredo.personApi.dto.request.PhoneDto;
import com.afigueredo.personApi.entity.Phone;
import com.afigueredo.personApi.enums.PhoneType;

public class PhoneUtils {

    private static final String PHONE_NUMBER = "1199999-9999";
    private static final PhoneType PHONE_TYPE = PhoneType.MOBILE;
    private static final long PHONE_ID = 1L;

    public static PhoneDto createFakeDTO() {
        return PhoneDto.builder()
                .number(PHONE_NUMBER)
                .phoneType(PHONE_TYPE)
                .build();
    }

    public static Phone createFakeEntity() {
        return Phone.builder()
                .id(PHONE_ID)
                .number(PHONE_NUMBER)
                .phoneType(PHONE_TYPE)
                .build();
    }
}
