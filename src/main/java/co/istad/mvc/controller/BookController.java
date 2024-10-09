package co.istad.mvc.controller;

import co.istad.mvc.database.StaticDatabase;
import co.istad.mvc.domain.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final StaticDatabase staticDb;


    @GetMapping("/view")
    public String viewBook(Model model) {

        Book book = staticDb.getBooks().getFirst();

        model.addAttribute("book", book);

        return "book";
    }

}
