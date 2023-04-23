package com.example.myrestfulservices.exception;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// HTTP Status code
// 2XX > OK
// 4XX > Client
// 5XX > Server
// 예외 처리를 위한 클래스


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionResponse {
    private Date timestamp;
    private String message;
    private String details;
}
