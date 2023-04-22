package com.example.myrestfulservices.user;

// lombok 
import lombok.Data;

import java.util.Date;

import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class User {
    private Integer id;
    private String name;
    private Date joinDate;
}
