package co.istad.mvc.controller;

import co.istad.mvc.domain.Book;
import co.istad.mvc.dto.BookResponse;
import co.istad.mvc.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
public class BookRestController {

    private final BookService bookService;

    @GetMapping("/search")
    public List<BookResponse> searchBookByTitle(
            @RequestParam(name = "k", required = false, defaultValue = "") String keyword,
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
