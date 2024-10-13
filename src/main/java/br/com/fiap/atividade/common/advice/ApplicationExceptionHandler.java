package br.com.fiap.atividade.common.advice;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String> invalidArguments(MethodArgumentNotValidException e){
        Map<String,String> mapaDeErro = new HashMap<>();
        List<FieldError> campos = e.getBindingResult().getFieldErrors();

        for (FieldError campo: campos){
            mapaDeErro.put(campo.getField(),campo.getDefaultMessage());
        }
        return mapaDeErro;
    }
}
