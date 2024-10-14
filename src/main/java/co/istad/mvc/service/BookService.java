package co.istad.mvc.service;

import co.istad.mvc.dto.BookResponse;
import co.istad.mvc.dto.CreateBookRequest;
import co.istad.mvc.dto.UpdateBookRequest;

import java.util.List;

public interface BookService {


    BookResponse updateBookByCode(String code, UpdateBookRequest updateBookRequest);


    /**
     * <p>This function is used to save a book</p>
     * <p><b>Logic function</b></p>
     * @param createBookRequest is request data from client
     * @return BookResponse
     */
    BookResponse saveBook(CreateBookRequest createBookRequest);


    //searchBookByTitleOrStatus
    //return type
    //parameter (data)
    List<BookResponse> searchBookByTitleOrStatus(String title, Boolean status);

    //getBookByCode
    BookResponse getBookByCode(String code);

    //getBooks
    List<BookResponse> getBooks();

}
