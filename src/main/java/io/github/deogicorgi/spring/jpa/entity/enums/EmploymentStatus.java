package io.github.deogicorgi.spring.jpa.entity.enums;

import lombok.Getter;

@Getter
public enum EmploymentStatus {
    YES(1, "예", "Y"),
    NO(0, "아니오", "N");

    private Integer code;
    private String name;
    private String eName;

    EmploymentStatus(Integer code, String name, String eName) {
        this.code = code;
        this.name = name;
        this.eName = eName;
    }
}
