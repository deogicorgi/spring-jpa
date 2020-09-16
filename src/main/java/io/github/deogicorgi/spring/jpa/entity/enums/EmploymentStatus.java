package io.github.deogicorgi.spring.jpa.entity.enums;

import io.github.deogicorgi.spring.jpa.exception.EnumNotFoundException;
import lombok.Getter;

import java.util.Arrays;

/**
 * Enum class for member's employment status.
 */
@Getter
public enum EmploymentStatus {
    ONBOARDING(1, "입사자", "onboarding"),
    OFFBOARDING(0, "퇴사자", "offboarding");

    /**
     * Code stored in the database.
     * onboarding : 1, offboarding : 2
     */
    private final Integer code;

    /**
     * Korean code for employment status.
     * onboarding : 입사자, offboarding : 퇴사자
     */
    private final String koreanCode;

    /**
     * English code for employment status.
     */
    private final String englishCode;

    EmploymentStatus(Integer code, String koreanCode, String englishCode) {
        this.code = code;
        this.koreanCode = koreanCode;
        this.englishCode = englishCode;
    }

    /**
     * Convert the database code to enum.
     * @param code (The code stored in the database.)
     * @return EmploymentStatus enum
     * @throws EnumNotFoundException
     */
    public static EmploymentStatus ofCode(Integer code) throws EnumNotFoundException {
        return Arrays.stream(EmploymentStatus.values())
                .filter(employmentStatus -> employmentStatus.getCode().equals(code))
                .findAny()
                .orElseThrow(EnumNotFoundException::new);
    }
}
