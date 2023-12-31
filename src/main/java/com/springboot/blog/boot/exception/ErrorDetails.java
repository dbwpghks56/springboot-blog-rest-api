package com.springboot.blog.boot.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ErrorDetails {
    private Date timestamp;
    private String message;
    private String details;
}
