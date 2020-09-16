package io.github.deogicorgi.spring.jpa.entity.enums;

import io.github.deogicorgi.spring.jpa.exception.EnumNotFoundException;
import lombok.Getter;

import java.util.Arrays;

/**
 * Enum class for member's gender
 */
@Getter
public enum Gender {
    MALE(1, "남성", "male"),
    FEMALE(2, "여성", "female"),
    ETC(3, "기타", "etc");

    /**
     * Code stored in the database.
     * male : 1, female : 2, etc : 3
     */
    private final Integer code;

    /**
     * Korean code for gender.
     * male : 남성, female : 여성, etc : 기타
     */
    private final String koreanCode;

    /**
     * English code for gender.
     */
    private final String englishCode;

    Gender(Integer code, String koreanCode, String englishCode) {
        this.code = code;
        this.koreanCode = koreanCode;
        this.englishCode = englishCode;
    }

    /**
     * Convert the database code to enum.
     * @param code (The code stored in the database.)
     * @return Gender enum
     * @throws EnumNotFoundException
     */
    public static Gender ofCode(Integer code) throws EnumNotFoundException {
        return Arrays.stream(Gender.values())
                .filter(gender -> gender.getCode().equals(code))
                .findAny()
                .orElseThrow(EnumNotFoundException::new);
    }
}
