package com.example.myrestfulservices.user;

// lombok 
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import lombok.AllArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;

@Data
@AllArgsConstructor
@NoArgsConstructor
// @JsonIgnoreProperties(value={"password", "ssn"}) // return 값에서 무시됨
// @JsonFilter
@Schema(description = "User 객체입니다.")
public class User {
    private Integer id;

    @Schema(description = "이름을 입력해주세요.")
    @Size(min = 2, message= "Name은 2글자 이상 입력해 주세요.")
    private String name;

    @Past
    @NotNull
    private Date joinDate;

    private String password;
    private String ssn;
}
