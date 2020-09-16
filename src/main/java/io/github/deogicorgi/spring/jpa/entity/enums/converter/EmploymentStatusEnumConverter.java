package io.github.deogicorgi.spring.jpa.entity.enums.converter;

import io.github.deogicorgi.spring.jpa.entity.enums.EmploymentStatus;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Converter for converting the 'employment_status' column of the database and the 'employmentStatus' field of the entity.
 * @see EmploymentStatus
 */
@Converter
public class EmploymentStatusEnumConverter implements AttributeConverter<EmploymentStatus, Integer> {
    @Override
    public Integer convertToDatabaseColumn(EmploymentStatus attribute) {
        return null;
    }

    @Override
    public EmploymentStatus convertToEntityAttribute(Integer dbData) {
        return null;
    }
}
