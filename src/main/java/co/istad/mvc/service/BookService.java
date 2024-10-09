package co.istad.mvc.service;

import co.istad.mvc.dto.BookResponse;

import java.util.List;

public interface BookService {

    //searchBookByTitleOrStatus
    //return type
    //parameter (data)
    List<BookResponse> searchBookByTitleOrStatus(String title, Boolean status);

    //getBookByCode
    BookResponse getBookByCode(String code);

    //getBooks
    List<BookResponse> getBooks();

}
