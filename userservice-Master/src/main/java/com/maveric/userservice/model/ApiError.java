package com.maveric.userservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@Data
public class ApiError {
    private LocalDateTime timestamp;
    private HttpStatus status;
    private List<String> errors;
    private String message;
    private String path;
}
