package co.istad.mvc.repository;

import co.istad.mvc.domain.Book;

import java.util.List;

// Access data from database
public interface BookRepository {

    List<Book> findAll();

    Object executeProcedure(String procedureName, List<Object> param);

}
