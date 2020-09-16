package io.github.deogicorgi.spring.jpa.entity.enums.converter;

import io.github.deogicorgi.spring.jpa.entity.enums.EmploymentStatus;
import io.github.deogicorgi.spring.jpa.exception.EnumNotFoundException;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Converter for converting the 'employment_status' column of the database and the 'employmentStatus' field of the entity.
 * @see EmploymentStatus
 */
@Converter
public class EmploymentStatusEnumConverter implements AttributeConverter<EmploymentStatus, Integer> {

    /**
     * Convert the employment status field of an entity to database code.
     * @param employmentStatus
     * @return The code stored in database.
     */
    @Override
    public Integer convertToDatabaseColumn(EmploymentStatus employmentStatus) {
        return employmentStatus.getCode();
    }

    /**
     * Convert the employment status code of the database to the entity field.
     * @param databaseCode
     * @return employment status
     */
    @Override
    public EmploymentStatus convertToEntityAttribute(Integer databaseCode) {
        EmploymentStatus employmentStatus = null;
        try {
            employmentStatus = EmploymentStatus.ofCode(databaseCode);
        } catch (EnumNotFoundException e) {
            e.printStackTrace();
        }
        return employmentStatus;
    }
}
