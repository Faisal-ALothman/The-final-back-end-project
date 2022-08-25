package com.example.patscars.advise;


import com.example.patscars.dto.ApiResponse;
import com.example.patscars.exception.Apiexception;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvise {
    @ExceptionHandler(value = Apiexception.class)
    public ResponseEntity apiException(Apiexception apiexception) {
        return ResponseEntity.status(400).body(new ApiResponse(apiexception.getMessage(), 400));
    }
}