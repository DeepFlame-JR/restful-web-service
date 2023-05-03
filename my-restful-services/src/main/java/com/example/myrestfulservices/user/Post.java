package com.example.myrestfulservices.user;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue
    private Integer id;

    private String description;

    // User : Post = 1 : N
    // LAZY: posting 데이터가 로딩되는 시점에 user를 가져온다
    @ManyToOne(fetch = FetchType.LAZY)
    // json으로 전달할 때 표시되지 않음
    @JsonIgnore
    private User user;
}
