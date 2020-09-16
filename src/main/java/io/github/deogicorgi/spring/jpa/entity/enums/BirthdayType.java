package io.github.deogicorgi.spring.jpa.entity.enums;

import io.github.deogicorgi.spring.jpa.exception.EnumNotFoundException;
import lombok.Getter;

import java.util.Arrays;

/**
 * birthday type enum (solar calendar, lunar calendar)
 */
@Getter
public enum BirthdayType {

    SOLAR(1, "양력", "solar"),
    LUNAR(2, "음력", "lunar");

    /**
     * Code stored in the database.
     * solar : 1, lunar : 2
     */
    private final Integer code;

    /**
     * Korean code for birthday type.
     * solar : 양력, lunar : 음력
     */
    private final String koreanCode;

    /**
     * English code for birthday type..
     */
    private final String englishCode;

    BirthdayType(Integer code, String koreanCode, String englishCode) {
        this.code = code;
        this.koreanCode = koreanCode;
        this.englishCode = englishCode;
    }

    /**
     * Convert the database code to enum.
     * @param code (The code stored in the database.)
     * @return BirthdayType enum
     * @throws EnumNotFoundException
     */
    public static BirthdayType ofCode(Integer code) throws EnumNotFoundException {
        return Arrays.stream(BirthdayType.values())
                .filter(gender -> gender.getCode().equals(code))
                .findAny()
                .orElseThrow(EnumNotFoundException::new);
    }
}
