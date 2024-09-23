package co.istad.mvc.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// POJO = Plain Old Java Object
@Getter
@Setter
@NoArgsConstructor
public class Book {
    private Integer id;
    private String code;
    private String title;
    private String description;
    private String thumbnail;
    private Boolean status;
}
