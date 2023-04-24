package com.example.myrestfulservices.user;

// lombok 
import lombok.Data;

import java.util.Date;

import lombok.AllArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
public class User {
    private Integer id;

    @Size(min = 2, message= "Name은 2글자 이상 입력해 주세요.")
    private String name;

    @Past
    @NotNull
    private Date joinDate;
}
