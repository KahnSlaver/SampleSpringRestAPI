package com.shivanshpachnanda.SampleSpringRestAPI.books.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller @RequestMapping("/books/forms")
public class FormController {
    @GetMapping @ResponseBody
    public String Options(){
        return """
                From Here you have 2 options- <br>
                1) ./insertion<br>
                2) ./deletion<br>
                """;
    }

    @GetMapping("/insertion")
    public String showForm(){
        return "Form";
    } //we are currently linking it to api/books only since that is a post type http-endpoint

    @GetMapping("/deletion")
    public String showFormDel(){
        return "DeleteForm";
    }
}