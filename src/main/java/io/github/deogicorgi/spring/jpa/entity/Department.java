package io.github.deogicorgi.spring.jpa.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Table(name = "department")
public class Department {
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
}
