package io.github.deogicorgi.spring.jpa.entity.enums.converter;

import javax.persistence.AttributeConverter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Localdate fields and column converter.
 */
public class BirthdayConverter implements AttributeConverter<LocalDate, String> {

    /**
     * Convert the birthday field of an entity to a column in the database.
     *
     * @param birthday
     * @return birthday yyyy-mm-dd
     */
    @Override
    public String convertToDatabaseColumn(LocalDate birthday) {
        return birthday.toString();
    }

    /**
     * Convert the birthday column of a database to an entity field.
     *
     * @param databaseCode yyyy-mm-dd
     * @return localdate
     */
    @Override
    public LocalDate convertToEntityAttribute(String databaseCode) {
        return LocalDate.parse(databaseCode, DateTimeFormatter.ISO_DATE);
    }
}
