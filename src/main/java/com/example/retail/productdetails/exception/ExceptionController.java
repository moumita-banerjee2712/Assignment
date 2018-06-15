package com.example.retail.productdetails.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

@ControllerAdvice
@RestController
public class ExceptionController {

    @ExceptionHandler( value = NullPointerException.class)
    public @ResponseBody ExceptionObject handleException(NullPointerException ex)
    {
        ExceptionObject exception = new ExceptionObject();
        exception.setCode(101);
        exception.setClassname(ex.getClass().getSimpleName());
        exception.setMessage("Null Pointer Exception");
        return  exception;

    }

    @ExceptionHandler( value = HttpClientErrorException.class)
    public @ResponseBody ExceptionObject handleException(HttpClientErrorException ex)
    {
        ExceptionObject exception = new ExceptionObject();
        exception.setCode(102);
        exception.setClassname(ex.getClass().getSimpleName());
        exception.setMessage("Data Not Found in Rest Webservice");
        return  exception;

    }

    @ExceptionHandler( value = RuntimeException.class)
    public @ResponseBody ExceptionObject handleException(RuntimeException ex)
    {
        ExceptionObject exception = new ExceptionObject();
        exception.setCode(103);
        exception.setClassname(ex.getClass().getSimpleName());
        exception.setMessage("Data Not Found in NoSql Database");
        return  exception;

    }
}
