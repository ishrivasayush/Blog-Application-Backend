package org.narainox.blog.application.backend.exception;
import org.narainox.blog.application.backend.payloads.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> resourceNotFoundException(ResourceNotFoundException resourceNotFoundException)
    {
        String message = resourceNotFoundException.getMessage();
        ApiResponse apiResponse=new ApiResponse(message,false);
        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handleMethodArgsNotValidException(MethodArgumentNotValidException methodArgumentNotValidException)
    {
        /*
        String message = methodArgumentNotValidException.getMessage();
        ApiResponse apiResponse=new ApiResponse(message,false);
        return new ResponseEntity<>(apiResponse,HttpStatus.BAD_REQUEST);

         */

        Map<String,String> resp=new HashMap<>();
        methodArgumentNotValidException.getBindingResult().getAllErrors().forEach((error)->{
            String fieldName =((FieldError) error).getField();
            String message=error.getDefaultMessage();
            resp.put(fieldName,message);
        });
        return new ResponseEntity<>(resp,HttpStatus.BAD_REQUEST);
    }
}
