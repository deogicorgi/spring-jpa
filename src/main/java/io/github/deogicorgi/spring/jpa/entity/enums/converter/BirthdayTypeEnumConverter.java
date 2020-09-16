package io.github.deogicorgi.spring.jpa.entity.enums.converter;

import io.github.deogicorgi.spring.jpa.entity.enums.BirthdayType;
import io.github.deogicorgi.spring.jpa.exception.EnumNotFoundException;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Converter for converting the 'birthday_type' column of the database and the 'birthdayType' field of the entity.
 * @see BirthdayType
 */
@Converter
public class BirthdayTypeEnumConverter implements AttributeConverter<BirthdayType, Integer> {

    /**
     * Convert the gender field of an entity to database code.
     * @param birthdayType
     * @return The code stored in database.
     */
    @Override
    public Integer convertToDatabaseColumn(BirthdayType birthdayType) {
        return birthdayType.getCode();
    }

    /**
     * Convert the birthdaytype code of the database to the entity field.
     * @param databaseCode
     * @return birthdaytype
     */
    @Override
    public BirthdayType convertToEntityAttribute(Integer databaseCode) {
        BirthdayType birthdayType = null;
        try {
            birthdayType = BirthdayType.ofCode(databaseCode);
        } catch (EnumNotFoundException e) {
            e.printStackTrace();
        }
        return birthdayType;
    }
}
