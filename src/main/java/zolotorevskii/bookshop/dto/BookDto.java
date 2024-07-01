package zolotorevskii.bookshop.dto;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class BookDto {
    private String isbn;
    private String name;
    private String author;
}
