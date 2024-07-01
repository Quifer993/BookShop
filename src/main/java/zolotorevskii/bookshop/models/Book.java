package zolotorevskii.bookshop.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(name = "book")
public class Book {
    @Id
    private String isbn;
    @Column( nullable = false)
    private String name;
    @Column( nullable = false)
    private String author;
}
