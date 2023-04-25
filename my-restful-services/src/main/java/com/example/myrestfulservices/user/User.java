package com.example.myrestfulservices.user;

// lombok 
import lombok.Data;

import java.util.Date;

import lombok.AllArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Data
@AllArgsConstructor
// @JsonIgnoreProperties(value={"password", "ssn"}) // return 값에서 무시됨
@JsonFilter("UserInfo")
public class User {
    private Integer id;

    @Size(min = 2, message= "Name은 2글자 이상 입력해 주세요.")
    private String name;

    @Past
    @NotNull
    private Date joinDate;

    private String password;
    private String ssn;
}
