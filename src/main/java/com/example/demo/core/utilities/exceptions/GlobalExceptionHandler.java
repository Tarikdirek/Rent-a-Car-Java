package com.example.demo.core.utilities.exceptions;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.swing.tree.DefaultTreeCellEditor;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Configuration
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public HashMap<List<String>,List<String>> handleValidationError(MethodArgumentNotValidException exception){

        List<String> errors = exception.getBindingResult().getAllErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .toList();

        List<String> fields = exception.getBindingResult().getFieldErrors().stream().map(FieldError::getField).collect(Collectors.toList());

        HashMap<List<String>,List<String>> fieldAndErrors = new HashMap<>();
         fieldAndErrors.put(errors,fields);

        return  fieldAndErrors;
    }

    @ExceptionHandler({RuntimeException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleRuntimeException(Exception exception){

        return exception.getMessage();
    }

    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleError(Exception exception){
        return "Something goes wrong ";
    }
}
