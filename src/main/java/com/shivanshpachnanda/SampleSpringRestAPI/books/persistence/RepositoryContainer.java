package com.shivanshpachnanda.SampleSpringRestAPI.books.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryContainer extends JpaRepository<Books_Entity, Long> {
    @Query("Select 0 as id,'' as name,author, count(*) as price from Books_Entity group by author")
    List<Books_Entity> groupByAuthor();

//    @Query("Select * from Books_Entity order by ?")
//    List<Books_Entity> orderByFindAll(String order);
}
