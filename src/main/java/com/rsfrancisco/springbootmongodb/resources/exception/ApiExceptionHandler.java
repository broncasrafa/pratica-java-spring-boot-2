package com.rsfrancisco.springbootmongodb.resources.exception;

import com.rsfrancisco.springbootmongodb.application.exceptions.ObjectNotFoundException;
import com.rsfrancisco.springbootmongodb.resources.models.ApiResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<ApiResponse<StandardError>> objectNotFound(ObjectNotFoundException exception, HttpServletRequest request) {
        String msgErr = "Object not found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError error = new StandardError(status.value(), msgErr, exception.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(ApiResponse.failure(error));
    }
}
