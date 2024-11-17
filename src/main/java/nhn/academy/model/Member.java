package nhn.academy.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.time.LocalDate;

public class Member {
    private String name;
    private Integer age;
    @JsonSerialize(using = ToStringSerializer.class)
    @JsonProperty("class")
    private ClassType clazz;

    private LocalDate createdAt = LocalDate.now();
    public Member(String name, Integer age, ClassType clazz) {
        this.name = name;
        this.age = age;
        this.clazz = clazz;

    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public ClassType getClazz() {
        return clazz;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }
}
