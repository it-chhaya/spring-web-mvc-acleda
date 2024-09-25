package co.istad.mvc.controller;

import co.istad.mvc.domain.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class BookController {

    @ResponseBody
    @GetMapping("/books")
    public Book getBook() {
        Book book = new Book();
        book.setId(1);
        book.setCode("B-001");
        book.setTitle("Avenger");
        book.setDescription("Description");
        book.setThumbnail("/img/01.png");
        book.setStatus(true);

        return book;
    }

    @GetMapping("/books/view")
    public String viewBook(Model model) {

        Book book = new Book();
        book.setId(1);
        book.setCode("B-001");
        book.setTitle("Avenger");
        book.setDescription("Description");
        book.setThumbnail("/img/01.png");
        book.setStatus(true);

        model.addAttribute("book", book);

        return "book";
    }

}
