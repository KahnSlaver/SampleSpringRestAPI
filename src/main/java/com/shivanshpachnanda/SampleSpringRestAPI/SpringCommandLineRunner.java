package com.shivanshpachnanda.SampleSpringRestAPI;

import com.shivanshpachnanda.SampleSpringRestAPI.books.persistence.Books_Entity;
import com.shivanshpachnanda.SampleSpringRestAPI.books.persistence.RepositoryContainer;
import com.shivanshpachnanda.SampleSpringRestAPI.books.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SpringCommandLineRunner implements CommandLineRunner {
    @Autowired
    BooksService booksService;
    @Override
    public void run(String... args) throws Exception {
        booksService.Update(new Books_Entity(1,"Book1","Author1",150));
        booksService.Update(new Books_Entity(2,"Book2","Author2",20));
        booksService.Update(new Books_Entity(3,"Book3","Author3",15));
        booksService.Update(new Books_Entity(4,"Book4","Author4",40));

    }

}
