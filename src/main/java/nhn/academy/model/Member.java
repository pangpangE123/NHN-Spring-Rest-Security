package nhn.academy.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

public class Member {
    private String name;
    @JsonSerialize(using = ToStringSerializer.class)
    private Integer age;

    private String role;

    @JsonSerialize(using = ToStringSerializer.class)
    @JsonProperty("class")
    private ClassType clazz;

    public Member(String name, Integer age, String role ,ClassType clazz) {
        this.name = name;
        this.age = age;
        this.clazz = clazz;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getRole(){return role;}

    public ClassType getClazz() {
        return clazz;
    }
}
