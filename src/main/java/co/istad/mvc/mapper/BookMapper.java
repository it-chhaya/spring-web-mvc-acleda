package co.istad.mvc.mapper;

import co.istad.mvc.domain.Book;
import co.istad.mvc.dto.BookResponse;
import co.istad.mvc.dto.CreateBookRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BookMapper {

    // Target Datasource (Target Source)
    // Original Datasource (Source)
    Book fromCreateBookRequest(CreateBookRequest createBookRequest);

    BookResponse toBookResponse(Book book);

}
