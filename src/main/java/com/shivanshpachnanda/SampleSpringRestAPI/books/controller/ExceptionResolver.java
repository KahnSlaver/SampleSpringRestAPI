package com.shivanshpachnanda.SampleSpringRestAPI.books.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class ExceptionResolver {

    @ExceptionHandler(NoSuchElementException.class)
    public String RedirectMain()
    {
        return "redirect:http://localhost:8080/books/form/del";
    }
}
