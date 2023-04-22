package com.example.myrestfulservices.helloWorld;

// lombok 
import lombok.Data;
import lombok.AllArgsConstructor;


@Data  // 모든 API를 설정해줌
@AllArgsConstructor  // 생성자(setter, getter)가 자동으로 생성됨
public class HelloWorldBean {
    private String message;  
}
