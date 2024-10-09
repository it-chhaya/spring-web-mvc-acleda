package co.istad.mvc.service.impl;

import co.istad.mvc.database.StaticDatabase;
import co.istad.mvc.domain.Book;
import co.istad.mvc.dto.BookResponse;
import co.istad.mvc.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final StaticDatabase staticDb;

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
