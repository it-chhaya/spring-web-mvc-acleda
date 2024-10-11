package co.istad.mvc.service.impl;

import co.istad.mvc.database.StaticDatabase;
import co.istad.mvc.domain.Book;
import co.istad.mvc.dto.BookResponse;
import co.istad.mvc.dto.CreateBookRequest;
import co.istad.mvc.mapper.BookMapper;
import co.istad.mvc.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final StaticDatabase staticDb;
    private final BookMapper bookMapper;

    @Override
    public BookResponse saveBook(CreateBookRequest createBookRequest) {

        // Transform data from DTO to Domain Model (DTO Pattern)
        Book book = bookMapper.fromCreateBookRequest(createBookRequest);

        // Write system logic
        Random random = new Random();
        book.setId(random.nextInt());
        book.setCode("B-" + book.getId());
        book.setStatus(true);

        // Validate
        // Validate ID (check exist or not)
        boolean isExisted = staticDb
                .getBooks()
                .stream()
                .anyMatch(b -> b.getId().equals(book.getId()));

        if (isExisted) {
            throw new ResponseStatusException(HttpStatus.CONFLICT,
                    "Book ID already exists");
        }

        // Validate Book Code
        boolean isCodeExisted = staticDb
                .getBooks()
                .stream()
                .anyMatch(b -> b.getCode().equals(book.getCode()));

        if (isCodeExisted) {
            throw new ResponseStatusException(HttpStatus.CONFLICT,
                    "Book code already exists");
        }

        staticDb.getBooks().add(book);

        return bookMapper.toBookResponse(book);
    }


    @Override
    public List<BookResponse> searchBookByTitleOrStatus(String title, Boolean status) {
        return staticDb
                .getBooks()
                .stream()
                .filter(book -> {
                            if (status != null) {
                                return book
                                        .getTitle()
                                        .toLowerCase()
                                        .contains(title.toLowerCase())
                                        && book.getStatus().equals(status);
                            }
                            return book
                                    .getTitle()
                                    .toLowerCase()
                                    .contains(title.toLowerCase());
                        }
                )
                .map(book -> BookResponse.builder()
                        .code(book.getCode())
                        .title(book.getTitle())
                        .description(book.getDescription())
                        .thumbnail(book.getThumbnail())
                        .status(book.getStatus())
                        .build()
                )
                .collect(Collectors.toList());
    }


    @Override
    public BookResponse getBookByCode(String code) {
        return staticDb.getBooks()
                .stream()
                .filter(b -> b.getCode().equals(code))
                .map(book -> BookResponse.builder()
                        .code(book.getCode())
                        .title(book.getTitle())
                        .description(book.getDescription())
                        .thumbnail(book.getThumbnail())
                        .status(book.getStatus())
                        .build()
                )
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Book not found"));
    }


    @Override
    public List<BookResponse> getBooks() {
        return staticDb.getBooks()
                .stream()
                .map(book -> BookResponse.builder()
                        .code(book.getCode())
                        .title(book.getTitle())
                        .description(book.getDescription())
                        .thumbnail(book.getThumbnail())
                        .status(book.getStatus())
                        .build()
                )
                .toList();
    }

}
