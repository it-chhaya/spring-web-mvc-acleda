package co.istad.mvc.mapper;

import co.istad.mvc.domain.Book;
import co.istad.mvc.dto.BookResponse;
import co.istad.mvc.dto.CreateBookRequest;
import co.istad.mvc.dto.UpdateBookRequest;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface BookMapper {

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void fromUpdateBookRequest(@MappingTarget Book book, UpdateBookRequest updateBookRequest);

    // Target Datasource (Target Source)
    // Original Datasource (Source)
    Book fromCreateBookRequest(CreateBookRequest createBookRequest);

    BookResponse toBookResponse(Book book);

}
