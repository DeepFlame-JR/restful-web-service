package com.example.myrestfulservices.user;

// lombok 
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import io.swagger.v3.oas.annotations.media.Schema;

@Data
@AllArgsConstructor
@NoArgsConstructor
// @JsonIgnoreProperties(value={"password", "ssn"}) // return 값에서 무시됨
// @JsonFilter
@Schema(description = "User 객체입니다.")
@Entity
public class User {
    // DB에 테이블로 추가됨
    // Hibernate: create table user (id integer not null, join_date timestamp, name varchar(255), password varchar(255), ssn varchar(255), primary key (id))
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    // @Schema(description = "이름을 입력해주세요.")
    // @Size(min = 2, message= "Name은 2글자 이상 입력해 주세요.")
    // @NotNull
    private String name;

    @Past
    @NotNull
    private Date joindate;

    private String password;
    private String ssn;

    @OneToMany(mappedBy = "user")
    private List<Post> posts;

    public User(Integer id, String name, Date joindate, String password, String ssn) {
        this.id = id;
        this.name = name;
        this.joindate = joindate;
        this.password = password;
        this.ssn = ssn;
    }
}
