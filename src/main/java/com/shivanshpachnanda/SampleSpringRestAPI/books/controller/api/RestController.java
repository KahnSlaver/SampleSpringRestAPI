package com.shivanshpachnanda.SampleSpringRestAPI.books.controller.api;

import com.shivanshpachnanda.SampleSpringRestAPI.books.persistence.Books_Entity;
import com.shivanshpachnanda.SampleSpringRestAPI.books.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller //This means that this class will not be dealing with jsp pages like string at least
@RequestMapping("/books")
public class RestController {
    @Autowired
    BooksService booksService;

    @GetMapping
    public String RedirectMain(){
        return "redirect:http://localhost:8080/books/api";
    }

    @GetMapping("/api") @ResponseBody
    public List<Books_Entity> ListAll(@RequestParam(defaultValue = "id") String sort,
                                      @RequestParam(defaultValue = "asc") String direction) {
        return booksService.findAll(sort,direction);
    }

    @DeleteMapping("/api/{id}") @ResponseBody
    public void DeleteAll(@PathVariable Long id) {

    }

    @GetMapping("/api/{id}") @ResponseBody
    public Books_Entity findById(@PathVariable Long id) {
        return booksService.FindById(id).orElseGet(Books_Entity::new);
    }

    @PostMapping("/api")
    public String InsertList(@Valid @ModelAttribute("book") Books_Entity books_entity,
                             BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return "Form";
        else{
            booksService.Update(books_entity);
            return "redirect:http://localhost:8080/books/api";
        }
    }

    @PostMapping("/api/del")
    public String DeleteRecord(@RequestParam Long id){
        booksService.Delete(id);
        return "redirect:http://localhost:8080/books/api";
    }
}
