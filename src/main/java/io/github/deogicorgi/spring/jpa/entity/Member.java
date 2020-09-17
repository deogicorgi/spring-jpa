package io.github.deogicorgi.spring.jpa.entity;

import io.github.deogicorgi.spring.jpa.entity.enums.BirthdayType;
import io.github.deogicorgi.spring.jpa.entity.enums.Gender;
import io.github.deogicorgi.spring.jpa.entity.enums.converter.BirthdayConverter;
import io.github.deogicorgi.spring.jpa.entity.enums.converter.BirthdayTypeEnumConverter;
import io.github.deogicorgi.spring.jpa.entity.enums.converter.GenderEnumConverter;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Class with main content for members
 */

@Data
@Entity
@Table(name = "member")
public class Member {
    /**
     * ID of the member.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Real name of the member.
     */
    @Column(nullable = false, length = 100)
    private String realName;

    /**
     * Stage name of the member.
     */
    @Column(length = 100)
    private String stageName;

    /**
     * Gender of the member.
     *
     * @see Gender
     */
    @Column(nullable = false)
    @Convert(converter = GenderEnumConverter.class)
    private Gender gender;

    /**
     * Age of the member.
     */
    @Column(nullable = false)
    private Integer age;

    /**
     * Birthday of member.
     */
    @Column(nullable = false, length = 40)
    @Convert(converter = BirthdayConverter.class)
    private LocalDate birthday;

    /**
     * Birthday type of member. (solar calendar or lunar calendar)
     */
    @Column(nullable = false, length = 3)
    @Convert(converter = BirthdayTypeEnumConverter.class)
    private BirthdayType birthdayType;

    /**
     * Member's team
     */
    @ManyToOne
    @JoinColumn(name = "team_id", nullable = false)
    private Team team;
}