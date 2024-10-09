package co.istad.mvc.controller;

import co.istad.mvc.database.StaticDatabase;
import co.istad.mvc.domain.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final StaticDatabase staticDb;

    @ResponseBody
    @GetMapping("/search")
    public List<Book> searchBookByTitle(
            @RequestParam(name = "k", required = false, defaultValue = "") String keyword,
            @RequestParam(required = false) Boolean status
    ) {
        return staticDb
                .getBooks()
                .stream()
                .filter(book -> {
                            if (status != null) {
                                return book
                                        .getTitle()
                                        .toLowerCase()
                                        .contains(keyword.toLowerCase())
                                        && book.getStatus().equals(status);
                            }
                            return book
                                    .getTitle()
                                    .toLowerCase()
                                    .contains(keyword.toLowerCase());
                        }
                )
                .collect(Collectors.toList());
    }


    @ResponseBody
    @GetMapping("/{code}")
    public Book getBookByCode(@PathVariable("code") String c) {
        System.out.println("Code: " + c);
        return staticDb.getBooks()
                .stream()
                .filter(b -> b.getCode().equals(c))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Book not found"));
    }


    @ResponseBody
    @GetMapping
    public List<Book> getBook() {
        return staticDb.getBooks();
    }


    @GetMapping("/view")
    public String viewBook(Model model) {

        Book book = staticDb.getBooks().getFirst();

        model.addAttribute("book", book);

        return "book";
    }

}
