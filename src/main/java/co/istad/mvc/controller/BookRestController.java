package co.istad.mvc.controller;

import co.istad.mvc.dto.BookResponse;
import co.istad.mvc.dto.CreateBookRequest;
import co.istad.mvc.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
public class BookRestController {

    private final BookService bookService;


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    BookResponse saveBook(@Valid @RequestBody CreateBookRequest createBookRequest) {
        return bookService.saveBook(createBookRequest);
    }


    @GetMapping("/search")
    public List<BookResponse> searchBookByTitle(
            @RequestParam(name = "k") String keyword,
            @RequestParam(required = false) Boolean status
    ) {
        return bookService.searchBookByTitleOrStatus(keyword, status);
    }


    @GetMapping("/{code}")
    public BookResponse getBookByCode(@PathVariable("code") String c) {
        return bookService.getBookByCode(c);
    }


    @GetMapping
    public List<BookResponse> getBooks() {
        return bookService.getBooks();
    }

}
