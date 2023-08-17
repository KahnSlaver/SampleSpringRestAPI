package com.shivanshpachnanda.SampleSpringRestAPI.books.service;

import com.shivanshpachnanda.SampleSpringRestAPI.books.persistence.Books_Entity;
import com.shivanshpachnanda.SampleSpringRestAPI.books.persistence.RepositoryContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class BooksService {

    @Autowired
    RepositoryContainer repositoryContainer;

    

    public Optional<Books_Entity> FindMaxPrice() {
        return Optional.ofNullable(repositoryContainer.findAll().stream()
                .reduce(null, (expensiveBook, nestBook) -> expensiveBook.getPrice() < nestBook.getPrice() ?
                        nestBook : expensiveBook));
    }

    public Long CountEntries() {
        return repositoryContainer.count();
    }

    public String PopularAuthor() {
        return repositoryContainer.groupByAuthor().stream()
                .reduce(new Books_Entity(),(expensiveBook,nestBook)->expensiveBook.getPrice()< nestBook.getPrice()?
                        nestBook:expensiveBook).getAuthor();
    }

    public Optional<Books_Entity> FindById(Long id){
        return repositoryContainer.findById(id);
    }

    public void Update(Books_Entity booksEntity) {
        repositoryContainer.save(booksEntity);
    }

    public void Delete(Long id) throws NoSuchElementException //Needs more work done
    {
        Optional<Books_Entity> books_entity = repositoryContainer.findById(id);
        books_entity.ifPresentOrElse(books_Entity -> repositoryContainer.delete(books_Entity),
                                        ()->{throw new NoSuchElementException();});
    }

    public List<Books_Entity> findAll(String sort,String direction)
    {
        return repositoryContainer.findAll(Sort.by(getSortDirection(direction),sort));
    }

    private Sort.Direction getSortDirection(String direction) {
        if (direction.equalsIgnoreCase("desc")) {
            return Sort.Direction.DESC;
        }else {
            return Sort.Direction.ASC;
        }
    }

    public void DeleteAll()
    {
        repositoryContainer.deleteAll();
    }
}
