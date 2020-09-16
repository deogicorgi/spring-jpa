package io.github.deogicorgi.spring.jpa.entity.enums.converter;

import io.github.deogicorgi.spring.jpa.entity.enums.Gender;
import io.github.deogicorgi.spring.jpa.exception.EnumNotFoundException;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Converter for converting the 'gender' column of the database and the 'gender' field of the entity.
 * @see Gender
 */
@Converter
public class GenderEnumConverter implements AttributeConverter<Gender, Integer> {

    /**
     * Convert the gender field of an entity to database code.
     * @param gender
     * @return The code stored in database.
     */
    @Override
    public Integer convertToDatabaseColumn(Gender gender) {
        return gender.getCode();
    }

    /**
     * Convert the gender code of the database to the entity field.
     * @param databaseCode
     * @return
     */
    @Override
    public Gender convertToEntityAttribute(Integer databaseCode) {
        Gender gender = null;
        try {
            gender = Gender.ofCode(databaseCode);
        } catch (EnumNotFoundException e) {
            e.printStackTrace();
        }
        return gender;
    }
}
